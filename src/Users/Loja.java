package Users;

import java.util.Objects;

import Base.Basic.Coordenadas;

public class Loja {
    private String codLoja;
    private String nomeLoja;
    private Coordenadas gps;
    private int queue;


    public Loja() {
    }

    public Loja(String codLoja, String nomeLoja, Coordenadas gps) {
        this.codLoja = codLoja;
        this.nomeLoja = nomeLoja;
        this.gps = gps.clone();
    }

    public Loja(Loja x){
        this.codLoja = x.getCodLoja();
        this.nomeLoja = x.getNomeLoja();
        this.gps = x.getGps();

    }

    public String getCodLoja() {
        return this.codLoja;
    }

    public void setCodLoja(String codLoja) {
        this.codLoja = codLoja;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public Coordenadas getGps() {
        return this.gps.clone();
    }

    public void setGps(Coordenadas gps) {
        Coordenadas coords = new Coordenadas();
        coords = gps.clone();
        this.gps = coords;
    }

    public Loja codLoja(String codLoja) {
        this.codLoja = codLoja;
        return this;
    }

    public int getQueue() {
        return this.queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Loja)) {
            return false;
        }
        Loja loja = (Loja) o;
        return Objects.equals(codLoja, loja.codLoja) && Objects.equals(nomeLoja, loja.nomeLoja) && Objects.equals(gps, loja.gps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codLoja, nomeLoja, gps);
    }

    @Override
    public String toString() {
        return "{" +
            " codLoja='" + getCodLoja() + "'" +
            ", nomeLoja='" + getNomeLoja() + "'" +
            ", gps='" + getGps() + "'" +
            "}";
    }

    public Loja clone(){
        return new Loja(this);
    }


}