/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.arquivo;

import br.furb.Estadia;
import br.furb.Pessoa;
import br.furb.Veiculo;
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
    // Estes caminhos devem ficar na classe Model e não  aqui, cada classe Model vai ter que ter o seu caminho padrão
    private static final Path caminhoPessoa = Paths.get("C:", separador, "Estacionameto", separador, "Pessoa");
    private static final Path caminhoVeiculo = Paths.get("C:", separador, "Estacionameto", separador, "Veiculo");
    private static final Path caminhoEstadia = Paths.get("C:", separador, "Estacionameto", separador, "Estadia");
    private static Path caminhoDadosArquivos = Paths.get("C:", separador, "Estacionameto");

    public static Arquivo getInstance() {
        //Não pode criar o diretório toda vez que chamar o getInstance, isto deve ficar em outro lugar
        //Arquivo.criarDiretorio();
        //Arquivo.criarArquivoPrincipal();
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
    
    public <T> void salvar(T info, String tipoDado) throws IOException{
        ObjectOutputStream oos;
        Path arquivo = null;
        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDadosArquivos.toString(), true));
        // remover estas dependencias de classes, aqui deve apenas receber o objeto e gravar no arquivo
        if (info instanceof Pessoa){
            Pessoa pessoa = (Pessoa) info;
            arquivo = Paths.get(caminhoPessoa + separador + pessoa.getCpf());
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(pessoa);
            oos.close();
        } else if(info instanceof Veiculo){
            Veiculo veiculo = (Veiculo) info;
            arquivo = Paths.get(caminhoVeiculo + separador + veiculo.getPlaca());
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(veiculo);
            oos.close();
        } else if(info instanceof Estadia){
            Estadia e = (Estadia) info;
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
    
    public <T> T recuperar(String chave, String tipoDado) throws IOException, ClassNotFoundException{
        ObjectInputStream ois;
        String caminho = "";
        if ("Pessoa".equalsIgnoreCase(tipoDado)) {
            caminho = caminhoPessoa + separador + chave + ".dat";
        } else if ("Veiculo".equalsIgnoreCase(tipoDado)) {
            caminho = caminhoVeiculo + separador + chave + ".dat";
        } else if ("Estadia".equalsIgnoreCase(tipoDado)) {
            caminho = caminhoEstadia + separador + chave + ".dat";
        }
        Path arquivo = Paths.get(caminho);        
        ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
        T entidade = (T) ois.readObject();
        ois.close();
        return entidade;                
    }
    
    public <T> List<T> recuperar(){
        return null;
    }
}
