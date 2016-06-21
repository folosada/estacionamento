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
public class Pessoa implements Serializable, Comparable {
    private String nome;
    private String cpf;

    public Pessoa() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().equals("")){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O Nome deve ser informado.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.trim().equals("")){
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("a CPF deve ser informada.");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getCpf().equals(((Pessoa) obj).getCpf());
    }

    @Override
    public int compareTo(Object o) {
        int compare = this.nome.compareTo(((Pessoa) o).getNome());
        if (compare == 0) {
            compare = this.cpf.compareTo(((Pessoa) o).getCpf());
        }
        return compare;
    }
    
}
