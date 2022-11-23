/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author barradas e baião
 */
public class ClienteGestao {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static GestorAnuncios obj;
    public static void main(String[] Args) throws IOException
    {
        String host = "localhost";
        String port = "9000";
        if(Args.length != 2){
            System.out.println("ERRO ARGUMENTOS: <Host> <port>");
            System.exit(1);
        }
        host = Args[0];
        port = Args[1];
        try{
            obj = (GestorAnuncios) java.rmi.Naming.lookup("rmi://"
                     +host+":"+port+"/RoomRent");
            menu();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //menu que mostra todas as opções de  que o utilizador pode fazer
    public static void menu() throws IOException
    {
        try {
            System.out.print("""
                             ---------------------------------
                             Escolha a funcionalidade:
                             1 - Listar anuncios por estado
                             2 - Obter detalhes anuncio
                             3 - aprovar anuncio
                             4 - alterar estado de um anuncio
                             5 - Sair
                             
                             Opcção: """);
            int escolha = Integer.parseInt(br.readLine());
            switch (escolha){
                case 1:
                    listarAnuncios();
                    break;
                case 2:
                    verAnuncio();
                    break;
                case 3:
                    AprovarAnuncio();
                    break;
                case 4:
                    alterarEstadoAnuncio();
                    break;
                case 5:
                    System.out.println("ADEUS !!");
                    System.exit(1);
                    break;
                default:
                    System.err.println("OPÇÃO INVALIDA");
                    menu();
                    break;
            }
        }
        catch(Exception e){
            System.err.println("OPÇÃO INVALIDA");
            menu();
        }
    }
    // lista os anuncios pelo estado desejado
    public static void listarAnuncios() throws IOException {
        while (true) {
            System.out.print("Escolha um estado (inativo ou ativo):");
            String estado = br.readLine();
            List<Anuncio> resultado;
            if (estado.toLowerCase().equals("inativo")) {
                resultado = obj.listaAnunciosEstado("inativo");
                for(Anuncio a : resultado){
                    System.out.println(a);
                }
                System.out.println(resultado.size() +" ANUNCIOS LISTADOS");
                break;
            } else if (estado.toLowerCase().equals("ativo")) {
                resultado = obj.listaAnunciosEstado("ativo");
                for(Anuncio a : resultado){
                    System.out.println(a);
                }
                System.out.println(resultado.size() +" ANUNCIOS LISTADOS");
                break;
            } else {
                System.err.println("INPUT INVALIDO");
            }
        }
        menu();
    }
    // obter um anuncio pelo aid
    public static void verAnuncio() throws IOException
    {
        int aid;
        while(true){
            try{
                System.out.print("Indique o ID do Anuncio: ");
                aid = Integer.parseInt(br.readLine());
                break;
            }
            catch (Exception e){
                System.err.println("INPUT INVALIDO!");
            }
        }
        Anuncio a = obj.getAnuncio(aid);
        if(a == null){
            System.err.println("ANUNCIO NÂO ENCONTRADO!");
            menu();
        }
        System.out.println(a);
        menu();
    }
    //Altera o estado de um anuncio para ativo
    public static void AprovarAnuncio() throws IOException
    {
        int aid;
        while(true){
            try{
                System.out.print("Indique o ID do Anuncio: ");
                aid = Integer.parseInt(br.readLine());
                break;
            }
            catch (Exception e){
                System.err.println("INPUT INVALIDO!");
            }
        }
        obj.alterarEstado(aid, "ativo");
        menu();
    }
    // altera o estado de um anuncio de ativo para inativo ou vs versa
    public static void alterarEstadoAnuncio() throws IOException
    {
        int aid;
        while(true){
            try{
                System.out.print("Indique o ID do Anuncio: ");
                aid = Integer.parseInt(br.readLine());
                break;
            }
            catch (Exception e){
                System.err.println("INPUT INVALIDO!");
            }
        }
        String estado = obj.getAnuncio(aid).getEstado().toLowerCase();
        if(estado.equals("ativo")){
            obj.alterarEstado(aid, "inativo");
        }
        else if(estado.equals("inativo")){
            obj.alterarEstado(aid, "ativo");
        }
        else{
            System.err.println("ANUNCIO NÃO ENCONTRADO");
            menu();
        }
        menu();
    }
}
