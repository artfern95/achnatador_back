package com.dam.achantador.dao;

import com.dam.achantador.config.SpringConfiguration;
import com.dam.achantador.entity.roscas;
import com.dam.achantador.entity.usuarios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringConfiguration.class)
public class usuariosRepositoryTest {

    @Autowired
    private usuariosRepository usuariosRepository;

    @Autowired
    private roscasRepository roscasRepository;

    @Test
    public void testSaveMethod (){

        roscas rosca = roscasRepository.findById(1).get();

        usuarios usuarioTest = new usuarios();
        usuarioTest.setNombre("carlos");
        usuarioTest.setApellido("rico");
        usuarioTest.setCorreo("test5@test.com");
        usuarioTest.setPuntos(123);

        usuarioTest.addRecibidos(rosca);

        usuariosRepository.save(usuarioTest);

        Assertions.assertEquals(usuarioTest.getRecibidos().get(0).getId(), 1);
    }
}