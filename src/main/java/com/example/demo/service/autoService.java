package com.example.demo.service;

import com.example.demo.model.auto;
import com.example.demo.repository.autoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class autoService {

    @Autowired
    public autoRepository ar;

    public autoService(autoRepository ar){
        this.ar = ar;
    }
    public List<auto> getAll() {
        return ar.findAll();
    }


    public ResponseEntity add(auto a){
        try {
            ar.save(a);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }
    public ResponseEntity update(Integer id, auto a) {
        try {
            auto au = ar.findById(id).get();
            au.setName(a.getName());
            au.setModel(a.getModel());
            au.setDate_fab(a.getDate_fab());
            ar.save(au);
            return ResponseEntity.status(OK).build();

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }


    public ResponseEntity delete(Integer id) {
        try {
            ar.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

}
