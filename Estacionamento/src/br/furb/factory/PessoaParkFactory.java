/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.factory;

import br.furb.controller.PessoaController;
import br.furb.model.PessoaModel;
import br.furb.view.PessoaView;

/**
 *
 * @author flavioomar
 */
public class PessoaParkFactory extends ParkFactory {

    @Override
    public PessoaModel createModel() {
        return new PessoaModel();
    }

    @Override
    public PessoaView createView(Object form) {
        return new PessoaView(form);
    }

    @Override
    public PessoaController createController() {
        return new PessoaController();
    }

    
}
