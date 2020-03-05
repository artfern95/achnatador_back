package com.dam.achantador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "puntos")
    private Integer puntos = 0;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "createAT")
    private LocalDateTime createAT;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "ultima_mod")
    private LocalDateTime ultima_modificacion;

    @Column(name = "validador")
    private boolean validador = false;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,
                mappedBy = "perpetrador")
    private List<roscas> efectuados;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "usuarios_roscas", joinColumns = @JoinColumn(name = "victima"),
            inverseJoinColumns = @JoinColumn(name = "rosca"))
    private List<roscas> recibidos;

    //

    public usuarios() {
    }

    //Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getCreateAT() {
        return createAT;
    }

    @PrePersist
    public void setCreateAT() {
        this.createAT = LocalDateTime.now();
    }

    public LocalDateTime getUltima_modificacion() {
        return ultima_modificacion;
    }

    @PreUpdate
    public void setUltima_modificacion() {
        this.ultima_modificacion = LocalDateTime.now();
    }

    public boolean isValidador() {
        return validador;
    }

    public void setValidador(boolean validador) {
        this.validador = validador;
    }

    //getters y setters para roscas

    //recibidos

    public List<roscas> getRecibidos (){

        return recibidos;
    }

    public void addRecibidos (roscas rosca){

        if(recibidos == null){

            recibidos = new ArrayList<>();
        }

        if(!recibidos.contains(rosca)){

            recibidos.add(rosca);
            rosca.addVictima(this);
        }
    }

    public void removeRecibidos(roscas rosca){

        if(recibidos.contains(rosca)){

            recibidos.remove(rosca);
            rosca.removeVictima(this);

        }
    }

    //efectuados

    public List<roscas> getEfectuados (){

        return efectuados;
    }

    public void setEfectuados (roscas rosca){

        if(efectuados == null) {

         efectuados = new ArrayList<>();
        }

        if (efectuados.contains(rosca)) {

            efectuados.add(rosca);
            rosca.setPerpetrador(this);
        }
    }
}
