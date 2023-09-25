package com.example.demo.service;

import org.modelmapper.ModelMapper;

import com.example.demo.model.auto;
import com.example.demo.model.autoDTO;
import com.example.demo.model.duenio;
import com.example.demo.model.duenioDTO;
import com.example.demo.repository.autoRepository;
import com.example.demo.repository.duenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class duenioService {

    @Autowired
    private duenioRepository dr;
    @Autowired
    private autoRepository ar;

    private final ModelMapper mm = new ModelMapper();

    public duenioService(duenioRepository dr, autoRepository ar){
        this.dr = dr;
        this.ar = ar;
    }
    public List<duenioDTO> getAll() {
        List<duenio> duenos = dr.findAll();
        List<duenioDTO> duenios = new ArrayList<>();
        for(duenio dueno: duenos) {
            duenioDTO duenio = new duenioDTO();
            duenio.setId(dueno.getId());
            duenio.setName(dueno.getName());
            duenio.setAutos(getDueniosAutos(dueno.getId()));
            duenios.add(duenio);
        }
        return duenios;
    }

    public ResponseEntity add(duenio d) {
        try {
            dr.save(d);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity update(Integer id, duenio d) {
        duenio du = dr.findById(id).get();
        du.setName(d.getName());
        dr.save(du);
        return ResponseEntity.status(OK).build();
    }

    public ResponseEntity delete(Integer id) {
        dr.deleteById(id);
        return ResponseEntity.status(OK).build();
    }

    public List<autoDTO> getDueniosAutos(Integer duenioId){
        List<autoDTO> autoList = new ArrayList<>();
        List<Integer> duenioAutos = dr.getDueniosAutos(duenioId);
        for(int x = 0; x < duenioAutos.size(); x++) {
            autoList.add(mm.map(ar.findById(x).get(), autoDTO.class));
        }
        return autoList;
    }

}
