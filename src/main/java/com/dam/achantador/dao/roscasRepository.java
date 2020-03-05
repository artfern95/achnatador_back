package com.dam.achantador.dao;

import com.dam.achantador.entity.roscas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface roscasRepository extends JpaRepository<roscas, Integer> {

    @Query(value = "SELECT * FROM roscas WHERE roscas.perpetrador = ?;", nativeQuery =  true)
    List<roscas> findByPerpetrador (Integer id);
}
