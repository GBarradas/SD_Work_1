/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;


import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author barradas e baião
 */
public class GestorAnunciosImpl extends UnicastRemoteObject implements GestorAnuncios, java.io.Serializable
{
    private BDConexao bdc;
    public GestorAnunciosImpl() throws java.rmi.RemoteException{
        super();
        try {
            bdc = new BDConexao();
        } catch (Exception e){
            System.out.println("ERRO NA CONEXÃO COM A BD");
        }
    }
    // chama a função para registar o anuncio
    public int registarAnuncio(Anuncio a) throws java.rmi.RemoteException
    {
        return bdc.registarAnuncio(a);
    }
    // chama a função para listar anuncios e devolve a lista de anuncios
    public List<Anuncio> listaAnunciosEstado(String estado) throws java.rmi.RemoteException
    {
        return bdc.listaAnunciosEstado(estado);
    }
    //chama a função para obter as informações sobre o anuncio e devolve-o
    public Anuncio getAnuncio(int aid) throws java.rmi.RemoteException
    {
        return bdc.getAnuncio(aid);
    }
    // chama a função e altera o estado do anuncio
    public void alterarEstado(int aid, String estado) throws java.rmi.RemoteException
    {
        bdc.alterarEstado(aid,estado);
    }
    // chama a função para enviar uma menssagem
    public void enviarMensagem(int aid, String remetente, String msg) throws java.rmi.RemoteException
    {
        bdc.enviarMensagem(aid, remetente, msg);
    }
    // chama a função para filtar os anuncios e devolve a lista de anuncios
    public List<Anuncio> Filtrar(String filtros) throws java.rmi.RemoteException
    {
        return bdc.Filtrar(filtros);
    }
    // chama a função para obter as mensagens de um anuncio e devolve-as
    public List<Mensagem> getMensagens(int aid) throws java.rmi.RemoteException
    {
        return bdc.getMensagem(aid);
    }
    // chama a função para listar os anuncios de um utilizador e devolve a lista de anuncios
    public List<Anuncio> anunciosUser(String userName) throws java.rmi.RemoteException
    {
        return bdc.AnunciosUser(userName);
    }
}
