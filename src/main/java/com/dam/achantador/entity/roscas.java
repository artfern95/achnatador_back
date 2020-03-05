package com.dam.achantador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "roscas")
public class roscas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valoracion")
    private Integer valoracion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "fecha")
    private LocalDateTime fecha;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "usuarios_roscas", joinColumns = @JoinColumn(name = "rosca"),
            inverseJoinColumns = @JoinColumn(name = "victima"))
    private List<usuarios> victima;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "perpetrador")
    private usuarios perpetrador;

    @Column(name = "valido")
    private boolean valido = false;

    //cons

    public roscas() {
    }

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @PrePersist
    public void setFecha() {
        this.fecha = LocalDateTime.now();
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    //

    public List<usuarios> getVictima() {
        return victima;
    }

    public void addVictima(usuarios victima) {

        if(!this.victima.contains(victima)){

            this.victima.add(victima);
            victima.setEfectuados(this);
        }
    }

    public void removeVictima(usuarios victima){

        if(this.victima.contains(victima)){

            this.victima.remove(victima);
            victima.removeRecibidos(this );
        }
    }

    // perpetrador

    public usuarios getPerpetrador() {
        return perpetrador;
    }

    public void setPerpetrador(usuarios perpetrador) {
        this.perpetrador = perpetrador;
    }
}
