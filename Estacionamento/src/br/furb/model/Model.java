/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.model;

import java.util.List;

/**
 *
 * @author flavioomar
 */
public interface Model {
    public abstract void salvar(Object info) throws Exception;
    
    public abstract Object recuperar(String chave) throws Exception;
    
    public abstract List recuperar() throws Exception;
    
    public abstract void criarDiretorio() throws Exception;
}
