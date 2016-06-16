/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gabriel Bernardi
 */
public class Estadia implements Serializable{
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
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    public String getChave() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        return this.getPessoa().getCpf() + "_" + 
                this.getVeiculo().getPlaca() + "_" + 
                sdf.format(this.getDataEntrada());
    }            
}
