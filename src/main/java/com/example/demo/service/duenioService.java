package com.example.demo.service;

import com.example.demo.model.auto;
import com.example.demo.model.duenio;
import com.example.demo.repository.autoRepository;
import com.example.demo.repository.duenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Service
public class duenioService {

    @Autowired
    public duenioRepository dr;

    public duenioService(duenioRepository dr){
        this.dr = dr;
    }
    public List<duenio> getAll() {
        return dr.findAll();
    }

    public ResponseEntity add(duenio d){
        dr.save(d);
        return ResponseEntity.status(CREATED).build();
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

}
