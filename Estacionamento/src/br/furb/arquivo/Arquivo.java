/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Gabriel Bernardi
 */
public class Arquivo<T> {
    private static final Arquivo ARQUIVO = new Arquivo();
    private static FileSystem system = FileSystems.getDefault();
    private static final String separador = system.getSeparator() + system.getSeparator();
    private static final Path caminhoEstadia = Paths.get("C:", separador, "Estacionameto", separador, "Estadia");

    public static Arquivo getInstance() {
        return Arquivo.ARQUIVO;
    }
    
    public void salvar(T info, String chave) throws IOException{
        ObjectOutputStream oos = null;
        if(!existeArquivo(info)){
            Path arquivo = Paths.get(caminhoEstadia.toString() + separador + chave);
            oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
            oos.writeObject(info);
            oos.close();
        }
    }
    
    //Feito só para demonstração
    private boolean existeArquivo(T info){
        File file = new File(caminhoEstadia.toString());
	File afile[] = file.listFiles();
	int i = 0;
	for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            if (info.equals(arquivos.getName())){
                return true;
            }
	}
        return false;
    }
    
    public T recuperar(String chave, String tipoDado) throws IOException, ClassNotFoundException{
        ObjectInputStream ois;
        String caminho = "";
        if ("Pessoa".equalsIgnoreCase(tipoDado)) {
            caminho = caminhoEstadia + separador + chave;
        } else if ("Veiculo".equalsIgnoreCase(tipoDado)) {
            caminho = caminhoEstadia + separador + chave;
        } else if ("Estadia".equalsIgnoreCase(tipoDado)) {
            caminho = caminhoEstadia + separador + chave;
        }
        Path arquivo = Paths.get(caminho);        
        ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
        T entidade = (T) ois.readObject();
        ois.close();
        return entidade;                
    }
    
    public List<T> recuperar(){
        return null;
    }
}
