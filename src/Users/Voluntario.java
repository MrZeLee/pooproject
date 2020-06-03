package Users;
import Base.Basic.Coordenadas;

public class Voluntario {
    private String nome;
    private String codVoluntario;
    private Coordenadas gps;
    private double raio;
    private boolean livre;
    private double rating;

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
    }

    /**
     * Contrutor vazio
     */
    public Voluntario(){
        this.nome = new String();
        this.codVoluntario = new String();
        this.gps = new Coordenadas();
        this.raio = 0;
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

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Equals
     * @param object
     * @return
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Voluntario)) return false;
        if (!super.equals(object)) return false;
        Voluntario that = (Voluntario) object;
        return getRaio() == that.getRaio() &&
                getNome().equals(that.getNome()) &&
                getCodVoluntario().equals(that.getCodVoluntario()) &&
                getGps().equals(that.getGps());
    }

    /**
     * hashCode
     * @return
     */
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getNome(), getCodVoluntario(), getGps(), getRaio());
    }

    /**
     * toString
     * @return
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "Voluntario{" +
                "nome='" + nome + '\'' +
                ", codVoluntario='" + codVoluntario + '\'' +
                ", gps=" + gps +
                ", raio=" + raio +
                '}';
    }

    @Override
    public Voluntario clone() {
        return new Voluntario(this);
    }

}