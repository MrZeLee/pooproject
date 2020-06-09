package MVC.Controller;

import java.util.ArrayList;

import Base.Basic.Coordenadas;
import MVC.Model.Model;

public class ControllerLoja extends Controller {

    private final String[] lojaRegister = {"Loja(Register)"};
    private final String[] lojaLogin = {"Loja(Login)"};
    private final String[] jaExiste = {"Loja já registada"};
    private final String[] naoExiste = {"Loja não existe"};
    private final String[] nomeRegister = {"Nome(Register)"};
    private final String[] password = {"Password"};
    private final String[] passwordRegister = {"Password(Register)"};
    private final String[] passwordRegister1 = {"Password (Confirm Password)"};
    private final String[] lojaQueue = {"Queue"};
    private final String[] gpsRegister = {"GPS(Register)_0.0,0.0"};
    private final String[] quit = {"Quit"};
    private final String[] loginSuccess = {"Menu da Loja", "Sinalizar Encomenda Disponivel", "Verificar Queue"};

    
    private ArrayList<Object> cache = new ArrayList<>(5);
    private String loja = new String();

    public ControllerLoja(Model model){
        super(model);
    }

    @Override
    protected void update(){
        String[] campos = this.getOption().split("-");

        switch(campos[0]){
            case "Menu":
                if (campos.length == 1){
                    break;
                }
                switch(campos[1]){
                    case "0":
                        this.setScreen(quit);
                        break;
                    case "1":
                        this.setScreen(lojaLogin);
                        break;
                    case "2":
                        this.setScreen(lojaRegister);
                }
                break;
            //Register Shop
            case "Loja(Register)"{
                if (campos.length == 1){
                    break;
                }
                if (this.getModel().contains(campos[1])){
                    this.setScreen(jaExiste);
                }
                else {
                    cache.add(0,campos[1]);
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

            case "Password (Confirm Password)":
                if(campos.length == 1) {
                    break;
                }
                if(((String) cache.get(4)).equals(campos[1])){
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
                    Coordenadas coordenadas = new Coordenadas();
                    try {
                        coordenadas.setLatitude(Double.parseDouble(coord[0]));
                    } catch (NumberFormatException e) {
                        this.setScreen(gpsRegister);
                    } catch (NullPointerException e) {
                        this.setScreen(gpsRegister);
                    }
                    try {
                        coordenadas.setLongitude(Double.parseDouble(coord[1]));
                    } catch (NumberFormatException e) {
                        this.setScreen(gpsRegister);
                    } catch (NullPointerException e) {
                        this.setScreen(gpsRegister);
                    }
                    cache.add(2,coordenadas);
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
                this.getModel().addLoja(new Loja(((String) cache.get(0)), campos[1], ((String) cache.get(0)), ((String) cache.get(1)), new Coordenadas(((Double) cache.get(2)), ((Double) cache.get(3)))));
                cache.clear();
                this.setScreen(getLogin());
            }
        }
    }
}