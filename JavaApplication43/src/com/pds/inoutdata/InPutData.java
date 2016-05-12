/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.inoutdata;

import static com.pds.networkprotocol.Receive.*;
import com.pds.networkprotocol.Receive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.Socket;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * 
 * @author zouhairhajji
 */
public class InPutData {
    
    
    private Receive lastCommand;
    private Document lastDocument;
    private BufferedReader reader;
    
    public InPutData(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    
    
    private synchronized String readMessage() throws IOException{
        String message = reader.readLine();
        if (message == null) 
            throw new IOException();
        System.out.println(">>"+message);
        return message;
    }
    
    
    
        
        
    /**
     *  Cette méthode permet de lire toutes sortes d'information.
     */
    public synchronized void readElement() throws IOException{
        String ElementBuilder = "";
        String message = "";
        
        while( !  ".".equalsIgnoreCase(message = readMessage()) ){
            ElementBuilder += message; 
        }
        try {
            this.lastDocument = new SAXBuilder().build(new InputSource( new StringReader( ElementBuilder ) ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public Receive getlastCommand(){
        return this.lastCommand;
    }
            
            
    public synchronized Receive getCommand() throws IOException{
        this.lastCommand =  Receive.FactoryGetReceive(readMessage());
        System.out.println("Request : " + this.lastCommand);
        switch(lastCommand){        
            case connectionRefused : 
                break;
                
            case connectionDone : 
                break;
            
            case connectionAutorised :
                readElement();
                break;
            
            case sendInformationClient :
                readElement();
                break;
                
            case sendAllClient:
                readElement();
                break ;
                
                
                
                
                
            case sendAllRegion:
                readElement();
                break ;
                
            case sendAllDepartement:
                readElement();
                break ;
                
            case sendAllPays:
                readElement();
                break ;
                
            case sendSimulationPretsClient: 
                readElement(); 
                break;
                
            default:
                break;
        }
        return this.lastCommand;
    }

    public Document getLastDocument() {
        return this.lastDocument;
    }
    
    
    
}
