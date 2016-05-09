/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

/**
 *
 * @author Nodaro
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Nodaro
 */
public class RefundEvolutionGraphic extends ApplicationFrame {
    
    public RefundEvolutionGraphic( String applicationTitle , String chartTitle, float montant, int duree, float interets,float assurance)
    {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Années","Montant en euros",
                createDataset(montant, duree, interets, assurance),
                PlotOrientation.VERTICAL,
                true,true,false);
        
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
        this.pack( );
        RefineryUtilities.centerFrameOnScreen( this );
        this.setVisible( true );
    }
    
    private DefaultCategoryDataset createDataset(float montant, int duree, float interets,float assurance )
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        float coutAssurance=(montant*assurance)/100;
        float coutAssuranceMois=((montant*assurance)/100)/12;
        //Taux interets par mois
        float sumInterets;
        float interetMois;
       
        // formule de la part d'amortissement de la première mensualité
        //Soit le capital emprunté C0, le taux nominal annuel t (ou taux annuel proportionnel), la durée en mois n,
        //A = [C0 × t/12]÷[(1 + t/12)n − 1] 
        //formule du p nième amortissement
        //Ap =[(1 + t/12)p-1 × C0 × t/12]÷[(1 + t/12)n − 1] 
        float capAmortiMois0=(float) ((montant*(interets/12))/(Math.pow(1+(interets/12),duree))-1);
        float capitalRestantMois=montant;
        float totalAPayer;
        for (int i=0;i<12;i++){
            interetMois=((capitalRestantMois/12)*interets)/100;
            totalAPayer=capAmortiMois0+interetMois+coutAssuranceMois;
            
        }
        for (int i=1;i<duree;i++){
            String annee=Integer.toString(i);
            float capitalAmorti;
            float coutInterets;
            float capitanlRestant;
            
            dataset.addValue(montant/12, "Montant à rembourser" , annee );
        }

        return dataset;
    }
    public static void main( String[ ] args )
    {
        RefundEvolutionGraphic chart = new RefundEvolutionGraphic(
                "Evolution du prêt" ,
                "Evolution du montant à rembourser en fonction du temps",100000,12,1,1);
        
        
    }
}