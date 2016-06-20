/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import java.io.Serializable;

/**
 *
 * @author Gabriel Bernardi
 */
public class Veiculo implements Serializable, Comparable {
    private String nome;
    private String placa;

    public String getPlaca() {
        return placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().equals("")){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome Inválido.");
        }
    }

    public void setPlaca(String placa) {
        if (placa != null && !placa.trim().equals("")){
            this.placa = placa;
        } else {
            throw new IllegalArgumentException("Placa Inválida.");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getPlaca().equals(((String) obj));
    }

    @Override
    public int compareTo(Object o) {
        return this.nome.compareTo(((Veiculo) o).getNome());
    }

}
