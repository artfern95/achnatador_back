package com.dam.achantador.service;

import com.dam.achantador.entity.usuarios;

import java.util.List;

public interface usuariosService {

    usuarios guardar(usuarios usuarios);

    void borrar(Integer id);

    void borrarTodo();

    List<usuarios> listar ();

    List<usuarios> listarPorPuntos ();

    List<usuarios> listarPornombre ();

    usuarios buscarPorId (Integer id);

    List<usuarios> buscarPorNombre (String nombre);

    List<usuarios> buscarPorApellido (String apelllido);

    List<usuarios> buscarPorValidador ();
}
