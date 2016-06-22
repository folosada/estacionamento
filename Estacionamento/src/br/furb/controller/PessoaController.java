/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.controller;

import br.furb.factory.ParkFactory;
import br.furb.model.Model;
import java.util.List;

/**
 *
 * @author flavioomar
 */
public class PessoaController implements Controller {

    @Override
    public void salvar(Object info) throws Exception {
        Model pessoaModel = ParkFactory.getFactory("Pessoa").createModel();
        pessoaModel.salvar(info);
    }

    @Override
    public void excluir(String chave) throws Exception {
        Model pessoaModel = ParkFactory.getFactory("Pessoa").createModel();
        pessoaModel.excluir(chave);
    }
    
    @Override
    public Object recuperar(String chave) throws Exception {
        Model pessoaModel = ParkFactory.getFactory("Pessoa").createModel();
        return pessoaModel.recuperar(chave);
    }

    @Override
    public List recuperar() throws Exception {
        Model pessoaModel = ParkFactory.getFactory("Pessoa").createModel();
        return pessoaModel.recuperar();
    }
}
