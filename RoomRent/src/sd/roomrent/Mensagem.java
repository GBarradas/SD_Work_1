/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;

/**
 *
 * @author barradas e baião
 */
public class Mensagem {
    private int aid;
    private String remetente;
    private String msg;
    public Mensagem(int aid, String remetente, String msg){
        this.aid = aid;
        this.remetente = remetente;
        this.msg = msg;
    }
    public void setAid (int aid ){
        this.aid = aid;
    }
    public void setRemetente (String remetente){
        this.remetente = remetente;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public int getAid (){
        return this.aid;
    }
    public String getRemetente(){
        return this.remetente;
    }
    public String getMsg (){
        return this.msg;
    }
}
