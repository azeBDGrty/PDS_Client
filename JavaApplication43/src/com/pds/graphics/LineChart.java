/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pds.graphics;

import com.pds.entities.CalculPret;
import com.pds.entities.SimulationPret;
import com.pds.entities.Taux_directeur;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Nodaro
 */
public class LineChart extends ApplicationFrame {
    
        private static CalculPret calculPret;
    private static SimulationPret simPret;
    
    public LineChart() throws SQLException {
        super("Graphique d'amortissement");
        init(1);
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
        
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private JPanel createChartPanel() {
        // creates a line chart object
        // returns the chart panel
        
        String chartTitle = "Graphique d'amortissement";
        String xAxisLabel = "Mensualités";
        String yAxisLabel = "Montant";
        
        XYDataset dataset = createDataset();
        
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);
        
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        // sets paint color for each series
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        
        // sets thickness for series (using strokes)
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        //plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
        return new ChartPanel(chart);
    }
    
    private XYDataset createDataset() {
        // creates an XY dataset...
        // returns the dataset
        List<Double> capAmorti=new ArrayList<>();
        List<Double> capRestant=new ArrayList<>();
        List<Double> evolutionInterets=new ArrayList<>();
        evolutionInterets=simPret.calcEvolutionInterets();
        evolutionInterets.add(0,0d);
        capAmorti=simPret.calcEvolutionCapAmmorti();
        capRestant=simPret.calcCapRestant();
        capRestant.add(0, simPret.getMtPret());
        System.out.println(capAmorti);
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Capital Remboursé");
        XYSeries series2 = new XYSeries("Reste dû");
        XYSeries series3 = new XYSeries("Interêts remboursés");
        
        for (int i=0; i<=simPret.getDureePret();i++){
            series1.add(i,capAmorti.get(i) );
            series2.add(i, capRestant.get(i));
            series3.add(i, evolutionInterets.get(i));
        }
       
        
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        
        return dataset;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new LineChart().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(LineChart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
public static void init(int idClient) throws SQLException{
       simPret=new SimulationPret();
       calculPret=new CalculPret();
        Taux_directeur td=new Taux_directeur();
        calculPret.setTauxDirecteur(td);
        simPret.setCalcPret(calculPret);
        simPret.setAmortisationCalcPret(calculPret, idClient,td);
   }}

