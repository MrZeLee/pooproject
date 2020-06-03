package MVC;

import java.util.TreeSet;

import Users.Loja;
import Users.Transportadora;
import Users.Utilizador;
import Users.Voluntario;

public class Model {
    private static TreeSet<Loja> lojas = new TreeSet<Loja>();
    private static TreeSet<Transportadora> transportadoras = new TreeSet<Transportadora>();
    private static TreeSet<Utilizador> utilizadores = new TreeSet<Utilizador>();
    private static TreeSet<Voluntario> voluntarios = new TreeSet<Voluntario>();

    public static void addLoja(Loja l) {
        Model.lojas.add(l.clone());
    }

    public static void addTransportadora(Transportadora l) {
        Model.transportadoras.add(l.clone());
    }

    public static void addUtilizador(Utilizador l) {
        Model.utilizadores.add(l.clone());
    }

    public static void addVoluntario(Voluntario l) {
        Model.voluntarios.add(l.clone());
    }

}