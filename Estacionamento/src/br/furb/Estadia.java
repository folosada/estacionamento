/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gabriel Bernardi
 */
public class Estadia<T> implements Serializable, Comparable<T>{
    private String chave;
    private Pessoa pessoa;
    private Veiculo veiculo;
    private Date dataEntrada;
    private Date dataSaida;
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
        this.setChave();
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    public String getChave() {
        return this.chave;
    }

    private void setChave() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        this.chave = this.getPessoa().getCpf() + "_" + 
                     this.getVeiculo().getPlaca() + "_" + 
                     sdf.format(this.getDataEntrada());
    }
    
    public double calcular(){
        try {
            return 0;
        } catch (Exception e) {
            throw new IllegalArgumentException("A Data de Saída deve ser informada.");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.chave.equals((String) obj)
                && this.getDataSaida() == null;
    }

    @Override
    public int compareTo(T o) {
//        Estadia estadia = (Estadia) o;
//        if (this.dataEntrada.compareTo(estadia.getDataEntrada()) == 0){
//            if (this.pessoa.compareTo(estadia.getPessoa()) == 0){
//                
//            }
//        }
        
        return 0;
    }
}
