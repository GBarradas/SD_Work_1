/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sd.roomrent;

import java.util.List;

/**
 *
 * @author barradas e baião
 */
public interface GestorAnuncios extends  java.rmi.Remote{
    public int registarAnuncio(Anuncio a) throws java.rmi.RemoteException ;

    public List<Anuncio> listaAnunciosEstado(String estado)  throws java.rmi.RemoteException ;

    public Anuncio getAnuncio(int aid) throws java.rmi.RemoteException;

    public void alterarEstado(int aid, String estado) throws java.rmi.RemoteException;

    public void enviarMensagem(int aid, String remetente, String msg) throws java.rmi.RemoteException;

    public List<Anuncio> Filtrar(String filtros) throws java.rmi.RemoteException;

    public List<Mensagem> getMensagens(int aid) throws java.rmi.RemoteException;

    public List<Anuncio> anunciosUser(String userName) throws java.rmi.RemoteException;
}
