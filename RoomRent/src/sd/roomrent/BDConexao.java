/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author barradas
 */
public class BDConexao {
    private String dbUrl;
    private String dbName;
    private String dbUser;
    private String dbPass;
    Connection con = null;
    Statement stmt = null;
    public BDConexao() throws IOException
    {
        Properties p = new Properties();
        InputStream fr = new FileInputStream("bd.properties");
        p.load(fr);
        dbUrl = p.getProperty("bd.url");
        dbName = p.getProperty("bd.name","");
        dbUser = p.getProperty("bd.user","");
        dbPass = p.getProperty("bd.pass","");
        try {
            Class.forName("org.postgresql.Driver");
            // url = "jdbc:postgresql://host:port/database",
            con = DriverManager.getConnection("jdbc:postgresql://" + dbUrl + ":5432/" + dbName,
                    dbUser,
                    dbPass);

            stmt = con.createStatement();
            System.out.println("Conexão bem Sucecedida!!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems setting the connection");
        }
    }

    public void disconnect() {    // importante: fechar a ligacao 'a BD
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int registarAnuncio(Anuncio a){      //registar anuncio na bd
        try{
            int aid = stmt.executeUpdate("insert into anuncios(tipo, estado, anunciante, preco, genero, zona, data, tipologia) values("+
                    a.getTipo()+", "+
                    "inativo, "+
                    a.getAnunciante()+", "+
                    a.getPreco()+", "+
                    a.getGenero()+", "+
                    a.getZona()+", "+
                    new Date() +", "+
                    a.getTipologia()+") returning aid");
            return aid;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public List<Anuncio> Filtrar (String filtros){
        List<Anuncio> resultado = new ArrayList<Anuncio>();
        filtros = filtros.replace("&", " and ");
        try{
            ResultSet rs = stmt.executeQuery("select * from anuncio where estado = ativo and"+filtros);
            while (rs.next()){
                Anuncio a = new Anuncio();
                a.setAid(rs.getInt("aid"));
                a.setZona(rs.getString("zona"));
                a.setPreco(rs.getInt("preco"));
                a.setGenero(rs.getString("genero"));
                a.setData(rs.getDate("data"));
                a.setAnunciante(rs.getString("anunciante"));
                a.setTipologia(rs.getString("tipologia"));
                a.setTipo(rs.getString("tipo"));
                a.setEstado(rs.getString("estado"));
                resultado.add(a);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    public List<Anuncio> AnunciosUser(String Anunciante){
        List<Anuncio> resultado = new ArrayList<Anuncio>();
       String  filtros = "anunciante = "+Anunciante;
        try{
            ResultSet rs = stmt.executeQuery("select * from anuncio where "+filtros);
            while (rs.next()){
                Anuncio a = new Anuncio();
                a.setAid(rs.getInt("aid"));
                a.setZona(rs.getString("zona"));
                a.setPreco(rs.getInt("preco"));
                a.setGenero(rs.getString("genero"));
                a.setData(rs.getDate("data"));
                a.setAnunciante(rs.getString("anunciante"));
                a.setTipologia(rs.getString("tipologia"));
                a.setTipo(rs.getString("tipo"));
                a.setEstado(rs.getString("estado"));
                resultado.add(a);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    public Anuncio getAnuncio(int aid){
        Anuncio resultado = new Anuncio();
        String filtros = "aid = "+aid;
        try{
            ResultSet rs = stmt.executeQuery("select * from anuncio where "+filtros);
            if(rs.next()){
                Anuncio a = new Anuncio();
                a.setAid(rs.getInt("aid"));
                a.setZona(rs.getString("zona"));
                a.setPreco(rs.getInt("preco"));
                a.setGenero(rs.getString("genero"));
                a.setData(rs.getDate("data"));
                a.setAnunciante(rs.getString("anunciante"));
                a.setTipologia(rs.getString("tipologia"));
                a.setTipo(rs.getString("tipo"));
                a.setEstado(rs.getString("estado"));

                return a;
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    public void enviarMensagem(int aid, String remetente, String msg){
        try{
            stmt.executeUpdate("insert into mensagens values("+msg+","+remetente+","+aid+")");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
