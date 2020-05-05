import java.util.Objects;

public class Transportadora {
    private String codEmpresa;
    private String nomeEmpresa;
    private Coordenadas gps;
    private int nif;
    private int raio;
    private double ppk;

    public Transportadora() {
    }

    public Transportadora(String codEmpresa, String nomeEmpresa, Coordenadas gps, int nif, int raio, double ppk) {
        this.codEmpresa = codEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.gps = gps.clone();
        this.nif = nif;
        this.raio = raio;
        this.ppk = ppk;
    }

    public Transportadora(Transportadora x) {
        this.codEmpresa = x.getCodEmpresa();
        this.nomeEmpresa = x.getNomeEmpresa();
        this.gps = x.getGps();
        this.nif = x.getNif();
        this.raio = x.getRaio();
        this.ppk = x.getPpk();
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

    public int getRaio() {
        return this.raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public double getPpk() {
        return this.ppk;
    }

    public void setPpk(double ppk) {
        this.ppk = ppk;
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

    public Transportadora raio(int raio) {
        this.raio = raio;
        return this.clone();
    }

    public Transportadora ppk(double ppk) {
        this.ppk = ppk;
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
        return Objects.equals(codEmpresa, transportadora.codEmpresa) && Objects.equals(nomeEmpresa, transportadora.nomeEmpresa) && Objects.equals(gps, transportadora.gps) && nif == transportadora.nif && raio == transportadora.raio && ppk == transportadora.ppk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEmpresa, nomeEmpresa, gps, nif, raio, ppk);
    }

    @Override
    public String toString() {
        return "{" +
            " codEmpresa='" + getCodEmpresa() + "'" +
            ", nomeEmpresa='" + getNomeEmpresa() + "'" +
            ", gps='" + getGps() + "'" +
            ", nif='" + getNif() + "'" +
            ", raio='" + getRaio() + "'" +
            ", ppk='" + getPpk() + "'" +
            "}";
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }
}