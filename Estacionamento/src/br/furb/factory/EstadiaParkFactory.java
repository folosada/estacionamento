/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.factory;

import br.furb.controller.EstadiaController;
import br.furb.model.EstadiaModel;
import br.furb.view.EstadiaView;

/**
 *
 * @author flavioomar
 */
public class EstadiaParkFactory extends ParkFactory {

    @Override
    public EstadiaModel createModel() {
        return new EstadiaModel();
    }

    @Override
    public EstadiaView createView(Object form) {
        return new EstadiaView(form);
    }

    @Override
    public EstadiaController createController() {
        return new EstadiaController();
    }
    
}
