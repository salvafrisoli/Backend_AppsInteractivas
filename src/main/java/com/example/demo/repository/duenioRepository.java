package com.example.demo.repository;

import com.example.demo.model.auto;
import com.example.demo.model.duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface duenioRepository extends JpaRepository<duenio, Integer> {
    @Query(value = "select auto_id from duenio_auto where duenio_id = :duenioId", nativeQuery = true)
    public List<Integer> getDueniosAutos(Integer duenioId);


}
