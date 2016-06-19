/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.model;

import br.furb.Pessoa;
import br.furb.arquivo.Arquivo;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author flavioomar  
 */
public class PessoaModel implements Model {
    
    private static final String CAMINHO_PESSOA = Paths.get("Pessoa").toAbsolutePath().toString();

    @Override
    public void salvar(Object info) throws Exception {
        Arquivo.getInstance().salvar(info, ((Pessoa) info).getCpf(), CAMINHO_PESSOA);
    }

    @Override
    public Object recuperar(String chave) throws Exception {
        return Arquivo.getInstance().recuperar(chave, CAMINHO_PESSOA);
    }

    @Override
    public List recuperar() throws Exception {
        return Arquivo.getInstance().recuperar(CAMINHO_PESSOA);
    }
    
}
