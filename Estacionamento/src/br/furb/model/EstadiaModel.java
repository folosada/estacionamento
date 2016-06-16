/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.model;

import br.furb.Estadia;
import br.furb.arquivo.Arquivo;

/**
 *
 * @author Flávio e Carol
 */
public class EstadiaModel implements Model {
    
    private final Arquivo arquivo = Arquivo.getInstance();

    @Override
    public void salvar(Object info) throws Exception {
         arquivo.salvar(info, ((Estadia) info).getChave());
    }

    @Override
    public Object recuperar(String chave) throws Exception {
        return arquivo.recuperar(chave, new Estadia().getClass().getName());
    }
    
}
