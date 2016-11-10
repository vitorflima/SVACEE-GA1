/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svacee.ctrl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import svacee.model.Consumo;

/**
 *
 * @author vitor
 */
public class ConsumoCtrl {

    private List<Consumo> listaDados = new ArrayList<>();
    String[] linhas;
    String[] colunas;

    public ConsumoCtrl() {
    }

    public void obterDadoCSV(String caminho) throws FileNotFoundException, IOException {

        BufferedReader br = null;
        FileReader fileReader = new FileReader(caminho);

        br = new BufferedReader(fileReader);
        
        Consumo consumo = new Consumo();
        
        String linha = "";
        
        while((linha = br.readLine()) != null){
            
            linhas = linha.split(",");
            
            for(String v:linhas){
                
                colunas = v.split(";");
                
                consumo.setDataHora(java.sql.Timestamp.valueOf(colunas[0]));
                consumo.setIdColeta(colunas[1]);
                consumo.setValor(Double.parseDouble(colunas[2]));
                
                getListaDados().add(consumo);
            }
            
        }

    }

    public List<Consumo> getListaDados() {
        return listaDados;
    }

    public void setListaDados(List<Consumo> listaDados) {
        this.listaDados = listaDados;
    }

    public String[] getLinhas() {
        return linhas;
    }

    public void setLinhas(String[] linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
}
