/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.factory;

import br.furb.controller.Controller;
import br.furb.model.Model;
import br.furb.view.View;

/**
 *
 * @author flavioomar
 */
public abstract class ParkFactory {
    
    public static ParkFactory getFactory(String type) {
        if ("Pessoa".equals(type)) {
            return new PessoaParkFactory();
        } else if ("Veiculo".equals(type)) {
            return new VeiculoParkFactory();
        } else if ("Estadia".equals(type)) {
            return new EstadiaParkFactory();
        } else {
            return null;
        }
    }
    
    public abstract Model createModel();
    public abstract View createView(Object form);
    public abstract Controller createController();
    
}
