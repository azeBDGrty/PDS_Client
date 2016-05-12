/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pds.graphics;

import com.pds.entities.CalculPret;
import com.pds.entities.SimulationPret;
import com.pds.entities.Taux_directeur;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nodaro
 */
public class AmortisationTable extends javax.swing.JFrame {
    
    private JFrame frame;
    private SimulationPret simulationPret;
    private CalculPret calculPret;
    
    /**
     * Creates new form AmortisationTable
     */
    public AmortisationTable() throws SQLException {
        initComponents();
        frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(330);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.setTitle("Tableau d'amortissement");
        
        //récupération des données dans la base, + peuplement de simulationpret
        calculPret=new CalculPret();
        Taux_directeur td=new Taux_directeur();
        calculPret.setTauxDirecteur(td);
        setAmortisationCalcPret(calculPret, 1,td);
        simulationPret=new SimulationPret();
        
        simulationPret.setCalcPret(calculPret);
        setAmortisationData(simulationPret,1);
        calcMensualite(simulationPret);
        List<Double> capAmorti=new ArrayList<Double>();
        capAmorti=this.calcCapAmmort(simulationPret);
        List<Double> capRestant=new ArrayList<Double>();
        capRestant=calcCapRestant( simulationPret);
        
        double assurance=calcAssurance(simulationPret);
        double totalAPayer=calcMensualite(simulationPret);
        String col[] = {"Mois", "Date", "Montant remboursé", "Intérêts", "Montant restant à rembourser", "Assurance", "Coût total"};
        DefaultTableModel dtm = new DefaultTableModel(col, 0);
        jTable1.setModel(dtm);
        Object[] objs = {1, "Arsenal", 35, 11, 2, 2, 15, 30, 11, 19};
        for (int i=0;i<simulationPret.getDureePret();i++){
            Object[] data = {i+1, "t", capAmorti.get(i), "interets",capRestant.get(i),assurance,totalAPayer
            };
            dtm.addRow(data);
        }
         
        
        
    }
    
    
    //récupération des données du client ayant l'id idClient
    public void setAmortisationData(SimulationPret simPret, int idClient) throws SQLException{
        DbConnection.connection();
        Statement st=DbConnection.connection.createStatement();
        String sql = ("SELECT * FROM simul_pret WHERE id_client="+idClient);
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()) {
            
            simPret.setMtPret(rs.getDouble("mt_pret"));
            simPret.setDureePret(rs.getInt("duree_pret"));
            
        }
        
        DbConnection.connection.close();
        
    }
    
    public void setAmortisationCalcPret(CalculPret cp, int idClient, Taux_directeur td) throws SQLException{
        DbConnection.connection();
        Statement st=DbConnection.connection.createStatement();
        String sql = ("SELECT * FROM simul_pret,calcpret,taux_directeur WHERE id_client="+idClient +" AND simul_pret.id_calcPret=calcPret.id_calcPret "
                + "AND calcpret.id_tauxDirecteur=taux_directeur.id_tauxDirecteur");
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()) {
            td.setValue(rs.getDouble("valeur"));
            cp.setCoef_assurance(rs.getDouble("coef_assurance"));
            cp.setT_marge(rs.getDouble("t_marge"));
        }
        System.out.println(cp);
        DbConnection.connection.close();
        
    }
    
    //calcule la mensualité d'un prêt
    public double calcMensualite(SimulationPret simPret){
        //double mensualite = (montantPret*(teag/100)/12)        /    (1-Math.pow(((1+(teag/100/12))), -24))+ (montantAssurance/dureePret);
        double mtTTAssurance = (simPret.getMtPret()*simPret.getDureePret()*simPret.getCalcPret().getCoef_assurance())/1200;
        double TEAG = simPret.getCalcPret().getTauxDirecteur().getValue() + simPret.getCalcPret().getT_marge();
        double mensualite = (simPret.getMtPret()*(TEAG/100)/12)        /    (1-Math.pow(((1+(TEAG/100/12))), -simPret.getDureePret()))+ (mtTTAssurance/simPret.getDureePret());
        mensualite=(double)Math.round(mensualite * 100d) / 100d; // on arrondit à 2 décimale
        
        return mensualite;
    }
    
    public double calcAssurance(SimulationPret simPret){
        double mtTTAssurance = (simPret.getMtPret()*simPret.getDureePret()*simPret.getCalcPret().getCoef_assurance())/1200;
        mtTTAssurance=mtTTAssurance/simPret.getDureePret();
        return mtTTAssurance;
    }
    
    public List<Double> calcCapRestant(SimulationPret simPret){
        List<Double> capsRestant = new ArrayList<>();
        List<Double> capsAmort = new ArrayList<>();
        capsAmort=calcCapAmmort(simPret);
        double initCapRestant=simPret.getMtPret()-capsAmort.get(0);
        capsRestant.add(initCapRestant);
        for (int i=0;i<capsAmort.size();i++){
            double capsRestantdu=capsRestant.get(i)-capsAmort.get(i);
            capsRestant.add(capsRestantdu);
        }
        System.out.println(capsRestant);
        return capsRestant;
    }
    
    //retourne une liste de toute les valeurs des capitaux amortis mensuels
    public List<Double> calcCapAmmort(SimulationPret simPret){
        List<Double> capsAmort = new ArrayList<>();
        
        double TEAG = simPret.getCalcPret().getTauxDirecteur().getValue() + simPret.getCalcPret().getT_marge();
        double varCapAmort = (simPret.getMtPret()*TEAG/100/12)  /  (Math.pow((1+TEAG/100/12), simPret.getDureePret()) -1);
        capsAmort.add((double)Math.round(varCapAmort* 100d) / 100d);
        
        for(int i = 2;i<=simPret.getDureePret();i++)
            capsAmort.add((double)Math.round(Math.pow((1 + TEAG/100/12), i-1)*varCapAmort * 100d) / 100d);
        
        return capsAmort;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mois", "Date", "Montant remboursé", "Intérêts", "Montant restant à rembourser", "Assurance", "Coût total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Tableau d'amortissement mensuel:");

        jMenu1.setText("File");

        jMenuItem1.setText("Imprimer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        PrinterJob job = PrinterJob.getPrinterJob();
        
        PageFormat format = job.defaultPage();
        format.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = job.pageDialog(format);
        job.setPrintable(new Printer(frame), format);
        
        try{
            if(job.printDialog()) job.print();
        }
        catch(Exception e){e.printStackTrace();}
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AmortisationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmortisationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmortisationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmortisationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AmortisationTable().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AmortisationTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    
}
