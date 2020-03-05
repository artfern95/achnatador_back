package com.dam.achantador.service;

import com.dam.achantador.dao.usuariosRepository;
import com.dam.achantador.entity.usuarios;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class usuariosServiceImple implements usuariosService{

    @Autowired
    private usuariosRepository usuariosRepository;

    //guardar

    @Override
    public usuarios guardar(usuarios usuarios) {

        return usuariosRepository.save(usuarios);
    }

    //borrar

    @Override
    public void borrar(Integer id) {
        usuariosRepository.deleteById(id);
    }

    @Override
    public void borrarTodo() {
        usuariosRepository.deleteAll();
    }

    //buscar

    @Override
    public List<usuarios> listarPorPuntos() {
        return usuariosRepository.findAll(
                Sort.by(Sort.Direction.ASC,"puntos")
        );
    }

    @Override
    public List<usuarios> listarPornombre() {
        return null;
    }

    @Override
    public List<usuarios> listar() {

        log.info("listando usuarios");
        return usuariosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public usuarios buscarPorId(Integer id) {

        if(usuariosRepository.existsById(id)){

            log.info("buscando usuario con id: " + id);
            return usuariosRepository.findById(id).get();
        }

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<usuarios> buscarPorNombre(String nombre) {
        return usuariosRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<usuarios> buscarPorApellido(String apelllido) {
        return usuariosRepository.findByApellidoContainingIgnoreCase(apelllido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<usuarios> buscarPorValidador() {
        return usuariosRepository.findByValidador(true);
    }
}
