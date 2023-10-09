package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class auto {
    @Id
    private Integer id;
    private String name;
    private String date_fab;
    private String model;
    @ManyToMany
    @JoinTable(name="duenio_auto", joinColumns = @JoinColumn(name = "auto_id"), inverseJoinColumns = @JoinColumn(name = "duenio_id"))
    private List<duenio> duenios;
}
