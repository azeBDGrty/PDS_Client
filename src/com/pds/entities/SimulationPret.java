/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

import com.pds.enums.TypeEmprunt;
import com.pds.enums.TypePret;
import java.sql.Timestamp;

/**
 *
 * @author zouhairhajji
 */
public class SimulationPret {
    
    private int idSimPret;
    private Timestamp dateSimulation, dateContraction;
    private int dureePret;
    
    private double mtPret;
    private TypePret typePret;
    private boolean blocked;
    
    private CalculPret calcPret;
    private TypeEmprunt typeEmprunt;
    
    public SimulationPret() {
    }

    public SimulationPret(int idSimPret, Timestamp dateSimulation, Timestamp dateContraction, int dureePret, double mtPret, TypePret typePret, boolean blocked, CalculPret calcPret) {
        this.idSimPret = idSimPret;
        this.dateSimulation = dateSimulation;
        this.dateContraction = dateContraction;
        this.dureePret = dureePret;
        this.mtPret = mtPret;
        this.typePret = typePret;
        this.blocked = blocked;
        this.calcPret = calcPret;
    }

    public int getIdSimPret() {
        return idSimPret;
    }

    public void setIdSimPret(int idSimPret) {
        this.idSimPret = idSimPret;
    }

    public Timestamp getDateSimulation() {
        return dateSimulation;
    }

    public void setDateSimulation(Timestamp dateSimulation) {
        this.dateSimulation = dateSimulation;
    }

    public Timestamp getDateContraction() {
        return dateContraction;
    }

    public void setDateContraction(Timestamp dateContraction) {
        this.dateContraction = dateContraction;
    }

    public int getDureePret() {
        return dureePret;
    }

    public void setDureePret(int dureePret) {
        this.dureePret = dureePret;
    }

    public double getMtPret() {
        return mtPret;
    }

    public void setMtPret(double mtPret) {
        this.mtPret = mtPret;
    }

    public TypePret getTypePret() {
        return typePret;
    }

    public void setTypePret(TypePret typePret) {
        this.typePret = typePret;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public CalculPret getCalcPret() {
        return calcPret;
    }

    public void setCalcPret(CalculPret calcPret) {
        this.calcPret = calcPret;
    }

    public void setTypeEmprunt(TypeEmprunt typeEmprunt) {
        this.typeEmprunt = typeEmprunt;
    }

    public TypeEmprunt getTypeEmprunt() {
        return typeEmprunt;
    }
    

    
    
            
}
