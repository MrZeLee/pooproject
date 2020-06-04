package MVC.Model;

import java.util.TreeSet;

import Base.Encomenda.Encomenda;
import MVC.Observer.Observable;
import Users.Loja;
import Users.Transportadora;
import Users.Utilizador;
import Users.Voluntario;

public class Model{
    private TreeSet<Loja> lojas = new TreeSet<Loja>();
    private TreeSet<Transportadora> transportadoras = new TreeSet<Transportadora>();
    private TreeSet<Utilizador> utilizadores = new TreeSet<Utilizador>();
    private TreeSet<Voluntario> voluntarios = new TreeSet<Voluntario>();
    private TreeSet<Encomenda> encomendas = new TreeSet<Encomenda>();

    public void addLoja(Loja l) {
        this.lojas.add(l.clone());
    }

    public void addTransportadora(Transportadora l) {
        this.transportadoras.add(l.clone());
    }

    public void addUtilizador(Utilizador l) {
        this.utilizadores.add(l.clone());
    }

    public void addVoluntario(Voluntario l) {
        this.voluntarios.add(l.clone());
    }

    public void addEncomendas(Encomenda e) {
        this.encomendas.add(e.clone());
    }
}