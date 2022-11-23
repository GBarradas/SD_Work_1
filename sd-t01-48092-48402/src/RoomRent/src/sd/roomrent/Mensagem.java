/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sd.roomrent;

import java.util.Date;

/**
 *
 * @author barradas e baião
 */
public class Mensagem implements java.io.Serializable
{
    private int aid;
    private String remetente;
    private String msg;
    private Date data;
    public Mensagem(int aid, String remetente, String msg,Date data){
        this.aid = aid;
        this.remetente = remetente;
        this.msg = msg;
        this.data = data;
    }
    public Mensagem(){
        this.aid = -1;
        this.remetente = null;
        this.msg = null;
        this.data = null;
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
    public void setDate(Date d){
        this.data = d;
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

    @Override
    public String toString(){
        return "-------------------------------------------------------------------------------\n     "
                +remetente+"("+data+"): " +msg+";";
    }
}
