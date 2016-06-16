/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import br.furb.arquivo.Arquivo;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Gabriel Bernardi
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Arquivo arquivo = Arquivo.getInstance();
        /*
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("123");
        arquivo.salvar(pessoa);
        
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("placa123");
        arquivo.salvar(veiculo);
        
        Estadia e = new Estadia();
        e.setPessoa(pessoa);
        e.setVeiculo(veiculo);
        e.setDataEntrada(new Date("11/06/2016"));
        e.setDataSaida(new Date("14/06/2016"));
        arquivo.salvar(e);
        */
    }
}
