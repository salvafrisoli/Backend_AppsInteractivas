package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class duenioDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String birthday;
    private String country;
    private List<autoDTO> autos;
}
