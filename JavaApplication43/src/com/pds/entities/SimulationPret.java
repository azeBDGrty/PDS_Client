/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pds.entities;

import com.pds.enums.TypeEmprunt;
import com.pds.enums.TypePret;
import com.pds.graphics.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    
    @Override
    public String toString() {
        return "SimulationPret{" + "idSimPret=" + idSimPret + ", dateSimulation=" + dateSimulation + ", dateContraction=" + dateContraction + ", dureePret=" + dureePret + ", mtPret=" + mtPret + ", typePret=" + typePret + ", blocked=" + blocked + ", calcPret=" + calcPret + ", typeEmprunt=" + typeEmprunt + '}';
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
    
    
    //calcule la mensualité d'un prêt
    public double calcMensualite(){
        //double mensualite = (montantPret*(teag/100)/12)        /    (1-Math.pow(((1+(teag/100/12))), -24))+ (montantAssurance/dureePret);
        double mtTTAssurance = (getMtPret()*getDureePret()*getCalcPret().getCoef_assurance())/1200;
        double TEAG = getCalcPret().getTauxDirecteur().getValue() + getCalcPret().getT_marge(); // taux directeur + taux marge
        double mensualite = (getMtPret()*(TEAG/100)/12)        /    (1-Math.pow(((1+(TEAG/100/12))), -getDureePret()))+ (mtTTAssurance/getDureePret());
        mensualite=(double)Math.round(mensualite * 100d) / 100d; // on arrondit à 2 décimale
        
        return mensualite;
    }
    
    public double calcAssurance(){
        double mtTTAssurance = (getMtPret()*getDureePret()*getCalcPret().getCoef_assurance())/1200;
        mtTTAssurance=mtTTAssurance/getDureePret();
        return mtTTAssurance;
    }
    
    public List<Double> calcCapRestant(){
        List<Double> capsRestant = new ArrayList<>();
        List<Double> capsAmort = new ArrayList<>();
        capsAmort=calcCapAmmort();
        double initCapRestant=getMtPret()-capsAmort.get(0);
        capsRestant.add(initCapRestant);
        for (int i=0;i<capsAmort.size()-1;i++){
            double capsRestantdu=capsRestant.get(i)-capsAmort.get(i+1);
            capsRestantdu=(double)Math.round(capsRestantdu*100d)/100d;
            capsRestant.add(capsRestantdu);
        }
        return capsRestant;
    }
    
    public List<Double> calcInterets(){
        List<Double> interets=new ArrayList<>();
        List<Double> capRestant=new ArrayList<>();
        capRestant=calcCapRestant();
        double interetMois;
        double montant=getMtPret();
        double TEAG = getCalcPret().getTauxDirecteur().getValue() + getCalcPret().getT_marge();
        TEAG=TEAG/100;
        double duree=getDureePret();
        double interetPremierMois=montant*(TEAG/12); //on divise par 12 pour obtenir le taux mensuel
        interets.add(interetPremierMois);
        for (int i=0;i<duree;i++){
            interetMois=capRestant.get(i)*TEAG/12;
            interetMois=(double)Math.round(interetMois*100d)/100d; // on arrondit au centièmre
            interets.add(interetMois);
        }
        
        return interets;
    }
    
    //retourne une liste de toute les valeurs des capitaux amortis mensuels
    public List<Double> calcCapAmmort(){
        List<Double> capsAmort = new ArrayList<>();
        
        double TEAG = getCalcPret().getTauxDirecteur().getValue() + getCalcPret().getT_marge();
        double varCapAmort = (getMtPret()*TEAG/100/12)  /  (Math.pow((1+TEAG/100/12), getDureePret()) -1);
        capsAmort.add((double)Math.round(varCapAmort* 100d) / 100d);
        
        for(int i = 2;i<=getDureePret();i++)
            capsAmort.add((double)Math.round(Math.pow((1 + TEAG/100/12), i-1)*varCapAmort * 100d) / 100d);
        
        return capsAmort;
    }
    

    //récupération des données du client ayant l'id idClient

    
    public void setAmortisationCalcPret(CalculPret cp, int idClient, Taux_directeur td) throws SQLException{
        DbConnection.connection();
        Statement st=DbConnection.connection.createStatement();
        String sql = ("SELECT * FROM simul_pret,calcpret,taux_directeur WHERE id_client="+idClient +" AND simul_pret.id_calcPret=calcPret.id_calcPret "
                + "AND calcpret.id_tauxDirecteur=taux_directeur.id_tauxDirecteur");
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()) {
            setMtPret(rs.getDouble("mt_pret"));
            setDureePret(rs.getInt("duree_pret"));
            td.setValue(rs.getDouble("valeur"));
            cp.setCoef_assurance(rs.getDouble("coef_assurance"));
            cp.setT_marge(rs.getDouble("t_marge"));
        }
        DbConnection.connection.close();
        
    }
    
    public double calcSum(List<Double> list){
        double sum=0;
        for (int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        sum=(double)Math.round(sum*100d)/100d;
        return sum;
    }
    
    public double calcSumAssurance(){
        double sumAssurance=0;
        for (int i=0;i<this.getDureePret();i++){
            sumAssurance+=this.calcAssurance();
        }
            return sumAssurance;
    
    }
    
    public List<Double> calcEvolutionCapAmmorti(){
        List<Double> capsAmort = new ArrayList<>();
        capsAmort=this.calcCapAmmort();
        for (int i=1;i<this.dureePret;i++){
            capsAmort.set(i, capsAmort.get(i)+capsAmort.get(i-1));
        }
        capsAmort.add(0, 0d);
        
        return capsAmort;
    }
    
    public List<Double> calcEvolutionInterets(){
        List<Double> capsInterets = new ArrayList<>();
        capsInterets=this.calcInterets();
        for (int i=1;i<this.dureePret;i++){
            capsInterets.set(i, capsInterets.get(i)+capsInterets.get(i-1));
        }
        capsInterets.add(0, 0d);
        
        return capsInterets;
    }
}
