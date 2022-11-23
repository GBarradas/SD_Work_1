
package sd.roomrent;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author barradas
 */

/*
* class que respresenta um anuncio
*/
public class Anuncio implements java.io.Serializable
{
    private String tipo;
    private String estado;
    private String genero;
    private String zona;
    private String anunciante;
    private String tipologia;
    private int aid;
    private Date data;
    private Double preco;

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

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#,##0.00€");

        String p = "-------------------------------------------------------\n" +
                "\t Aid: "+ aid + "\n"+
                "\t Tipo: " + tipo + "\n"+
                "\t Estado: "+ estado + "\n"+
                "\t Genero: " + genero+   "\n"+
                "\t Zona: " + zona + "\n"+
                "\t Anunciante:  "+ anunciante + "\n"+
                "\t Tipologia: "+ tipologia + "\n"+
                "\t Data: " + data + "\n"+
                "\t Preço: "+ df.format(preco) + "\n";

        return p;
    }
}