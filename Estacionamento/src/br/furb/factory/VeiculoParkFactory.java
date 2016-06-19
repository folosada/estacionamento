/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.factory;

import br.furb.controller.Controller;
import br.furb.controller.VeiculoController;
import br.furb.model.Model;
import br.furb.model.VeiculoModel;
import br.furb.view.VeiculoView;
import br.furb.view.View;

/**
 *
 * @author flavioomar
 */
public class VeiculoParkFactory extends ParkFactory {

    @Override
    public Model createModel() {
        return new VeiculoModel();
    }

    @Override
    public View createView(Object form) {
        return new VeiculoView(form);
    }

    @Override
    public Controller createController() {
        return new VeiculoController();
    }
    
}
