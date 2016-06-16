/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.arquivo;

import br.furb.model.EstadiaModel;
import br.furb.model.PessoaModel;
import br.furb.model.VeiculoModel;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
    private static final Path caminhoEstadia = Paths.get("C:", separador, "Estacionameto", separador, "Estadia");
    private static Path caminhoDadosArquivos = Paths.get("C:", separador, "Estacionameto");

    public static Arquivo getInstance() throws IOException{
        Arquivo.criarDiretorio();
        Arquivo.criarArquivoPrincipal();
        return Arquivo.ARQUIVO;
    }
    
    private static void criarDiretorio() throws IOException{
        if (!Files.exists(caminhoPessoa)){
            Files.createDirectories(caminhoPessoa);
        }
        
        if (!Files.exists(caminhoVeiculo)){
            Files.createDirectories(caminhoVeiculo);
        }
        
        if (!Files.exists(caminhoEstadia)){
            Files.createDirectories(caminhoEstadia);
        }
    }
    
    private static void criarArquivoPrincipal() throws IOException{
        Path arquivo = Paths.get(caminhoDadosArquivos.toString() + separador + "Dados.txt");
        if (!Files.deleteIfExists(arquivo)){
            Files.createFile(arquivo);
        }
        caminhoDadosArquivos = arquivo;
    }
    
    public <T> void salvar(T info) throws IOException{
        ObjectOutputStream oos;
        Path arquivo = null;
        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDadosArquivos.toString(), true));
        
        if (info instanceof PessoaModel){
            PessoaModel pessoa = (PessoaModel) info;
            arquivo = Paths.get(caminhoPessoa + separador + pessoa.getCpf());
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(pessoa);
            oos.close();
        } else if(info instanceof VeiculoModel){
            VeiculoModel veiculo = (VeiculoModel) info;
            arquivo = Paths.get(caminhoVeiculo + separador + veiculo.getPlaca());
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(veiculo);
            oos.close();
        } else if(info instanceof EstadiaModel){
            EstadiaModel e = (EstadiaModel) info;
            arquivo = Paths.get(caminhoEstadia + separador 
                                + e.getPessoa().getCpf()
                                + e.getVeiculo().getPlaca());
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(e);
            oos.close();
        }
        
        
        bw.write(arquivo.toString() + ";" + info);
        bw.newLine();
        bw.close();
    }
    
    public <T> T recuperar(T info, String caminho) throws IOException, ClassNotFoundException{
        ObjectInputStream ois;
        Path arquivo = Paths.get(caminho);
        if (info instanceof PessoaModel){
            ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
            T pessoa = (T) ois.readObject();
            ois.close();
            return pessoa;
        } else if(info instanceof VeiculoModel){
            ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
            T veiculo = (T) ois.readObject();
            ois.close();
            return veiculo;
        } else if(info instanceof EstadiaModel){
            ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
            T estadia = (T) ois.readObject();
            ois.close();
            return estadia;
        }
        
        return null;
    }
    
    public <T> List<T> recuperar(){
        return null;
    }
}
