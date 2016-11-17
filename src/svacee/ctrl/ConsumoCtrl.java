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


    public ConsumoCtrl() {
    }

    public List<Consumo> obterDadoCSV(String caminho) throws FileNotFoundException, IOException {

        String[] colunas;
    
        BufferedReader br = null;
        //FileReader fileReader = new FileReader(caminho);

        br = new BufferedReader(new FileReader(caminho));

        String linha = "";
        
        getListaDados().clear();

        while ((linha = br.readLine()) != null) {
                Consumo consumo = new Consumo();

                colunas = linha.split(",");

                consumo.setDataHora(java.sql.Timestamp.valueOf(colunas[0]));
                consumo.setIdColeta(colunas[1]);
                consumo.setValor(Double.parseDouble(colunas[2]));

                getListaDados().add(consumo);
          
        }
        return getListaDados();
    }

    
    
    
    public List<Consumo> getListaDados() {
        return listaDados;
    }

    public void setListaDados(List<Consumo> listaDados) {
        this.listaDados = listaDados;
    }

   

}
