/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_GestClient;

import com.pds.entities.SimulationPret;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author zouhairhajji
 */
public class PanelSimPret extends javax.swing.JPanel {

    private boolean selected;
    public PanelSimPret() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tSelectionner = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        numSim = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        iTypeEmprunt = new javax.swing.JTextField();
        iTypePret = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        iDureePret = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        iDateContraction = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        iMtPret = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        iTauxInteret = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        iTauxAssurance = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        iTTInteret = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        iTTAssurance = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        iRembourssement = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        iTTPret = new javax.swing.JTextField();
        lTypeEmprunt = new javax.swing.JLabel();
        lTypePret = new javax.swing.JLabel();
        lDureePret = new javax.swing.JLabel();
        lDateContraction = new javax.swing.JLabel();
        lMtPret = new javax.swing.JLabel();
        lTauxAssurance = new javax.swing.JLabel();
        lTauxInteret = new javax.swing.JLabel();
        lTTInteret = new javax.swing.JLabel();
        lTTAssurance = new javax.swing.JLabel();
        lMtRembourssement = new javax.swing.JLabel();
        lTotal = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Afficher");

        tSelectionner.setText("Selectionner");
        tSelectionner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSelectionnerActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setText("Supprimer");

        numSim.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        numSim.setText("Numero : ");

        jLabel9.setText("Type d'emprunt     :");

        iTypeEmprunt.setEditable(false);

        iTypePret.setEditable(false);

        jLabel10.setText("Type de prêt   :");

        iDureePret.setEditable(false);

        jLabel11.setText("Durée de prêt        :");

        iDateContraction.setEditable(false);

        jLabel12.setText("Date de contraction :");

        iMtPret.setEditable(false);

        jLabel13.setText("Le montant du prêt :");

        iTauxInteret.setEditable(false);

        jLabel14.setText("Taux D'interet (TAEG) :");

        iTauxAssurance.setEditable(false);

        jLabel15.setText("Taux d'assurance   :");

        iTTInteret.setEditable(false);
        iTTInteret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iTTInteretActionPerformed(evt);
            }
        });

        jLabel16.setText("Mt total des interêts :");

        iTTAssurance.setEditable(false);

        jLabel17.setText("Mt total de l'assurance:");

        jLabel18.setText("Mt de rembourssement :");

        iRembourssement.setEditable(false);

        jLabel19.setText("Cout total de prêt   :");

        iTTPret.setEditable(false);

        lTypeEmprunt.setText("...");

        lTypePret.setText("...");

        lDureePret.setText("...");

        lDateContraction.setText("...");

        lMtPret.setText("...");

        lTauxAssurance.setText("...");

        lTauxInteret.setText("...");

        lTTInteret.setText("...");

        lTTAssurance.setText("...");

        lMtRembourssement.setText("...");

        lTotal.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(iTTInteret, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(iTauxAssurance)
                                    .addComponent(iTauxInteret, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iMtPret, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iDateContraction, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iDureePret, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iTTAssurance)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tSelectionner, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iTTPret)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iRembourssement, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(numSim)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iTypeEmprunt, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(iTypePret))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMtPret, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(lDateContraction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTauxInteret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTTInteret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTauxAssurance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTTAssurance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lMtRembourssement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lDureePret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTypePret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTypeEmprunt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(numSim)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(iTypeEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTypeEmprunt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(iTypePret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTypePret))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(iDureePret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lDureePret))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(iDateContraction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lDateContraction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(iMtPret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lMtPret))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(iTauxInteret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTauxInteret))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(iTauxAssurance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTauxAssurance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(iTTInteret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTTInteret))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(iTTAssurance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTTAssurance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(iRembourssement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lMtRembourssement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(iTTPret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTotal))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tSelectionner, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tSelectionnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSelectionnerActionPerformed
        this.selected = !this.selected;
    }//GEN-LAST:event_tSelectionnerActionPerformed

    private void iTTInteretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iTTInteretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iTTInteretActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField iDateContraction;
    private javax.swing.JTextField iDureePret;
    private javax.swing.JTextField iMtPret;
    private javax.swing.JTextField iRembourssement;
    private javax.swing.JTextField iTTAssurance;
    private javax.swing.JTextField iTTInteret;
    private javax.swing.JTextField iTTPret;
    private javax.swing.JTextField iTauxAssurance;
    private javax.swing.JTextField iTauxInteret;
    private javax.swing.JTextField iTypeEmprunt;
    private javax.swing.JTextField iTypePret;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lDateContraction;
    private javax.swing.JLabel lDureePret;
    private javax.swing.JLabel lMtPret;
    private javax.swing.JLabel lMtRembourssement;
    private javax.swing.JLabel lTTAssurance;
    private javax.swing.JLabel lTTInteret;
    private javax.swing.JLabel lTauxAssurance;
    private javax.swing.JLabel lTauxInteret;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel lTypeEmprunt;
    private javax.swing.JLabel lTypePret;
    private javax.swing.JLabel numSim;
    private javax.swing.JToggleButton tSelectionner;
    // End of variables declaration//GEN-END:variables

    public void chargerSimulation(SimulationPret simPret) {
        this.numSim.setText(this.numSim.getText()+" " + simPret.getIdSimPret());
        this.iTypeEmprunt.setText(simPret.getTypeEmprunt().getAbv());
        this.iTypePret.setText(simPret.getTypePret().getAbv());
        this.iDateContraction.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date(simPret.getDateContraction().getTime())));
        this.iDureePret.setText(simPret.getDureePret()+"");
        this.iMtPret.setText(simPret.getMtPret()+"");
        double TEAG = simPret.getCalcPret().getTauxDirecteur().getValue() + simPret.getCalcPret().getT_marge();
        this.iTauxInteret.setText(TEAG+"");
        this.iTauxAssurance.setText(simPret.getCalcPret().getCoef_assurance()+"");
        double mtTTInteret = (simPret.getMtPret()*simPret.getDureePret()*TEAG)/1200;
        double mtTTAssurance = (simPret.getMtPret()*simPret.getDureePret()*simPret.getCalcPret().getCoef_assurance())/1200;
        this.iTTInteret.setText(mtTTInteret+"");
        this.iTTAssurance.setText(mtTTAssurance+"");
        double mensualite = (mtTTInteret + mtTTAssurance + simPret.getMtPret())/simPret.getDureePret();
        this.iRembourssement.setText(mensualite+"");
        this.iTTPret.setText(mensualite*simPret.getDureePret()+"");
    }

    public JToggleButton gettSelectionner() {
        return tSelectionner;
    }
    
    public void clearCell(JLabel label, String texte, Color color){
        label.setText(texte);
        label.setForeground(color);
    }
    
    public void setCell(JLabel label, double value1, double value2){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits ( 2 ) ; //arrondi à 2 chiffres apres la virgules 
        df.setMinimumFractionDigits ( 2 ) ; 
        df.setDecimalSeparatorAlwaysShown ( true ) ; 
        double res = value1 - value2;
        
        if(res < 0)
            this.clearCell(label, df.format(res*-1), Color.BLACK);
        else
            this.clearCell(label, df.format(res*-1), Color.RED);
        
    }
    
    
    
    public void clearComparaison(){
        clearCell(lDateContraction, "...", Color.BLACK);
        clearCell(lDureePret, "...", Color.BLACK);
        clearCell(lMtPret, "...", Color.BLACK);
        clearCell(lMtRembourssement, "...", Color.BLACK);
        clearCell(lTTAssurance, "...", Color.BLACK);
        clearCell(lTTInteret, "...", Color.BLACK);
        clearCell(lTotal, "...", Color.BLACK);
        clearCell(lTypeEmprunt, "...", Color.BLACK);
        clearCell(lTypePret, "...", Color.BLACK);
        clearCell(lTauxAssurance, "...", Color.BLACK);
        clearCell(lTauxInteret, "...", Color.BLACK);
    }
    
    
    public void compararer(PanelSimPret frameComp){
        setCell(lTauxInteret, Double.parseDouble(iTauxInteret.getText()), Double.parseDouble(frameComp.getiTauxInteret().getText()));
        setCell(lDureePret, Double.parseDouble(iDureePret.getText()), Double.parseDouble(frameComp.getiDureePret().getText()));
        setCell(lMtPret, Double.parseDouble(iMtPret.getText()), Double.parseDouble(frameComp.getiMtPret().getText()));
        setCell(lMtRembourssement, Double.parseDouble(iRembourssement.getText()), Double.parseDouble(frameComp.getiRembourssement().getText()));
        setCell(lTTAssurance, Double.parseDouble(iTTAssurance.getText()), Double.parseDouble(frameComp.getiTTAssurance().getText()));
        setCell(lTotal, Double.parseDouble(iTTPret.getText()), Double.parseDouble(frameComp.getiTTPret().getText()));
        
        this.validate();
        this.repaint();
    }

    public JTextField getiDateContraction() {
        return iDateContraction;
    }

    public JTextField getiDureePret() {
        return iDureePret;
    }

    public JTextField getiMtPret() {
        return iMtPret;
    }

    public JTextField getiRembourssement() {
        return iRembourssement;
    }

    public JTextField getiTTAssurance() {
        return iTTAssurance;
    }

    public JTextField getiTTInteret() {
        return iTTInteret;
    }

    public JTextField getiTTPret() {
        return iTTPret;
    }

    public JTextField getiTauxAssurance() {
        return iTauxAssurance;
    }

    public JTextField getiTauxInteret() {
        return iTauxInteret;
    }

    public JTextField getiTypeEmprunt() {
        return iTypeEmprunt;
    }

    public JTextField getiTypePret() {
        return iTypePret;
    }
    
    
    
    
}
