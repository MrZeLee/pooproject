package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

import Base.Basic.Coordenadas;
import Base.Basic.Pair;
import Base.Encomenda.Encomenda;

public class Transportadora {
    private String codEmpresa;
    private String nomeEmpresa;
    private Coordenadas gps;
    private int nif;
    private double raio;
    private double priceKm;

    private boolean on;
    private double priceKg;
    private TreeSet<Encomenda> encomendasFeitas;
    private TreeMap<String,Pair<Double,Double>> test; //esqueci me o que estava a fazer vou dar commit

    public Transportadora() {
    }


    public Transportadora(String codEmpresa, String nomeEmpresa, Coordenadas gps, int nif, double raio, double priceKm, boolean on, double priceKg, TreeSet<Encomenda> encomendasFeitas) {
        this.codEmpresa = codEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.gps = gps.clone();
        this.nif = nif;
        this.raio = raio;
        this.priceKm = priceKm;
        this.on = on;
        this.priceKg = priceKg;
        TreeSet<Encomenda> encFeitas = new TreeSet<Encomenda>();
        for (Encomenda encomenda : encomendasFeitas) {
            encFeitas.add(encomenda.clone());
        }
        this.encomendasFeitas = encFeitas;
    }


    public Transportadora(Transportadora x) {
        this(x.codEmpresa, x.nomeEmpresa, x.gps, x.nif, x.raio, x.priceKm, x.on, x.priceKg, x.encomendasFeitas);
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
        return this.gps;
    }

    public void setGps(Coordenadas gps) {
        this.gps = gps;
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

    public double getPriceKm() {
        return this.priceKm;
    }

    public void setPriceKm(double priceKm) {
        this.priceKm = priceKm;
    }

    public boolean isOn() {
        return this.on;
    }

    public boolean getOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getPriceKg() {
        return this.priceKg;
    }

    public void setPriceKg(double priceKg) {
        this.priceKg = priceKg;
    }

    public TreeSet<Encomenda> getEncomendasFeitas() {
        return this.encomendasFeitas;
    }

    public void setEncomendasFeitas(TreeSet<Encomenda> encomendasFeitas) {
        this.encomendasFeitas = encomendasFeitas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transportadora)) {
            return false;
        }
        Transportadora transportadora = (Transportadora) o;
        return Objects.equals(codEmpresa, transportadora.codEmpresa) && Objects.equals(nomeEmpresa, transportadora.nomeEmpresa) && Objects.equals(gps, transportadora.gps) && nif == transportadora.nif && raio == transportadora.raio && priceKm == transportadora.priceKm && on == transportadora.on && priceKg == transportadora.priceKg && Objects.equals(encomendasFeitas, transportadora.encomendasFeitas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEmpresa, nomeEmpresa, gps, nif, raio, priceKm, on, priceKg, encomendasFeitas);
    }

    @Override
    public String toString() {
        return "{" +
            " codEmpresa='" + getCodEmpresa() + "'" +
            ", nomeEmpresa='" + getNomeEmpresa() + "'" +
            ", gps='" + getGps() + "'" +
            ", nif='" + getNif() + "'" +
            ", raio='" + getRaio() + "'" +
            ", priceKm='" + getPriceKm() + "'" +
            ", on='" + isOn() + "'" +
            ", priceKg='" + getPriceKg() + "'" +
            ", encomendasFeitas='" + getEncomendasFeitas() + "'" +
            "}";
    }


    public Transportadora clone(){
        return new Transportadora(this);
    }

    private double custo(double km){
        return km * this.priceKm;
    }

    private double custo(Encomenda e) {
        return this.priceKg * e.getPeso();
    }

    private double custo(Loja l, Utilizador u) {
        List<Coordenadas> list = new ArrayList<>();
        list.add(l.getGps());
        list.add(u.getGps());
        return this.custo(this.gps.distanceSequencial(list));
    }

    public double custo(Loja l, Utilizador u, Encomenda e) {
        return custo(l,u) + custo(e);
    }

    private boolean isNextTo(Loja l) {
        return this.getGps().isNextTo(l.getGps(), this.raio);
    }

    private boolean isNextTo(Utilizador u) {
        return this.getGps().isNextTo(u.getGps(), this.raio);
    }

    public boolean isNextTo(Loja l, Utilizador u) {
        return this.isNextTo(l) && this.isNextTo(u);
    }

}