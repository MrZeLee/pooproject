package MVC;

import java.util.TreeSet;

import Base.Encomenda.Encomenda;
import Users.Loja;
import Users.Transportadora;
import Users.Utilizador;
import Users.Voluntario;

public class Info {
    private static TreeSet<Loja> lojas = new TreeSet<Loja>();
    private static TreeSet<Transportadora> transportadoras = new TreeSet<Transportadora>();
    private static TreeSet<Utilizador> utilizadores = new TreeSet<Utilizador>();
    private static TreeSet<Voluntario> voluntarios = new TreeSet<Voluntario>();
    private static TreeSet<Encomenda> encomendas = new TreeSet<Encomenda>();

    public static void addLoja(Loja l) {
        Info.lojas.add(l.clone());
    }

    public static void addTransportadora(Transportadora l) {
        Info.transportadoras.add(l.clone());
    }

    public static void addUtilizador(Utilizador l) {
        Info.utilizadores.add(l.clone());
    }

    public static void addVoluntario(Voluntario l) {
        Info.voluntarios.add(l.clone());
    }

    public static void addEncomendas(Encomenda e) {
        Info.encomendas.add(e.clone());
    }
}