package com.dam.achantador.dao;

import com.dam.achantador.entity.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usuariosRepository extends JpaRepository<usuarios, Integer> {

    //

    List<usuarios> findByNombreContainingIgnoreCase (String nombre);

    List<usuarios> findByApellidoContainingIgnoreCase (String apellido);

    //



    List<usuarios> findByValidador (boolean b);
}
