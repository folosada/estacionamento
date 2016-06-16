/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import br.furb.arquivo.Arquivo;
import br.furb.model.EstadiaModel;
import br.furb.model.PessoaModel;
import br.furb.model.VeiculoModel;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Gabriel Bernardi
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Arquivo arquivo = Arquivo.getInstance();
        
        PessoaModel pessoa = new PessoaModel();
        pessoa.setCpf("123");
        arquivo.salvar(pessoa);
        
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setPlaca("placa123");
        arquivo.salvar(veiculo);
        
        EstadiaModel e = new EstadiaModel();
        e.setPessoa(pessoa);
        e.setVeiculo(veiculo);
        e.setDataEntrada(new Date("11/06/2016"));
        e.setDataSaida(new Date("14/06/2016"));
        arquivo.salvar(e);
    }
}
