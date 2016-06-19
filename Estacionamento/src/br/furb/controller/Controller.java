/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.controller;

import java.util.List;

/**
 *
 * @author flavioomar
 */
public interface Controller {
    
    public abstract void salvar(Object info) throws Exception;
    
    public abstract Object recuperar(String chave) throws Exception;
    
    public abstract List recuperar() throws Exception;        
    
}
