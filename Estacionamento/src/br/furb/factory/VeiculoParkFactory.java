/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.factory;

import br.furb.controller.VeiculoController;
import br.furb.model.VeiculoModel;
import br.furb.view.VeiculoView;

/**
 *
 * @author flavioomar
 */
public class VeiculoParkFactory extends ParkFactory {

    @Override
    public VeiculoModel createModel() {
        return new VeiculoModel();
    }

    @Override
    public VeiculoView createView(Object form) {
        return new VeiculoView(form);
    }

    @Override
    public VeiculoController createController() {
        return new VeiculoController();
    }
    
}
