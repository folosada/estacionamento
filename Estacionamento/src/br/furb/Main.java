/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import br.furb.arquivo.Arquivo;
import br.furb.model.EstadiaModel;
import br.furb.model.Model;
import br.furb.model.PessoaModel;
import br.furb.model.VeiculoModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabriel Bernardi
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception{
        //Pessoas
//        Model pessoaModel = new PessoaModel();
//        
//        Pessoa pessoa = new Pessoa();
//    	pessoa.setCpf("123");
//    	pessoaModel.salvar(pessoa);
//    	
//        Pessoa pessoa1 = new Pessoa();
//    	pessoa1.setCpf("456");
//    	pessoaModel.salvar(pessoa1);
//        
//        Pessoa pessoa2 = new Pessoa();
//    	pessoa2.setCpf("789");
//    	pessoaModel.salvar(pessoa2);
        
        //Veiculos
//        VeiculoModel veiculoModel = new VeiculoModel();
//        
//    	Veiculo veiculo = new Veiculo();
//    	veiculo.setPlaca("pla123");
//    	veiculoModel.salvar(veiculo);
//    	
//    	Veiculo veiculo1 = new Veiculo();
//    	veiculo1.setPlaca("pla456");
//    	veiculoModel.salvar(veiculo1);
//        
//    	Veiculo veiculo2 = new Veiculo();
//    	veiculo2.setPlaca("pla789");
//    	veiculoModel.salvar(veiculo2);
    	
        //Estadias
        Arquivo a = Arquivo.getInstance();
        
//    	Model estadiaModel = new EstadiaModel();
//    	
//    	Estadia estadia = new Estadia();
//    	estadia.setPessoa(pessoa);
//    	estadia.setVeiculo(veiculo);
//    	estadia.setDataEntrada(new Date());
//    	estadia.setDataSaida(new Date());
//    	estadiaModel.salvar(estadia);
//        
//    	Estadia estadia1 = new Estadia();
//    	estadia1.setPessoa(pessoa1);
//    	estadia1.setVeiculo(veiculo1);
//    	estadia1.setDataEntrada(new Date());
//    	estadia1.setDataSaida(new Date());
//    	estadiaModel.salvar(estadia1);
//        
//    	Estadia estadia2 = new Estadia();
//    	estadia2.setPessoa(pessoa2);
//    	estadia2.setVeiculo(veiculo2);
//    	estadia2.setDataEntrada(new Date());
//    	estadia2.setDataSaida(new Date());
//    	estadiaModel.salvar(estadia2);
        
        List<Estadia> l = a.recuperarEstadias();
    	
        System.out.println("Estadias");
        int i = 0;
        for (Estadia e : l) {
            System.out.println("Estadia: " + i);
            System.out.println("CPF: " + e.getPessoa().getCpf()
                              + "\nPlaca: " + e.getVeiculo().getPlaca()
                              + "\nID Estadia: " + e.getChave()
                              + "\nData Entrada: " + e.getDataEntrada()
                              + "\nData Saida: " + e.getDataSaida());
            System.out.println("\n");
            i++;
        }
        
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
