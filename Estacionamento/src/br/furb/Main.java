/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import br.furb.model.EstadiaModel;
import br.furb.model.Model;
import br.furb.model.PessoaModel;
import br.furb.model.VeiculoModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gabriel Bernardi
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception{
        Pessoa pessoa = new Pessoa();
    	Model pessoaModel = new PessoaModel();
    	pessoa.setCpf("123");
    	pessoaModel.salvar(pessoa);
    	
    	Veiculo veiculo = new Veiculo();
    	VeiculoModel veiculoModel = new VeiculoModel();
    	veiculo.setPlaca("pla123");
    	veiculoModel.salvar(veiculo);
    	
    	Model estadiaModel = new EstadiaModel();
    	
    	Estadia estadia = new Estadia();
    	estadia.setPessoa(pessoa);
    	estadia.setVeiculo(veiculo);
    	estadia.setDataEntrada(new Date());
//    	estadia.setDataSaida(new Date());
    	estadiaModel.salvar(estadia);
    	
        estadiaModel.salvar(estadia);
//    	Estadia e = (Estadia) estadiaModel.recuperar(estadia.getId());
//    	System.out.println("CPF: " + e.getPessoa().getCpf()
//    					  + "\nPlaca: " + e.getVeiculo().getPlaca()
//    					  + "\nID Estadia: " + e.getId()
//    					  + "\nData Entrada: " + e.getDataEntrada()
//    					  + "\nData Saida: " + e.getDataSaida());
    	
//    	Estadia estadia2 = new Estadia();
//    	estadiaModel.salvar(estadia2);
//    	
//    	Estadia estadia3= new Estadia();
//    	estadiaModel.salvar(estadia3);
    }
}
