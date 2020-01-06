/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;

/**
 *
 * @author Flavien
 */
public class AC extends Observable{

    public float temperatureExt, tempSortie, humiExt, humiSortie;

    public float getTemperatureExt() {
        return temperatureExt;
    }

    public void setTemperatureExt(float temperatureExt) {
        this.temperatureExt = temperatureExt;
        setChanged();
        notifyObservers();
    }

    public float getHumiExt() {
        return humiExt;
    }

    public void setHumiExt(float humiExt) {
        setChanged();
        notifyObservers();
        this.humiExt = humiExt;
    }
    
    public AC() {
        temperatureExt = 0;
        tempSortie = 15;
        humiExt = 50;
        humiSortie = 15;
    }
}
