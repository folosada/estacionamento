/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb;

import br.furb.controller.Arquivo;
import br.furb.model.Pessoa;
import java.io.IOException;

/**
 *
 * @author Gabriel Bernardi
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("123");
        Arquivo arquivo = Arquivo.getInstance();
        arquivo.salvar(pessoa);
        
        Pessoa p = arquivo.recuperar(pessoa, "C:\\Estacionameto\\Pessoa\\123");
        System.out.println(p.getCpf());
    }
}
