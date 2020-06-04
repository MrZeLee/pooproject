import java.util.Scanner;

import javax.swing.SwingUtilities;

import MVC.Model.Model;
import MVC.Controller.Menu.Menu;
import MVC.View.View;
import MVC.Controller.Controller;
import MVC.Controller.ControllerUtilizador;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        int option = -1;
        String[] mainOptions = {"Utilizador", "Loja", "Voluntario", "Transportadora"};
        Menu m = new Menu(mainOptions);
        
        while (option != 0) {
            System.out.println(m.toString());
            option = m.lerOpcao();
            SwingUtilities.invokeLater(new Runnable(){
        
                @Override
                public void run() {
                    Controller controller = new ControllerUtilizador(model);
                    // if (option == 1) {
                        // case 1:
                        // controller = new ControllerUtilizador(model);
                        //     break;
                        // case 2:
                        //     controller = new ControllerLoja(model);
                        //     break;
                        // case 3:
                        //     controller = new ControllerVoluntario(model);
                        //     break;
                        // case 4:
                        //     controller = new ControllerTransportadora(model);
                        //     break;
                        // default:
                        //     break;
                    // }

                    if(controller != null) {
                        View view = new View(controller);
                        view.run();
                    }
                }
            });
        }
    }
}