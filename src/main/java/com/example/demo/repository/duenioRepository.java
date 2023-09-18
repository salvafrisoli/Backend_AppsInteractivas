package com.example.demo.repository;

import com.example.demo.model.auto;
import com.example.demo.model.duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface duenioRepository extends JpaRepository<duenio, Integer> {


}
