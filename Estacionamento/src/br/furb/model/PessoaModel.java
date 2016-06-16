/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.model;

import br.furb.Pessoa;
import br.furb.arquivo.Arquivo;
import java.io.IOException;

/**
 *
 * @author Flávio e Carol
 */
public class PessoaModel implements Model {
    
    private final Arquivo arquivo = Arquivo.getInstance();

    @Override
    public void salvar(Object info) throws Exception {
        arquivo.salvar(info, ((Pessoa) info).getCpf());
    }

    @Override
    public Object recuperar(String chave) throws Exception {
        return arquivo.recuperar(chave, new Pessoa().getClass().getName());
    }
    
}
