package com.dam.achantador.service;

import com.dam.achantador.entity.roscas;

import java.util.List;

public interface roscasService {

    roscas guardar(roscas roscas);

    void borrar(Integer id);

    void borrarTodo();

    List<roscas> listar ();

    roscas buscarPorId (Integer id);

    List<roscas> buscarPorUsuario (Integer id);
}
