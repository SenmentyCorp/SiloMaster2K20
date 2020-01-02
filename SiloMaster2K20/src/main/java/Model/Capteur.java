/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Lea
 */
public class Capteur {
    private int id;
    private String TypeMesure;
    private float valeur;
    private ArrayList<Alarme> lstAlarme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeMesure() {
        return TypeMesure;
    }

    public void setTypeMesure(String TypeMesure) {
        this.TypeMesure = TypeMesure;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public ArrayList<Alarme> getLstAlarme() {
        return lstAlarme;
    }

    public void setLstAlarme(ArrayList<Alarme> lstAlarme) {
        this.lstAlarme = lstAlarme;
    }

    public Capteur(int id, String TypeMesure, float valeur) {
        this.id = id;
        this.TypeMesure = TypeMesure;
        this.valeur = valeur;
        this.lstAlarme = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String s = " ID : " +this.id + "\n TYPE: " + this.TypeMesure + "\n VALEUR: " + this.valeur ; 
        if(!lstAlarme.isEmpty()){
            s += "\n ALARMES: ";
            for(Alarme a : this.lstAlarme){
                s += "\n\t- " + a.toString();
            }
        }
        return s;
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass() == Capteur.class){
            Capteur test = (Capteur)(o);
            
            return test.getId()==this.id;
        }else{
            return false;
        }
    }
    
    public void declencherAlarme(){
        System.out.println("Not implemented yet");
    }
    
    public void ajouterAlarme(Alarme a){
        this.lstAlarme.add(a);
    }
    
    public void retirerAlarme(int id){
        for(int i=0; i< lstAlarme.size();i++){
            if(this.lstAlarme.get(i).getId()==id){
                lstAlarme.remove(i);
            }
        }
    }
    
    public void retirerAlarme(Alarme a){
        if(lstAlarme.contains(a)){
            lstAlarme.remove(a);
        }    
    }
    
    public Alarme chercherAlarme(int id){
        for(int i=0; i< lstAlarme.size();i++){
            if(this.lstAlarme.get(i).getId()==id){
                return lstAlarme.get(i);
            }
        }
        return null;
    }
    
    
}
