package com.hotella.backend.hotella.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="hoteis")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idHotel")
    private int idHotel;

    @Column(name="descricao")
    private String descricao;

    @Column(name="linkImagem")
    private String linkImagem;


    public Hotel() {

    }

    public Hotel(String descricao, String linkImagem) {
        this.descricao = descricao;
        this.linkImagem = linkImagem;

    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }
}
