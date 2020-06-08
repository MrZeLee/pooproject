package MVC.Model;

import java.util.TreeMap;
import java.util.TreeSet;

import Base.Encomenda.Aceite;
import Base.Encomenda.Encomenda;
import Users.Loja;
import Users.Transportadora;
import Users.Utilizador;
import Users.Voluntario;

public class Model{
    private TreeSet<Loja> lojas = new TreeSet<Loja>();
    private TreeSet<Transportadora> transportadoras = new TreeSet<Transportadora>();
    private TreeMap<String,Utilizador> utilizadores = new TreeMap<String,Utilizador>();
    private TreeSet<Voluntario> voluntarios = new TreeSet<Voluntario>();
    private TreeMap<String,Encomenda> encomendas = new TreeMap<String,Encomenda>();
    private TreeSet<Aceite> aceite = new TreeSet<Aceite>();

    public void addLoja(Loja l) {
        this.lojas.add(l.clone());
    }

    public void addTransportadora(Transportadora l) {
        this.transportadoras.add(l.clone());
    }

    public void addUtilizador(Utilizador l) {
        this.utilizadores.put(l.getEmail(), l.clone());
    }

    public void addVoluntario(Voluntario l) {
        this.voluntarios.add(l.clone());
    }

    public void addEncomendas(Encomenda e) {
        this.encomendas.put(e.getCodEncomenda(), e.clone());
    }

    public void addAceite(Aceite e) {
        this.aceite.add(e.clone());
    }

    //UTILIZADOR

    public boolean contains(String email) {
        return this.utilizadores.containsKey(email);
    }

    public boolean password(String utilizador, String password) {
        return this.utilizadores.get(utilizador).getPassword().equals(password);
    }
}