/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;


import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author barradas e baião
 */
public class GestorAnunciosImpl extends UnicastRemoteObject implements GestorAnuncios, java.io.Serializable
{
    private BDConexao bdc;
    public GestorAnunciosImpl() throws java.rmi.RemoteException{
        super();
        /*
        try {
            bdc = new BDConexao();
        } catch (Exception e){
            System.out.println("ERRO NA CONEXÃO COM A BD");
        }*/
    }

    public void registarAnuncio(Anuncio a){
        bdc.registarAnuncio(a);
    }
}
