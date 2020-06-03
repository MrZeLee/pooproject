package Users;

import Base.Basic.Coordenadas;

public class Utilizador {
    private String codUtilizador;
    private String email;
    private String password;
    private Coordenadas gps;


    /**
     * Construtor parametrizado
     * @param codUtilizador
     * @param gps
     */
    public Utilizador(String codUtilizador, Coordenadas gps) {
        this.codUtilizador = codUtilizador;
        this.gps = gps.clone();
    }

    /**
     * Contrutor vazio
     */
    public Utilizador(){
        this.codUtilizador = new String();
        this.gps = new Coordenadas();
    }

    /**
     * Contrutor por cópia
     * @param v
     */
    public Utilizador(Utilizador u){
        this.codUtilizador = u.getCodUtilizador();
        this.gps = u.getGps();
    }


    /**
     * Getters e Setters
     */
    public String getCodUtilizador() {
        return this.codUtilizador;
    }

    public void setCodUtilizador(String codUtilizador) {
        this.codUtilizador = codUtilizador;
    }

    public Coordenadas getGps() {
        return this.gps.clone();
    }

    public void setGps(Coordenadas gps) {
        this.gps = gps.clone();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Equals
     * @param object
     * @return
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Utilizador)) return false;
        if (!super.equals(object)) return false;
        Utilizador that = (Utilizador) object;
        return getCodUtilizador().equals(that.getCodUtilizador()) &&
                getGps().equals(that.getGps());
    }

    /**
     * hashCode
     * @return
     */
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getCodUtilizador(), getGps());
    }

    /**
     * toString
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "Utilizador{" +
                "codUtilizador='" + codUtilizador + '\'' +
                ", gps=" + gps +
                '}';
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }


}