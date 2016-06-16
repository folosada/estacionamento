/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.model;

import java.io.Serializable;

/**
 *
 * @author Gabriel Bernardi
 */
public class VeiculoModel implements Serializable{
    private String placa;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa != null && !placa.trim().equals("")){
            this.placa = placa;
        } else {
            throw new IllegalArgumentException("Placa Inválida.");
        }
    }
}
