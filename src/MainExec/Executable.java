/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainExec;

import com.pds.entities.Anonyme;
import HandleServer.AnonymeHandle;
import InOutData.InPutData;
import InOutData.OutPutData;
import MVC_FormePrincipale.Controller_MDIForm;
import MVC_FormePrincipale.Forme;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author zouhairhajji
 */
public class Executable {
    public static void main(String[] args) throws IOException, Exception {
        
        Socket socket = new Socket("localhost", 3000);
        
        InPutData in = new InPutData(socket);
        OutPutData out = new OutPutData(socket);
        Anonyme user = new Anonyme();
        
        AnonymeHandle model = new AnonymeHandle(in, out, user);
        
        
        
        /*
            Element root = new Element("InfoAuthentification");
                Element eLogin = new Element("login");
                eLogin.setText("Zouhair2");

                Element ePassWord = new Element("passWord");
                ePassWord.setText("12345");

                root.addContent(eLogin);
                root.addContent(ePassWord);


            out.askAuthentification(root);
        */
        
        Controller_MDIForm controller = new Controller_MDIForm(model);
        
        Forme view = new Forme(controller, true);
        model.addObserver(view);
        model.setDeskTopPane(view.getDesktopPane());
        view.setVisible(true);
        model.startListenning();
    }
}
