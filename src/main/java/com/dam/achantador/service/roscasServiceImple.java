package com.dam.achantador.service;

import com.dam.achantador.dao.roscasRepository;
import com.dam.achantador.entity.roscas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class roscasServiceImple implements roscasService {

    @Autowired
    private roscasRepository roscasRepository;

    @Override
    public roscas guardar(roscas roscas) {
        return roscasRepository.save(roscas);
    }

    @Override
    public void borrar(Integer id) {
        roscasRepository.deleteById(id);
    }

    @Override
    public void borrarTodo() {
        roscasRepository.deleteAll();
    }

    @Override
    public roscas buscarPorId(Integer id) {

        if(roscasRepository.existsById(id)){

            return roscasRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public List<roscas> listar() {
        return roscasRepository.findAll();
    }

    @Override
    public List<roscas> buscarPorUsuario(Integer id) {
        return roscasRepository.findByPerpetrador(id);
    }
}
