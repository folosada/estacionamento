/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.model;

import br.furb.Estadia;
import br.furb.arquivo.Arquivo;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author flavioomar
 */
public class EstadiaModel implements Model {
    
    private static final String caminhoEstadia = Paths.get("Estadia").toAbsolutePath().toString();

    @Override
    public void salvar(Object info) throws Exception {
         Arquivo.getInstance().salvar(info, ((Estadia) info).getChave(), caminhoEstadia);
    }

    @Override
    public Object recuperar(String chave) throws Exception {
        return Arquivo.getInstance().recuperar(chave, caminhoEstadia);
    }

    @Override
    public List recuperar() throws Exception {
        return Arquivo.getInstance().recuperar(caminhoEstadia);
    }
    
}
