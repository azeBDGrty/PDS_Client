/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_FormePrincipale;


import HandleServer.AbstractHandle;
import HandleServer.ConseillerHandle;
import MVC_Connection.Controller_Connection;
import MVC_Connection.View_Connection;
import MVC_GestClient.Controller_GestClient;
import MVC_GestClient.View_GestClient;
import javax.swing.JInternalFrame;

/**
 *
 * @author zouhairhajji
 */
public class Controller_MDIForm {
    
    private AbstractHandle model;
    
    public Controller_MDIForm(AbstractHandle serverHandler) {
        this.model = serverHandler;
    }

    public void setModelConseiller(ConseillerHandle model) {
        this.model = model;
    }
    
    
    
    public JInternalFrame ouvrirConnection(){
        Controller_Connection controllerConnection = new Controller_Connection(model);
        View_Connection viewConnection = new View_Connection(controllerConnection);
        model.addObserver(viewConnection);
        return viewConnection;
    }
    
    public View_GestClient ouvrirListClient(){
        Controller_GestClient controllerGestClient = new Controller_GestClient((ConseillerHandle) model);
        View_GestClient viewGestClient = new View_GestClient(controllerGestClient);
        model.addObserver(viewGestClient);
        viewGestClient.chargerTable(model.getClients());
        return viewGestClient;
    }
    
}
