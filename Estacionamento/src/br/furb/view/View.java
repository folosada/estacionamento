/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.view;

import java.util.List;

/**
 *
 * @author Flávio e Carol
 */
public interface View {
    
    public abstract void salvar(Object info);
    
    public abstract Object recuperar(String chave);
    
    public abstract List recuperar();
    
    public abstract void abreJanela();
    
}
