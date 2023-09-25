package com.example.demo.controller;

import com.example.demo.model.auto;
import com.example.demo.model.duenio;
import com.example.demo.model.duenioDTO;
import com.example.demo.service.autoService;
import com.example.demo.service.duenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/duenio")
public class duenioController {

    @Autowired
    private duenioService ds;

    @GetMapping("")
    public List<duenioDTO> getAll() {
        return ds.getAll();
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody duenio d){
        return ds.add(d);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody duenio d) {
        return ds.update(id,d);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Integer id) {
        return ds.delete(id);
    }
}
