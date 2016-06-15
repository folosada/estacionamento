/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.controller;

import br.furb.model.Pessoa;
import br.furb.model.Veiculo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Gabriel Bernardi
 */
public class Arquivo {
    //Está tudo static por causa do teste
    private static final Arquivo ARQUIVO = new Arquivo();
    private static FileSystem system = FileSystems.getDefault();
    private static final String separador = system.getSeparator() + system.getSeparator();
    private static final Path caminhoPessoa = Paths.get("C:", separador, "Estacionameto", separador, "Pessoa");
    private static final Path caminhoVeiculo = Paths.get("C:", separador, "Estacionameto", separador, "Veiculo");

    public static Arquivo getInstance() throws IOException{
        Arquivo.criarDiretorio();
        return Arquivo.ARQUIVO;
    }
    
    private static void criarDiretorio() throws IOException{
        if (!Files.exists(caminhoPessoa)){
            Files.createDirectories(caminhoPessoa);
        }
        
        if (!Files.exists(caminhoVeiculo)){
            Files.createDirectory(caminhoVeiculo);
        }
    }
    
    public <T> void salvar(T info) throws IOException{
        ObjectOutputStream oos;
        Path arquivo;
        
        if (info instanceof Pessoa){
            Pessoa pessoa = (Pessoa) info;
            arquivo = Paths.get(caminhoPessoa + separador + pessoa.getCpf());
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(pessoa);
            oos.close();
        } else if(info instanceof Veiculo){
            Veiculo veiculo = (Veiculo) info;
            arquivo = Paths.get(caminhoPessoa + separador + veiculo.getPlaca());
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(veiculo);
            oos.close();
        }
    }
    
    public <T> T recuperar(T info, String caminho) throws IOException, ClassNotFoundException{
        ObjectInputStream ois;
        Path arquivo = Paths.get(caminho);
        if (info instanceof Pessoa){
            ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
            Pessoa pessoa = (Pessoa) ois.readObject();
            ois.close();
            return (T) pessoa;
        } else if(info instanceof Veiculo){
            ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
            Veiculo veiculo = (Veiculo) ois.readObject();
            ois.close();
            return (T) veiculo;
        }
        
        return null;
    }
}
