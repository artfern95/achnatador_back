package com.dam.achantador.controller;

import com.dam.achantador.entity.usuarios;
import com.dam.achantador.service.usuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private usuariosService usuariosService;

    /*GET*/

    @GetMapping
    public List<usuarios> listar(){

        return usuariosService.listar();
    }

    @GetMapping("/{key}")
    public usuarios buscarPorId (@PathVariable("key") Integer id){

        return usuariosService.buscarPorId(id);
    }

    @GetMapping("/nombre/{key}")
    public List<usuarios> buscarPorNombre (@PathVariable("key") String nombre){

        return usuariosService.buscarPorNombre(nombre);
    }

    @GetMapping("/apellido/{key}")
    public List<usuarios> buscarPorApellido (@PathVariable("key") String apellido){

        return usuariosService.buscarPorApellido(apellido);
    }

    @GetMapping("/validadores")
    public List<usuarios> validadores (){

        return usuariosService.buscarPorValidador();
    }

    @GetMapping("/ranking")
    public List<usuarios> rankingUsuarios (){

        return usuariosService.listarPorPuntos();
    }

    /*POST*/

    @PostMapping
    public usuarios guardar (@RequestBody  usuarios usuario){
        return usuariosService.guardar(usuario);
    }

    /*PUT*/

    @PutMapping
    public usuarios actualizar (@RequestBody  usuarios usuario){
        return usuariosService.guardar(usuario);
    }

    /*DELETE*/

    @DeleteMapping("/{key}")
    public void borrar (@PathVariable("key") Integer id){
        usuariosService.borrar(id);
    }

    @DeleteMapping
    public void borrarTodo (){
        usuariosService.borrarTodo();
    }
}
