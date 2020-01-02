/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Leaa
 */
public class Alarme {
    
    private int id;
    private Date date;
    private String TypeAlarme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeAlarme() {
        return TypeAlarme;
    }

    public void setTypeAlarme(String TypeAlarme) {
        this.TypeAlarme = TypeAlarme;
    }

    public Alarme(int id, Date date, String TypeAlarme) {
        this.id = id;
        this.date = date;
        this.TypeAlarme = TypeAlarme;
    }
    
    @Override
    public String toString() {
        return " ID : " +this.id + "\n DATE: " + this.date + "\n TYPE: " + this.TypeAlarme; 
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == Alarme.class){
            Alarme test = (Alarme)(o);
            
            return test.getId()==this.id;
        }else{
            return false;
        }
    }
    
    
    
}
