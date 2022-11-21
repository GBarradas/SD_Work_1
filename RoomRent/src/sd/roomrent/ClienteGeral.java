/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author barradas
 */
public class ClienteGeral {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        Anuncio a = new Anuncio();
        String host = "localhost";
        String port = "9000";  // porto do binder

        if (args.length !=2) { // requer 3 argumentos
            System.out.println
                    ("Usage: java sd.rmi.ClientGeral registryHost registryPort DataBase");
            System.exit(1);
        }
        host = args[0];
        port = args[1];

        try{
            System.out.println("Qual o seu nome?\n");
            String nomeUser = br.readLine();
            if(nomeUser.length()==0){
                System.out.println("Por favor coloque o seu nome!");
            } else{
                System.out.println("Bem vindo " + nomeUser);
            }

            System.out.println("Escolha a funcionalidade:\n 1=Registar Anuncio || 2=Listar Anuncios || 3=Obter Anuncio || 4=Enviar Mensagem || 5=Consultar Mensagens || 6=Sair");
            int func = Integer.parseInt(br.readLine());
            while(func!=6) {
                if (func == 1) {

                    System.out.println("Insira as seguintes informações:\n" +
                            "Zona:");
                    String aux = br.readLine();
                    while(aux!=null) {
                        if (aux.length() <= 2) {
                            System.out.println("Zona inválida!");
                        } else {
                            a.setZona(aux);
                            break;
                        }
                    }
                    System.out.println("Preço:");
                    double p = -1;
                    while(p<0){
                        p = Double.parseDouble(br.readLine());
                        if(p<=0){
                            System.out.println("Preço inválido!\n");
                        } else {
                            a.setPreco(p);
                            break;
                        }
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Erro ao conectar!");
        }
    }
}
