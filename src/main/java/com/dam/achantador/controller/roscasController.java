package com.dam.achantador.controller;

import com.dam.achantador.entity.roscas;
import com.dam.achantador.service.roscasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roscas")
public class roscasController {

    @Autowired
    private roscasService roscasService;

    /*GET*/

    @GetMapping
    public List<roscas> listar (){

        return roscasService.listar();
    }

    @GetMapping("/{key}")
    public roscas buscarPorId (@PathVariable("key") Integer id){

        return roscasService.buscarPorId(id);
    }

    @GetMapping("/perpetrador/{key}")
    public List<roscas> buscarPorPerpetrador (@PathVariable("key") Integer id){

        return roscasService.buscarPorUsuario(id);
    }

    /*POST*/

    @PostMapping
    public roscas guardar (@RequestBody roscas roscas){
        return roscasService.guardar(roscas);
    }

    /*PUT*/

    @PutMapping
    public roscas actualizar(@RequestBody roscas roscas){
        return roscasService.guardar(roscas);
    }

    /*DELETE*/

    @DeleteMapping("/{key}")
    public void borrar (@PathVariable("key") Integer id){
        roscasService.borrar(id);
    }

    @DeleteMapping
    public void borrarTodo (){
        roscasService.borrarTodo();
    }
}
