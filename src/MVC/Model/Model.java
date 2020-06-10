package MVC.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import Base.Basic.Pair;
import Base.Encomenda.Aceite;
import Base.Encomenda.Encomenda;
import Users.Loja;
import Users.Transportadora;
import Users.Utilizador;
import Users.Voluntario;

public class Model{
    private TreeMap<String,Loja> lojas = new TreeMap<String,Loja>();
    private TreeMap<String,Transportadora> transportadoras = new TreeMap<String,Transportadora>();
    private TreeMap<String,Utilizador> utilizadores = new TreeMap<String,Utilizador>();
    private TreeMap<String,Voluntario> voluntarios = new TreeMap<String,Voluntario>();
    private TreeMap<String,Encomenda> encomendas = new TreeMap<String,Encomenda>();

    private TreeSet<Aceite> loja = new TreeSet<Aceite>();// adicionadas no inicio para aprovacao da loja
    private TreeSet<Aceite> sinalizadas = new TreeSet<Aceite>();// transferidas da loja para aqui quando a loja as aprova, aguardam aprovacao do utilizador
    private TreeSet<Aceite> aceite = new TreeSet<Aceite>();// transferidas das sinalizads para aceite quando o user aprova, estas sao vistas pelos voluntarios e transportadoras
    private TreeSet<Aceite> entregues = new TreeSet<Aceite>(); //entregues pelas transportadoras e viluntarios, o utilizador já pode dar rating

    public void addLoja(Loja l) {
        this.lojas.put(l.getCodLoja(), l.clone());
    }

    public Loja getLoja(String x) {
        return this.lojas.get(x).clone();
    }

    public void addTransportadora(Transportadora l) {
        this.transportadoras.put(l.getCodEmpresa(), l.clone());
    }

    public void addUtilizador(Utilizador l) {
        this.utilizadores.put(l.getEmail(), l.clone());
    }

    public void addVoluntario(Voluntario l) {
        this.voluntarios.put(l.getCodVoluntario(),l.clone());
    }

    public void addEncomendas(Encomenda e) {
        this.encomendas.put(e.getCodEncomenda(), e.clone());
        this.loja.add(new Aceite(e));
    }

    public void addSinalizadas(String e) {
        addSinalizadas(new Aceite(e));
    }

    public void addSinalizadas(Aceite e) {
        this.loja.remove(e);
        this.sinalizadas.add(e.clone());
    }

    public void addAceite(String transportadora, Aceite e) {
        this.sinalizadas.remove(e);
        this.encomendas.get(e.getCodEncomenda()).setCodTransportador(transportadora);
        this.aceite.add(e.clone());
    }

    public void addEntregues(Aceite e) {
        this.aceite.remove(e);
        this.entregues.add(e.clone());
    }

    public void addAceiteLog(Aceite e) {
        this.loja.remove(e);
        this.sinalizadas.add(e.clone());
    }

    //ENCOMENDA

    // SO PARA ENCOMENDAS POR TRANSPORTADORA
    

    //UTILIZADOR

    public boolean contains(String email) {
        return this.utilizadores.containsKey(email);
    }

    public boolean password(String utilizador, String password) {
        return this.utilizadores.get(utilizador).getPassword().equals(password);
    }

    public Pair<List<String>,List<String>> getEncomendas(String codUtilizador) {
        Pair<List<String>,List<String>> ret = new Pair<>();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        for (Aceite aceite : this.sinalizadas) {
            Encomenda x = this.encomendas.get(aceite.getCodEncomenda());
            if(x.getCodUtilizador().equals(codUtilizador)) {
                first.add(x.getCodEncomenda());
                second.add(x.toString());
            }
        }
        ret.setFirst(first);
        ret.setSecond(second);
        return ret;
    }

    public Pair<List<String>,List<String>> getTransportadoras(String codEncomenda) {
        Pair<List<String>,List<String>> ret = new Pair<>();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        Encomenda e = this.encomendas.get(codEncomenda);
        Loja l = this.lojas.get(e.getCodLoja());
        Utilizador u = this.utilizadores.get(e.getCodUtilizador());
        for ( Transportadora t : this.transportadoras.values()) {
            if(t.isOn() && t.isNextTo(l,u)) {
                first.add(t.getCodEmpresa());
                second.add(String.format("%s - %s€", t.getNomeEmpresa(), t.custo(l, u, e) + l.tempo() * 0.5));
            }
        }
        ret.setFirst(first);
        ret.setSecond(second);
        return ret;
    }

    public Pair<List<String>,List<String>> getVoluntarios(String codEncomenda) {
        Pair<List<String>,List<String>> ret = new Pair<>();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        Encomenda e = this.encomendas.get(codEncomenda);
        Loja l = this.lojas.get(e.getCodLoja());
        Utilizador u = this.utilizadores.get(e.getCodUtilizador());
        for ( Voluntario t : this.voluntarios.values()) {
            if(t.isLivre() && t.isNextTo(l,u)) {
                first.add(t.getCodVoluntario());
                second.add(t.getNome());
            }
        }
        ret.setFirst(first);
        ret.setSecond(second);
        return ret;
    }

    public List<String> getPeriodo(String u, LocalDateTime a, LocalDateTime b) {
        List<String> ret = new ArrayList<>();
        Utilizador us = this.utilizadores.get(u);
        for (Aceite aceite : us.getEncomendasFeitas()) {
            Encomenda es = this.encomendas.get(aceite.getCodEncomenda());
            LocalDateTime ldt = es.getCriation();
            if(ldt.isAfter(a) && ldt.isBefore(b)) {
                ret.add(es.toString(this));
            }
        }
        return ret;
    }

    public List<String> getPeriodoVoluntario(String u, LocalDateTime a, LocalDateTime b) {
        List<String> ret = new ArrayList<>();
        Utilizador us = this.utilizadores.get(u);
        for (Aceite aceite : us.getEncomendasFeitas()) {
            Encomenda es = this.encomendas.get(aceite.getCodEncomenda());
            LocalDateTime ldt = es.getCriation();
            if(ldt.isAfter(a) && ldt.isBefore(b) && this.voluntarios.containsKey(es.getCodTransportador())) {
                ret.add(es.toString(this));
            }
        }
        return ret;
    }

    public List<String> getPeriodoTransportadora(String u, LocalDateTime a, LocalDateTime b) {
        List<String> ret = new ArrayList<>();
        Utilizador us = this.utilizadores.get(u);
        for (Aceite aceite : us.getEncomendasFeitas()) {
            Encomenda es = this.encomendas.get(aceite.getCodEncomenda());
            LocalDateTime ldt = es.getCriation();
            if(ldt.isAfter(a) && ldt.isBefore(b) && this.transportadoras.containsKey(es.getCodTransportador())) {
                ret.add(es.toString(this));
            }
        }
        return ret;
    }

    public Pair<List<String>,List<String>> getRatings(String u) {
        Pair<List<String>,List<String>> ret = new Pair<>();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        for (Aceite aceite : this.entregues) {
            Encomenda x = this.encomendas.get(aceite.getCodEncomenda());
            if(x.getCodUtilizador().equals(u) && x.getRating() == -1.0) {
                first.add(x.getCodEncomenda());
                second.add(x.toString(this));
            }
        }

        ret.setFirst(first);
        ret.setSecond(second);
        return ret;
    }

    public void SetRating(String e, Double rating) {
        this.encomendas.get(e).setRating(rating);
    }


    // LOJA

    public List<String> getEncomendasLoja(String codLoja) {
        List<String> ret = new ArrayList<>();
        for (Aceite aceite : this.loja) {
            if(this.encomendas.get(aceite.getCodEncomenda()).getCodLoja().equals(codLoja)) {
                ret.add(aceite.getCodEncomenda());
            }
        }
        return ret;
    }

    public int getQueueLoja(String codLoja){
        int ret = 0;
        try {
                Loja newloja = this.lojas.get(codLoja);
                ret = newloja.getQueue();
        }
        catch (Exception e) {
            System.out.println("Loja Does Not Exist");
        }
        return ret;
    }
    
    //TRANSPORTADORA

    public boolean containsTransportadora(String codTransportadora) {
        return this.transportadoras.containsKey(codTransportadora);
    }

    public int transportadoraOn(String codTransportadora) {
        return (this.transportadoras.get(codTransportadora).getOn() ? 1 : 0);
    }

    public int toogleTransportadora(String codTransportadora) {
        return (this.transportadoras.get(codTransportadora).toogleOn() ? 1 : 0);
    }

    public boolean passwordTransportadora(String transportadora, String password) {
        return this.transportadoras.get(transportadora).getPassword().equals(password);
    }

    public double preco(String encomenda) {
        Encomenda e = this.encomendas.get(encomenda);
        Utilizador u = this.utilizadores.get(e.getCodUtilizador());
        Transportadora t = this.transportadoras.get(e.getCodTransportador());
        Loja l = this.lojas.get(e.getCodLoja());
        return t.custo(l, u, e) + l.tempo() * 0.5;
    }

    public Pair<List<String>,List<String>> getEncomendasTransportadora(String codTransportadora) {
        Pair<List<String>,List<String>> ret = new Pair<>();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        for (Aceite aceite : this.aceite) {
            Encomenda x = this.encomendas.get(aceite.getCodEncomenda());
            if(x.getCodTransportador().equals(codTransportadora)) {
                first.add(x.getCodEncomenda());
                second.add(x.toString());
            }
        }
        ret.setFirst(first);
        ret.setSecond(second);
        return ret;
    }

}