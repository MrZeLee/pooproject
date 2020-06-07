import java.util.Scanner;

import javax.swing.SwingUtilities;

import MVC.Model.Model;
import MVC.Controller.Menu.Menu;
import MVC.View.View;
import MVC.Controller.Controller;
import MVC.Controller.ControllerTransportadora;
import MVC.Controller.ControllerUtilizador;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        int option = -1;
        String[] mainOptions = { "Menu", "Utilizador", "Loja", "Voluntario", "Transportadora" };
        Menu m = new Menu(mainOptions);
        //Controller controller = null;

        while (option != 0) {
            System.out.println(m.toString());
            option = m.lerOpcao();
            final int innerop = Integer.valueOf(option);
            SwingUtilities.invokeLater(new Runnable(){
            
                @Override
                public void run() {
                    //Controller controller = new ControllerUtilizador(model);
                    
                    switch (innerop) {       
                         case 0:
                            System.out.println("See you again!");
                            break;
                         case 1:
                            Controller controller = new ControllerUtilizador(model);
                            View viewU = new View(controller);
                            viewU.run();
                            break;
                         case 2:
                             //controller = new ControllerLoja(model);
                             break;
                         case 3:
                            // controller = new ControllerVoluntario(model);
                            // View viewV = new View(controller);
                            // viewV.run();
                             break;
                         case 4:
                            // controller = new ControllerTransportadora(model); 
                            // View viewT = new View(controller);
                            // viewT.run();
                             break;
                         default:
                            System.out.println("No Valid Input Given!");
                             break;
                    }
                     
                    
                }
            });
        }
    }
}