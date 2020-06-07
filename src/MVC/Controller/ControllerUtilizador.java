package MVC.Controller;

import java.util.ArrayList;

import Base.Basic.Coordenadas;
import MVC.Controller.Menu.Menu;
import MVC.Model.Model;
import Users.Utilizador;

public class ControllerUtilizador extends Controller{

    private final String[] utilizadorRegister = {"Utilizador(Register)"};
    private final String[] utilizadorLogin = {"Utilizador(Login)"};
    private final String[] jaExiste = {"Utilizador já Registado"};
    private final String[] naoExiste = {"Utilizador não Existe"};
    private final String[] password = {"Password"};
    private final String[] passwordRegister = {"Password(Register)"};
    private final String[] passwordRegister1 = {"Password(Register Again)"};
    private final String[] gpsRegister = {"GPS(Register)_0.0,0.0"};
    private final String[] nomeRegister = {"Nome(Register)"};
    private final String[] passwordErrada = {"Password Errada"};

    private final String[] quit = {"quit"};

    private ArrayList<Object> cache = new ArrayList<>();

    public ControllerUtilizador(Model model){
        super(model);
    }

    @Override
    protected void update() {
        String[] campos = this.getOption().split("-");

        switch (campos[0]) {
            case "Menu":
                if(campos.length == 1) {
                    break;
                }
                switch(campos[1]) {
                    case "0":
                        this.setScreen(quit);
                        break;
                    case "1":
                        this.setScreen(utilizadorLogin);
                        break;
                    case "2":
                        this.setScreen(utilizadorRegister);
                        break;
                }
                break;
            //REGISTER
            case "Utilizador(Register)":
                if(campos.length == 1) {
                    break;
                }
                if (this.getModel().contains(campos[1])) {
                    this.setScreen(jaExiste);
                }
                else {
                    cache.add(campos[1]);
                    this.setScreen(passwordRegister);
                }
                break;
            case "Password(Register)":
                if(campos.length == 1) {
                    break;
                }
                cache.add(campos[1]);
                this.setScreen(passwordRegister1);
                break;
            case "Password(Register Again)":
                if(campos.length == 1) {
                    break;
                }
                if(((String) cache.get(1)).equals(campos[1])){
                    this.setScreen(gpsRegister);
                }
                else {
                    cache.clear();
                    this.setScreen(getLogin());
                }
                break;
            case "GPS(Register)":
                if(campos.length == 1) {
                    break;
                }
                String[] coord = campos[1].split(",");
                if(coord.length == 2){
                    try {
                        cache.add(Double.parseDouble(coord[0]));
                    } catch (NumberFormatException e) {
                        this.setScreen(gpsRegister);
                    } catch (NullPointerException e) {
                        this.setScreen(gpsRegister);
                    }
                    try {
                        cache.add(Double.parseDouble(coord[1]));
                    } catch (NumberFormatException e) {
                        cache.remove(cache.size()-1);
                        this.setScreen(gpsRegister);
                    } catch (NullPointerException e) {
                        cache.remove(cache.size()-1);
                        this.setScreen(gpsRegister);
                    }
                    this.setScreen(nomeRegister);
                }
                else {
                    setScreen(gpsRegister);
                }
                break;
            case "Nome(Register)":
                if(campos.length == 1) {
                    break;
                }
                this.getModel().addUtilizador(new Utilizador(((String) cache.get(0)), campos[1], ((String) cache.get(0)), ((String) cache.get(1)), new Coordenadas(((Double) cache.get(2)), ((Double) cache.get(3)))));
                cache.clear();
                this.setScreen(getLogin());
                break;
            case "Utilizador já Registado":
                cache.clear();
                this.setScreen(super.getLogin());
                break;
            //LOGIN
            case "Utilizador(Login)":
                if(campos.length == 1) {
                    break;
                }
                if (this.getModel().contains(campos[1])) {
                    cache.add(campos[1]);
                    this.setScreen(password);
                }
                else {
                    this.setScreen(naoExiste);
                }
                break;
            case "Password":
                if(campos.length == 1) {
                    break;
                }
                if (this.getModel().password(((String) cache.get(0)), campos[1])) {
                    cache.clear();
                    setScreen(getLogin());//por enquanto MUDAR TO DOO
                }
                else {
                    setScreen(passwordErrada);
                }
                break;
            case "Password Errada":
                cache.clear();
                this.setScreen(super.getLogin());
                break;
            case "Utilizador não Existe":
                cache.clear();
                this.setScreen(super.getLogin());
                break;
        }
        return;
    }

    

}