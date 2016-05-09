/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_customer;

import com.pds.entities.Client;
import com.pds.serverhandler.AbstractHandle;
import com.pds.serverhandler.ConseillerHandle;

/**
 *
 * @author zouhairhajji
 */
public class Controller_GestClient {
    private ConseillerHandle model;

    public Controller_GestClient(ConseillerHandle model) {
        this.model = model;
    }

    public void askListClient() {
    }

    void showFrameListSimPret(Client client) {
        
        ListSimPrets view = new ListSimPrets(this);
        model.getDeskTopPane().add(view);
        
        model.addObserver(view);
        view.chargerSimulations(client);
        view.setVisible(true);
    }
    
    
    
}
