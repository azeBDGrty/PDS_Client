/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;

import com.pds.entities.CalculPret;
import com.pds.entities.SimulationPret;
import com.pds.entities.Taux_directeur;
import java.sql.SQLException;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Nodaro
 */
public class PieChart extends ApplicationFrame{
    
    private static CalculPret calculPret;
    private static SimulationPret simPret;
    
    
    public PieChart( int idClient) throws SQLException {
        super("Répartion des remboursements");
        init(idClient);
        //setContentPane(createDemoPanel( ));
        //this.setSize( 560 , 367 );    
      //RefineryUtilities.centerFrameOnScreen( this);    
      //this.setVisible( true ); 
    }
    public static PieDataset createDataset( ) throws SQLException 
   {
      
      double capitalAmorti=simPret.calcSum(simPret.calcCapAmmort());
      double assurance=simPret.calcSumAssurance();
      double interets=simPret.calcSum(simPret.calcInterets());
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Capital" , capitalAmorti );  
      dataset.setValue( "Interets" , interets);   
      dataset.setValue( "Assurance" , assurance );    
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Répartion des remboursements",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   
   public static void init(int idClient) throws SQLException{
       simPret=new SimulationPret();
       calculPret=new CalculPret();
        Taux_directeur td=new Taux_directeur();
        calculPret.setTauxDirecteur(td);
        simPret.setCalcPret(calculPret);
        simPret.setAmortisationCalcPret(calculPret, idClient,td);
   }
   
   public static JPanel createDemoPanel( ) throws SQLException
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

}
