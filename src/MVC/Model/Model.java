package MVC.Model;

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
    private TreeSet<Transportadora> transportadoras = new TreeSet<Transportadora>();
    private TreeMap<String,Utilizador> utilizadores = new TreeMap<String,Utilizador>();
    private TreeSet<Voluntario> voluntarios = new TreeSet<Voluntario>();
    private TreeMap<String,Encomenda> encomendas = new TreeMap<String,Encomenda>();

    private TreeSet<Aceite> loja = new TreeSet<Aceite>();// adicionadas no inicio para aprovacao da loja
    private TreeSet<Aceite> sinalizadas = new TreeSet<Aceite>();// transferidas da loja para aqui quando a loja as aprova, aguardam aprovacao do utilizador
    private TreeMap<String,Aceite> aceite = new TreeMap<String,Aceite>();// transferidas das sinalizads para aceite quando o user aprova, estas sao vistas pelos voluntarios e transportadoras

    public void addLoja(Loja l) {
        this.lojas.put(l.getCodLoja(), l.clone());
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
        this.loja.add(new Aceite(e));
    }

    public void addSinalizadas(Aceite e) {
        this.loja.remove(e);
        this.sinalizadas.add(e.clone());
    }

    public void addAceite(String transportadora, Aceite e) {
        this.sinalizadas.remove(e);
        this.aceite.put(transportadora, e.clone());
    }

    public void addAceiteLog(Aceite e) {
        this.sinalizadas.remove(e);
        this.aceite.put(e.getCodEncomenda(),e.clone());
    }

    //UTILIZADOR

    public boolean contains(String email) {
        return this.utilizadores.containsKey(email);
    }

    public boolean password(String utilizador, String password) {
        return this.utilizadores.get(utilizador).getPassword().equals(password);
    }

    public List<String> getEncomendas(String codUtilizador) {
        List<String> ret = new ArrayList<>();
        for (Aceite aceite : this.sinalizadas) {
            Encomenda x = this.encomendas.get(aceite.getCodEncomenda());
            if(x.getCodUtilizador().equals(codUtilizador)) ret.add(x.toString());
        }
        return ret;
    }

    public Pair<List<String>,List<String>> getTransportadoras(String codEncomenda) {
        Pair<List<String>,List<String>> ret = new Pair<>();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        Encomenda e = this.encomendas.get(codEncomenda);
        Loja l = this.lojas.get(e.getCodLoja());
        Utilizador u = this.utilizadores.get(e.getCodUtilizador());
        for ( Transportadora t : this.transportadoras) {
            if(t.isOn() && t.isNextTo(l,u)) {
                first.add(t.getCodEmpresa());
                second.add(String.format("%s - %s€", t.getNomeEmpresa(), t.custo(l, u, e)));
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
        for ( Voluntario t : this.voluntarios) {
            if(t.isLivre() && t.isNextTo(l,u)) {
                first.add(t.getCodVoluntario());
                second.add(t.getNome());
            }
        }
        ret.setFirst(first);
        ret.setSecond(second);
        return ret;
    }


}