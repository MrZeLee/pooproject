package MVC.Controller;

import MVC.Controller.Menu.Menu;
import MVC.Model.Model;

public class ControllerUtilizador extends Controller{

    private final String[] s2 = {"Test", "Test", "Test"};
    private final String[] menuLogin ={"Insira Nome de Utilizador", "Insira Palavra-Passe"};
    private final Menu m2 = new Menu(s2);
    private final Menu mL = new Menu(menuLogin);

    public ControllerUtilizador(Model model){
        super(model);
    }

    @Override
    protected void update() {
        switch (this.getOption()) {
            case "0":
                System.out.println("Operation Cancelled");
                break;
            case "1":
                this.setScreen(mL.toString());
                break;
            case "2":
                this.setScreen(m2.toString());
                break;
        }

    }

    

}