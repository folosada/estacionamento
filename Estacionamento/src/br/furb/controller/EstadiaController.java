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
public class EstadiaController implements Controller {

    @Override
    public void salvar(Object info) throws Exception {
        Model estadiaModel = ParkFactory.getFactory("Estadia").createModel();
        estadiaModel.salvar(info);
    }

    @Override
    public void excluir(String chave) throws Exception {
        Model estadiaModel = ParkFactory.getFactory("Estadia").createModel();
        estadiaModel.excluir(chave);
    }
    
    @Override
    public Object recuperar(String chave) throws Exception {
        Model estadiaModel = ParkFactory.getFactory("Estadia").createModel();
        return estadiaModel.recuperar(chave);
    }

    @Override
    public List recuperar() throws Exception {
        Model estadiaModel = ParkFactory.getFactory("Estadia").createModel();
        return estadiaModel.recuperar();
    }
    
}
