package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Base.Basic.Coordenadas;

public class Voluntario {
    private String codVoluntario;
    private String nome;
    private Coordenadas gps;
    private double raio;

    private boolean livre;
    private List<Double> rating;

    /**
     * Construtor parametrizado
     * @param nome
     * @param codVoluntario
     * @param gps
     * @param raio
     */
    public Voluntario(String nome, String codVoluntario, Coordenadas gps, double raio) {
        this.nome = nome;
        this.codVoluntario = codVoluntario;
        this.gps = gps.clone();
        this.raio = raio;
        this.livre = false;
        this.rating = new ArrayList<Double>();
    }

    /**
     * Contrutor vazio
     */
    public Voluntario(){
        this.nome = new String();
        this.codVoluntario = new String();
        this.gps = new Coordenadas();
        this.raio = 0;
        this.livre = false;
        this.rating = new ArrayList<Double>();
    }

    /**
     * Contrutor por cópia
     * @param v
     */
    public Voluntario(Voluntario v){
        this.nome = v.getNome();
        this.codVoluntario = v.getCodVoluntario();
        this.gps = v.getGps();
        this.raio = v.getRaio();
        this.livre = v.getLivre();
        this.rating = v.getRating();
    }

    /**
     * Getters e Setters
     */

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodVoluntario() {
        return this.codVoluntario;
    }

    public void setCodVoluntario(String codVoluntario) {
        this.codVoluntario = codVoluntario;
    }

    public Coordenadas getGps() {
        return this.gps.clone();
    }

    public void setGps(Coordenadas gps) {
        this.gps = gps.clone();
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public boolean isLivre() {
        return this.livre;
    }

    public boolean getLivre() {
        return this.livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public List<Double> getRating() {
        List<Double> ret = new ArrayList<Double>();
        for (Double d : this.rating) {
            ret.add(d);
        }
        return ret;
    }

    public Double getRatingTotal() {
        Double ret = 0.0;
        for (Double d : this.rating) {
            ret += d;
        }
        return (ret/(this.rating.size()));
    }

    public void addRating(double rating) {
        this.rating.add(rating);
    }

    public void setRating(List<Double> rating) {
        this.rating = rating;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Voluntario)) {
            return false;
        }
        Voluntario voluntario = (Voluntario) o;
        return Objects.equals(codVoluntario, voluntario.codVoluntario) && Objects.equals(nome, voluntario.nome) && Objects.equals(gps, voluntario.gps) && raio == voluntario.raio && livre == voluntario.livre && rating == voluntario.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codVoluntario, nome, gps, raio, livre, rating);
    }


    @Override
    public String toString() {
        return "{" +
            " codVoluntario='" + getCodVoluntario() + "'" +
            ", nome='" + getNome() + "'" +
            ", gps='" + getGps() + "'" +
            ", raio='" + getRaio() + "'" +
            ", livre='" + isLivre() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

    @Override
    public Voluntario clone() {
        return new Voluntario(this);
    }

    public boolean isNextTo(Loja l, Utilizador u) {
        return this.gps.isNextTo(l.getGps(), this.raio) && this.gps.isNextTo(u.getGps(), this.raio);
    }

}