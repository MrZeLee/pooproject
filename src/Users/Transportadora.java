package Users;

import java.util.Objects;

import Base.Basic.Coordenadas;

public class Transportadora {
    private boolean on;
    private String codEmpresa;
    private String nomeEmpresa;
    private Coordenadas gps;
    private int nif;
    private double raio;
    private double priceKm;

    public Transportadora() {
    }

    public Transportadora(boolean on, String codEmpresa, String nomeEmpresa, Coordenadas gps, int nif, double raio, double priceKm) {
        this.on = on;
        this.codEmpresa = codEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.gps = gps.clone();
        this.nif = nif;
        this.raio = raio;
        this.priceKm = priceKm;
    }


    public Transportadora(Transportadora x) {
        this.codEmpresa = x.getCodEmpresa();
        this.nomeEmpresa = x.getNomeEmpresa();
        this.gps = x.getGps();
        this.nif = x.getNif();
        this.raio = x.getRaio();
        this.priceKm = x.getpriceKm();
        this.on = x.getOn();
    }

    
    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return this.on;
    }

    public boolean getOn() {
        return this.on;
    }

    public String getCodEmpresa() {
        return this.codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Coordenadas getGps() {
        return this.gps.clone();
    }

    public void setGps(Coordenadas gps) {
        this.gps = gps.clone();
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getpriceKm() {
        return this.priceKm;
    }

    public void setpriceKm(double priceKm) {
        this.priceKm = priceKm;
    }

    public Transportadora codEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
        return this.clone();
    }

    public Transportadora nomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        return this.clone();
    }

    public Transportadora gps(Coordenadas gps) {
        this.gps = gps.clone();
        return this.clone();
    }

    public Transportadora nif(int nif) {
        this.nif = nif;
        return this.clone();
    }

    public Transportadora raio(double raio) {
        this.raio = raio;
        return this.clone();
    }

    public Transportadora priceKm(double priceKm) {
        this.priceKm = priceKm;
        return this.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transportadora)) {
            return false;
        }
        Transportadora transportadora = (Transportadora) o;
        return Objects.equals(codEmpresa, transportadora.codEmpresa) && Objects.equals(nomeEmpresa, transportadora.nomeEmpresa) && Objects.equals(gps, transportadora.gps) && nif == transportadora.nif && raio == transportadora.raio && priceKm == transportadora.priceKm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEmpresa, nomeEmpresa, gps, nif, raio, priceKm);
    }

    @Override
    public String toString() {
        return "{" +
            " codEmpresa='" + getCodEmpresa() + "'" +
            ", nomeEmpresa='" + getNomeEmpresa() + "'" +
            ", gps='" + getGps() + "'" +
            ", nif='" + getNif() + "'" +
            ", raio='" + getRaio() + "'" +
            ", priceKm='" + getpriceKm() + "'" +
            "}";
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }
}