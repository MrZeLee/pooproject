// package MVC.Controller;

// import java.util.ArrayList;

// import MVC.Controller.Menu.Menu;
// import MVC.Model.Model;

// public class ControllerVoluntario extends Controller{
//     private Menu menu[];
//     private final String[] voluntarioRegister = {"Voluntário(Register)"};
//     private final String[] voluntarioLogin = {"Voluntário(Login)"};
//     private final String[] jaExiste = {"Voluntário já Registado"};
//     private final String[] naoExiste = {"Voluntário não Existe"};
//     private final String[] password = {"Password"};
//     private final String[] passwordRegister = {"Password(Register)"};
//     private final String[] passwordRegister1 = {"Password(Register Again)"};
//     private final String[] gpsRegister = {"GPS(Register)_0.0,0.0"};
//     private final String[] nomeRegister = {"Nome(Register)"};
//     private final String[] passwordErrada = {"Password Errada"};

//     // o que é para por aqui?
//     private final String[] loginSucess = {"Menu Voluntário", "Solicitar Entrega de Encomenda - Voluntário", "Solicitar Entrega de Encomenda - Transportadora", "Entregas Efetuadas", "Classificar Ultima Entrega"};

//     private final String[] quit = {"quit"};

//     private ArrayList<Object> cache = new ArrayList<>();

//     public ControllerVoluntario(Model model){
//         super(model);
//     }

//     @Override
//     protected void update() {
//         String[] campos = this.getOption().split("-");

//         switch (campos[0]) {

//             case "Menu":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 switch(campos[1]) {
//                     case "0":
//                         this.setScreen(quit);
//                         break;
//                     case "1":
//                         this.setScreen(voluntarioLogin);
//                         break;
//                     case "2":
//                         this.setScreen(voluntarioRegister);
//                         break;
//                 }
//                 break;
// }

// //REGISTER
//             case "Voluntário(Register)":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 if (this.getModel().contains(campos[1])) {
//                     this.setScreen(jaExiste);
//                 }
//                 else {
//                     cache.add(campos[1]);
//                     this.setScreen(passwordRegister);
//                 }
//                 break;
//             case "Password(Register)":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 cache.add(campos[1]);
//                 this.setScreen(passwordRegister1);
//                 break;
//             case "Password(Register Again)":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 if(((String) cache.get(1)).equals(campos[1])){
//                     this.setScreen(gpsRegister);
//                 }
//                 else {
//                     cache.clear();
//                     this.setScreen(getLogin());
//                 }
//                 break;
//             case "GPS(Register)":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 String[] coord = campos[1].split(",");
//                 if(coord.length == 2){
//                     try {
//                         cache.add(Double.parseDouble(coord[0]));
//                     } catch (NumberFormatException e) {
//                         this.setScreen(gpsRegister);
//                     } catch (NullPointerException e) {
//                         this.setScreen(gpsRegister);
//                     }
//                     try {
//                         cache.add(Double.parseDouble(coord[1]));
//                     } catch (NumberFormatException e) {
//                         cache.remove(cache.size()-1);
//                         this.setScreen(gpsRegister);
//                     } catch (NullPointerException e) {
//                         cache.remove(cache.size()-1);
//                         this.setScreen(gpsRegister);
//                     }
//                     this.setScreen(nomeRegister);
//                 }
//                 else {
//                     setScreen(gpsRegister);
//                 }
//                 break;
//             case "Nome(Register)":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 this.getModel().addVoluntario(new Voluntário(((String) cache.get(0)), campos[1], ((String) cache.get(0)), ((String) cache.get(1)), new Coordenadas(((Double) cache.get(2)), ((Double) cache.get(3)))));
//                 cache.clear();
//                 this.setScreen(getLogin());
//                 break;
//             case "Voluntário já Registado":
//                 cache.clear();
//                 this.setScreen(super.getLogin());
//                 break;
// //LOGIN
//             case "Voluntário(Login)":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 if (this.getModel().contains(campos[1])) {
//                     cache.add(campos[1]);
//                     this.setScreen(password);
//                 }
//                 else {
//                     this.setScreen(naoExiste);
//                 }
//                 break;
//             case "Password":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 if (this.getModel().password(((String) cache.get(0)), campos[1])) {
//                     cache.clear();
//                     setScreen(loginSucess);
//                 }
//                 else {
//                     setScreen(passwordErrada);
//                 }
//                 break;
//             case "Password Errada":
//                 cache.clear();
//                 this.setScreen(super.getLogin());
//                 break;
//             case "Voluntário não Existe":
//                 cache.clear();
//                 this.setScreen(super.getLogin());
//                 break;
// // a partir daqui falta o que falta lá em cima 
//             case "Menu Voluntário":
//                 if(campos.length == 1) {
//                     break;
//                 }
//                 switch (campos[1]) {
//                     case "1":
//                         List<String> list = new ArrayList<String>();
//                         list.add("Solicitar Entrega de Encomenda ~ Voluntário");
//                         for (String string : this.getModel().getEncomendas(utilizador)) {
//                             list.add(string);
//                         }
//                         for (String string : list) {
//                             cache.add(string);
//                         }
//                         setScreen(list);
//                         break;
//                     case "2":
//                         List<String> list1 = new ArrayList<String>();
//                         list1.add("Solicitar Entrega de Encomenda ~ Transportadora");
//                         for (String string : this.getModel().getEncomendas(utilizador)) {
//                             list1.add(string);
//                         }
//                         for (String string : list1) {
//                             cache.add(string);
//                         }
//                         setScreen(list1);
//                         break;
//                     case "3":
                        
//                         break;
//                     case "4":
                        
//                         break;
//                     case "0":
//                         utilizador = "";
//                         setScreen(this.getLogin());
//                         break;
//                 }
//                 break;