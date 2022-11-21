/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;

/**
 *
 * @author barradas & baião
 */
public class Servidor {
    
    public static void main(String[] args){
        int port = 1099;

        if (args.length !=1) { // obrigar à presenca de um argumento
            System.out.println("Usage: java sd.rmi.PalavrasServer registryPort");
            System.exit(1);
        }

        try{
            port = Integer.parseInt(args[0]);

            GestorAnuncios ges = new GestorAnunciosImpl();


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
