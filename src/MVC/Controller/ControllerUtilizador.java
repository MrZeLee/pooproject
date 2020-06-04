package MVC.Controller;

import MVC.Controller.Menu.Menu;
import MVC.Model.Model;

public class ControllerUtilizador extends Controller{

    private final String[] s2 = {"Test", "Test", "Test"};
    private final Menu m2 = new Menu(s2);

    public ControllerUtilizador(Model model){
        super(model);
    }

    @Override
    protected void update() {
        switch (this.getOption()) {
            case "1":
                this.setScreen(m2.toString());
                break;
            default:
                this.setScreen(m2.toString());
                break;
        }

    }

    

}