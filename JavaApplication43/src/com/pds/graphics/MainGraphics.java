/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;

import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nodaro
 */
public class MainGraphics extends JFrame{
    
    
    public MainGraphics (int idClient) throws SQLException{
        LineChart l=new LineChart(idClient);
        PieChart p=new PieChart(idClient);
        AmortisationTable at=new AmortisationTable(1);
        
        GridLayout gl = new GridLayout(2, 1);
        this.setLayout(gl);
        gl.setVgap(20); //20 pixels d'espace entre les lignes (V comme Vertical) 
        JPanel panelLineChart=l.createChartPanel();
        JPanel panelPieChart=p.createDemoPanel( );
        this.getContentPane().add(panelLineChart);
        this.getContentPane().add(panelPieChart);
        setSize(640, 700);
        this.setLocation(700, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String args[]) throws SQLException{
        MainGraphics m=new MainGraphics(1);
    }
}
