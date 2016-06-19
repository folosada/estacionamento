/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.factory;

import br.furb.controller.Controller;
import br.furb.controller.PessoaController;
import br.furb.model.Model;
import br.furb.model.PessoaModel;
import br.furb.view.PessoaView;
import br.furb.view.View;

/**
 *
 * @author flavioomar
 */
public class PessoaParkFactory extends ParkFactory {

    @Override
    public Model createModel() {
        return new PessoaModel();
    }

    @Override
    public View createView(Object form) {
        return new PessoaView(form);
    }

    @Override
    public Controller createController() {
        return new PessoaController();
    }

    
}
