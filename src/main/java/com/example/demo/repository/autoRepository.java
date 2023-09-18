package com.example.demo.repository;

import com.example.demo.model.auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface autoRepository extends JpaRepository<auto, Integer> {


}
