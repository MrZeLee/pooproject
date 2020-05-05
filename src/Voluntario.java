public class Voluntario {
private String nome;
private String codVoluntario;
private Coordenadas gps;
private int raio;

    /**
     * Construtor parametrizado
     * @param nome
     * @param codVoluntario
     * @param gps
     * @param raio
     */
    public Voluntario(String nome, String codVoluntario, Coordenadas gps, int raio) {
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

    public int getRaio() {
        return this.raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
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
}