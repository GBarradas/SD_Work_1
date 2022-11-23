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
            System.err.println("Argumentos Invalidos !");
            System.exit(1);
        }

        try{
            port = Integer.parseInt(args[0]);
            //inicializar o objecto remoto
            GestorAnuncios ges = new GestorAnunciosImpl();
            //inicialização do java rmi e bind do objecto
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(port);

            registry.rebind("RoomRent", ges);

            System.out.println("servidor pronto");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
