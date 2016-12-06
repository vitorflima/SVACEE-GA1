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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import svacee.form.DadosCSV;
import svacee.model.Consumo;

/**
 *
 * @author vitor
 */
public class ConsumoCtrl {

    private List<Consumo> listaDados;


    public ConsumoCtrl() {
        listaDados = new ArrayList();
    }
    
    public List<Consumo> obterDadoCSV(String caminho) throws FileNotFoundException, IOException, ParseException {

        String[] colunas;
    
        BufferedReader br = null;
        //FileReader fileReader = new FileReader(caminho);

        br = new BufferedReader(new FileReader(caminho));

        String linha = "";
        
        listaDados.clear();

        while ((linha = br.readLine()) != null) {
                Consumo consumo = new Consumo();

                colunas = linha.split(",");

                SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                Date minhaData = df.parse(colunas[0]);
                java.sql.Timestamp timestamp = new java.sql.Timestamp(minhaData.getTime());
                
                
                consumo.setDataHora(java.sql.Timestamp.valueOf(colunas[0]));
                consumo.setIdColeta(colunas[1]);
                consumo.setValor(Double.parseDouble(colunas[2]));

                listaDados.add(consumo);
          
        }
        
        
        return listaDados;
        
    }

    
    
    
    public List<Consumo> getListaDados() {
        return listaDados;
    }

    public void setListaDados(List<Consumo> listaDados) {
        this.listaDados = listaDados;
    }

   

}
