/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import java.io.Serializable;

/**
 *
 * @author flaviolosada
 */
public class Pessoa implements Serializable{
    private String cpf;

    public Pessoa() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.trim().equals("")){
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF Inválida.");
        }
    }
}
