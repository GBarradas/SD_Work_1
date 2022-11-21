/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;

import java.util.Date;

/**
 *
 * @author barradas
 */
public class Anuncio {
    private String tipo;
    private String estado;
    private String genero;
    String zona;
    private String anunciante;
    private String tipologia;
    private int aid;
    Date data;
    Double preco;

    public Anuncio(String tipo, String estado, String anunciante, double preco, String genero, String zona, int aid, Date data, String tipologia){
        this.tipo = tipo;
        this.estado = estado;
        this.anunciante = anunciante;
        this.preco = preco;
        this.genero = genero;
        this.zona = zona;
        this.aid = aid;
        this.data = data;
        this.tipologia = tipologia;
    }
    public Anuncio(){
        this.tipo = null;
        this.estado = null;
        this.anunciante = null;
        this.preco = -1.0;
        this.genero = null;
        this.zona = null;
        this.aid = -1;
        this.data = null;
        this.tipologia = null;
    }
    public void setAid(int aid){
        this.aid = aid;
    }
    public void setTipo(String t){
        this.tipo = t;
    }
    public void setEstado(String e){
        this.estado = e;
    }
    public void setAnunciante(String n) {
        this.anunciante = n;
    }
    public void setPreco(double p) {
        this.preco = p;
    }
    public void setGenero(String g) {
        this.genero = g;
    }
    public void setZona(String z) {
        this.zona = z;
    }
    public void setData(Date d){
        this.data = d;
    }
    public void setTipologia(String s){
        this.tipologia = s;
    }

    public String getTipo() {
        return this.tipo;
    }
    public String getEstado() {
        return this.estado;
    }
    public String getAnunciante() {
        return this.anunciante;
    }
    public double getPreco() {
        return this.preco;
    }
    public String getGenero() {
        return this.genero;
    }
    public String getZona() {
        return this.zona;
    }
    public int getAid() {
        return this.aid;
    }
    public Date getData() {
        return this.data;
    }
    public String getTipologia(){
        return this.tipologia;
    }
}