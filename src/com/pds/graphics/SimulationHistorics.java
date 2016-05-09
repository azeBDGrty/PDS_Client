/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;
/**
 *
 * @author Nodaro
 */
import javax.swing.*;
import java.lang.Float;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nodaro
 */
public class SimulationHistorics extends javax.swing.JFrame {
    
    /**
     * Creates new form HistoriqueSimulation
     */
    public SimulationHistorics() throws SQLException  {
        initComponents();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(130);
        DbConnection.connection();
        remplir(jTable1,"Select id_sim_pret, mt_pret,duree_pret, typeTaux, dateSimulation,"
                + " date_contraction, coef_assurance, t_marge, f_dossier, libelle"
                + " FROM simul_pret, calcpret, type_pret, client"
                + " WHERE simul_pret.id_client=client.id_client"
                + " AND simul_pret.id_type_pret=type_pret.id_type_pret"
                + " AND simul_pret.id_calcPret=calcpret.id_calcPret" ); //changer pour obtenir données du client qui s'est connecté
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if (jTable1.getSelectedRow() > -1) {
                    int numero= Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    float montant= Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                    int duree= Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    String typeTaux= jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                    String dateSimulation= jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
                    String dateContraction= jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
                    float tauxAssurance= Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
                    float tauxMarge= Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
                    float fraisDossier= Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
                    RefundEvolutionGraphic chart = new RefundEvolutionGraphic(
                            "Evolution du prêt" ,
                            "Evolution du montant à rembourser en fonction du temps", montant, duree,  tauxMarge, tauxAssurance);
                    
                    
                }
                
            }
        });
    }
    
    public void remplir(JTable table, String query) throws SQLException{
        Statement stat=DbConnection.connection.createStatement();
        ResultSet rs = stat.executeQuery(query);
        //To remove previously added rows
        while(table.getRowCount() > 0)
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = rs.getMetaData().getColumnCount();
        while(rs.next())
        {
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {
                row[i - 1] = rs.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
        }
        
        rs.close();
        stat.close();
        DbConnection.connection.close();
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numéro Simulation", "Montant", "Durée", "Taux ", "Date simulation", "Date contraction", "Taux assurance", "Taux marge", "Frais dossier", "Type de prêt"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    
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
            java.util.logging.Logger.getLogger(SimulationHistorics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulationHistorics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulationHistorics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulationHistorics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SimulationHistorics().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SimulationHistorics.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}