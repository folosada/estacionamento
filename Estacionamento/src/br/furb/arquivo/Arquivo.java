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
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel Bernardi
 */
public class Arquivo<T> {
    private static final Arquivo ARQUIVO = new Arquivo();
    
    public static Arquivo getInstance() {
        return Arquivo.ARQUIVO;
    }
    
    public void salvar(T info, String chave, String diretorio) throws IOException{
        Path arquivo = Paths.get(diretorio + FileSystems.getDefault().getSeparator() + chave);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo.toString()));
        oos.writeObject(info);
        oos.close();
    }
    
    public void excluir(String chave, String diretorio) throws IOException{
        Path arquivo = Paths.get(diretorio + FileSystems.getDefault().getSeparator() + chave);
        Files.deleteIfExists(arquivo);
    }
    
    public T recuperar(String chave, String diretorio) throws IOException, ClassNotFoundException{
        ObjectInputStream ois;
        Path arquivo = Paths.get(diretorio + FileSystems.getDefault().getSeparator() + chave);        
        ois = new ObjectInputStream(new FileInputStream(arquivo.toString()));
        T entidade = (T) ois.readObject();
        ois.close();
        return entidade;                
    }
    
    public List<T> recuperar(String diretorio) throws IOException, ClassNotFoundException{
        List<T> lista = new LinkedList<>();
        Path arquivo = Paths.get(diretorio); 
        File file = new File(diretorio);
	File afile[] = file.listFiles();
        ObjectInputStream ois;
	int i = 0;
        
	for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            ois = new ObjectInputStream(new FileInputStream(arquivo.toString() + 
                    FileSystems.getDefault().getSeparator() + arquivos.getName()));
            T entidade = (T) ois.readObject();
            lista.add(entidade);
            ois.close();
	}
        
        return lista;
    }
    
    public static void criarDiretorio(String diretorio) throws Exception {
        diretorio += FileSystems.getDefault().getSeparator();
        if (!Files.exists(Paths.get(diretorio))) {
            Files.createDirectory(Paths.get(diretorio));
        }
    }
}
