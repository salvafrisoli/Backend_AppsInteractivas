package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class autoDTO {
    private Integer id;
    private String name;
    private String date_fab;
    private String model;
}
