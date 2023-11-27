package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class duenio {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String birthday;
    private String country;
    @ManyToMany(mappedBy = "duenios")
    @JsonIgnore
    private List<auto> autos;
}
