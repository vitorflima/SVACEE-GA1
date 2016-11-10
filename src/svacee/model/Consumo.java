/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svacee.model;

import java.security.Timestamp;

/**
 *
 * @author Kátia
 */
public class Consumo {
    
    private Timestamp dataHora;
    private String idColeta;
    private double valor;

    public Consumo() {
    }

    public Consumo(Timestamp dataHora, String idColeta, double valor) {
        this.dataHora = dataHora;
        this.idColeta = idColeta;
        this.valor = valor;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public String getIdColeta() {
        return idColeta;
    }

    public void setIdColeta(String idColeta) {
        this.idColeta = idColeta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
