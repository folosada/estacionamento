/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gabriel Bernardi
 */
public class Estadia implements Serializable, Comparable {
    private static final double PRECO = 3.5;
    private Pessoa pessoa;
    private Veiculo veiculo;
    private Date dataEntrada;
    private Date dataSaida;
    
    public Estadia(){}
    
    public Estadia(Pessoa pessoa, Veiculo veiculo, Date dataEntrada) {
        this.setPessoa(pessoa);
        this.setVeiculo(veiculo);
        this.setDataEntrada(dataEntrada);
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        if (pessoa != null){
            this.pessoa = pessoa;
        } else {
            throw new IllegalArgumentException("A pessoa deve ser informada.");
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        if (veiculo != null){
            this.veiculo = veiculo;
        } else {
            throw new IllegalArgumentException("O veículo deve ser informado.");
        }
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        if (dataEntrada != null){
            this.dataEntrada = dataEntrada;
        } else {
            throw new IllegalArgumentException("A Data de Entrada deve ser informada.");
        }
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        if (dataSaida.after(dataEntrada) && dataSaida != null){
            this.dataSaida = dataSaida;
        } else if(dataSaida == null){
            throw new IllegalArgumentException("A Data de Saída deve ser informada.");
        } else {
            throw new IllegalArgumentException("A Data de Saída deve ser maior que a Data de Entrada.");
        }
    }
    
    public String getChave() {
        if (this.getPessoa() != null && this.getVeiculo() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmm");
            return this.getPessoa().getCpf() + "_" + 
                   this.getVeiculo().getPlaca() + "_" + 
                   sdf.format(this.getDataEntrada());
        } else {
            return null;
        }
    }
    
    public Double calcularValor(){
        if (this.getDataSaida() != null) {
            Calendar dataInicial = Calendar.getInstance();
            dataInicial.setTime(dataEntrada);
            Calendar dataFinal = Calendar.getInstance();
            dataFinal.setTime(dataSaida);

            long diferenca = dataFinal.getTimeInMillis() - dataInicial.getTimeInMillis();

            long diferencaMin = diferenca / (60 * 1000);

            return (PRECO / 60) * diferencaMin;
        }
        return 0.0;
    }

    public static String formatarChave(String cpf, String placa, String dataEntrada) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmm");
        Date df = DateFormat.getInstance().parse(dataEntrada);
        return cpf + "_" + placa + "_" + sdf.format(df);
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getChave().equals((String) obj)
                && this.getDataSaida() != null;
    }

    @Override
    public int compareTo(Object o) {
        Estadia estadia = (Estadia) o;
        int compare = this.dataEntrada.compareTo(((Estadia) o).getDataEntrada());
        if (compare == 0) {
            compare = this.pessoa.compareTo(((Estadia) o).getPessoa());
            if (compare == 0){
                compare = this.veiculo.compareTo(((Estadia) o).getVeiculo());
            }
        }
        
        return compare;
    }

}
