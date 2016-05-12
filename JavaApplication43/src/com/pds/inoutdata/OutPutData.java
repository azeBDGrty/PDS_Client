/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.inoutdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import static com.pds.networkprotocol.Send.*;

/**
 *
 * @author zouhairhajji
 */
public class OutPutData {
    
    
    private PrintWriter writer;
    private XMLOutputter outPutter;
    
    public OutPutData(Socket socket) throws IOException {
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        this.outPutter = new XMLOutputter();
    }
    
    
    private synchronized  void sendMessage(String typeMessage, Element elementData){
        typeMessage = (typeMessage == null) ? "" : typeMessage;
        writer.println(typeMessage);
        String message;
        if(elementData == null || (message = new XMLOutputter().outputString(elementData)) == null)
            return;
        
        writer.println(message);
        writer.println(".");
    }
    
    public synchronized void askAuthentification(Element elementData){
        sendMessage(askAuthentification.toString(), elementData);
    }

    public synchronized void askInsertClient(Element elementData){
        sendMessage(askAddClient.toString(), elementData);
    }
    
    public void askAllClient(){
        sendMessage(askAllClient.toString(), null);
    }
    
    public synchronized void askModifyClient(Element elementData){
        sendMessage(askModifyClient.toString(), elementData);
    }
    
    public synchronized void askDeleteClient(Element elementData){
        sendMessage(askDeleteClient.toString(), elementData);
    }
    
    
    public void askAllInformationClient(Element elementData){
        sendMessage(askInformationClient.toString(), elementData);
    }
    
    
    
    public void askAllRegion(){
        sendMessage(askAllRegion.toString(), null);
    }
    
    public void askAllDepartement(){
        sendMessage(askAllDepartement.toString(), null);
    }
    
    public void askAllPays(){
        sendMessage(askAllPays.toString(), null);
    }
    
    public void askAllSimulationClientPret(Element element){
        sendMessage(askAllPays.toString(), element);
    }
    
    
    
}
