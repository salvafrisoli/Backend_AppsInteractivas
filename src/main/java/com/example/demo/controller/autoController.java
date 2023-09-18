package com.example.demo.controller;

import com.example.demo.model.auto;
import com.example.demo.service.autoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auto")
@RestController
public class autoController {

    @Autowired
    private autoService as;

    @GetMapping("")
    public List<auto> getAll() {
        return as.getAll();
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody auto a){
        return as.add(a);
    }

//    @PostMapping("/{id}/update")
//    public ResponseEntity update(@PathVariable Integer id,@RequestBody auto a) {
//        return as.update(id,a);
//    }

    @PostMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Integer id) {
        return as.delete(id);
    }
}
