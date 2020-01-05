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
    private final int maxAlarme;
    private Poste poste;

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

    public int getMaxAlarme() {
        return maxAlarme;
    }
    
    public Capteur(int id, String TypeMesure, int max) {
        this.id = id;
        this.TypeMesure = TypeMesure;
        this.lstAlarme = new ArrayList<>();
        this.maxAlarme = max;
    }
    
    public Capteur(int id, String TypeMesure, float valeur, int max) {
        this.id = id;
        this.TypeMesure = TypeMesure;
        this.valeur = valeur;
        this.lstAlarme = new ArrayList<>();
        this.maxAlarme = max;
    }
    
        public Capteur(int id, String TypeMesure,Poste poste, float valeur, int max) {
        this.id = id;
        this.TypeMesure = TypeMesure;
        this.poste=poste;
        this.valeur = valeur;
        this.lstAlarme = new ArrayList<>();
        this.maxAlarme = max;
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
    
    public void declencherAlarme(Alarme a){
        if(poste.getClass()== Cellule.class){
            if((TypeMesure.equals("Temperature") && valeur > 15) || (TypeMesure.equals("Humidite") && valeur > 15)){
                poste.setPanne(true);
                a.setTypeAlarme(TypeMesure);
                ajouterAlarme(a);
            }
        } 
    }
    
    public void ajouterAlarme(Alarme a){
        if(lstAlarme.size()>=maxAlarme){
            this.lstAlarme.remove(0);
        }
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
    public void genererValeur(String type){
        switch(type){
        case"Temperature": valeur=(float)(Math.random()*7.0+10.0);
                          break;
                          
        case"Humidite": valeur=(float)(Math.random()*10.0+7.0);
                          break;
        }
    
    }
    
}
