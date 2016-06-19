/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.controller;

import br.furb.model.PessoaModel;
import java.util.List;

/**
 *
 * @author flavioomar
 */
public class PessoaController implements Controller {

    @Override
    public void salvar(Object info) throws Exception {
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.salvar(info);
    }

    @Override
    public Object recuperar(String chave) throws Exception {
        PessoaModel pessoaModel = new PessoaModel();
        return pessoaModel.recuperar(chave);
    }

    @Override
    public List recuperar() throws Exception {
        PessoaModel pessoaModel = new PessoaModel();
        return pessoaModel.recuperar();
    }
    
}
