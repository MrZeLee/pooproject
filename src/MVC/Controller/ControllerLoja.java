package MVC.Controller;

import java.util.ArrayList;

import MVC.Model.Model;

public class ControllerLoja extends Controller {

    private final String[] lojaRegister = {"Loja(Register)"};
    private final String[] lojaLogin = {"Loja(Login)"};
    private final String[] jaExiste = {"Loja já registada"};
    private final String[] naoExiste = {"Loja não existe"};
    private final String[] password = {"Password"};
    private final String[] passwordRegister = {"Password(Register)"};
    private final String[] passwordRegister1 = {"Password(Register Again)"};
    private final String[] gpsRegister = {"GPS(Register)_0.0,0.0"};
    private final String[] quit = {"Quit"};
    
    private ArrayList<Object> cache = new ArrayList<>();
    private String loja = new String();

    public ControllerLoja(Model model){
        super(model);
    }

    @Override
    protected void update(){
        String[] campos = this.getOption().split("-");

        switch(campos[0]){
            case "Menu":
        }
    }
}