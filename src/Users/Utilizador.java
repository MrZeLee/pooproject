package Users;

import java.util.Objects;

import Base.Basic.Coordenadas;

public class Utilizador {
    private String codUtilizador;
    private String nome;
    private String email;
    private String password;
    private Coordenadas gps;

    public Utilizador() {
    }

    public Utilizador(String codUtilizador, String nome, String email, String password, Coordenadas gps) {
        this.codUtilizador = codUtilizador;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.gps = gps.clone();
    }

    public Utilizador(Utilizador x) {
        this(x.codUtilizador,x.nome,x.email,x.password,x.gps);
    }

    public String getCodUtilizador() {
        return this.codUtilizador;
    }

    public void setCodUtilizador(String codUtilizador) {
        this.codUtilizador = codUtilizador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Coordenadas getGps() {
        return this.gps;
    }

    public void setGps(Coordenadas gps) {
        this.gps = gps;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Utilizador)) {
            return false;
        }
        Utilizador utilizador = (Utilizador) o;
        return Objects.equals(codUtilizador, utilizador.codUtilizador) && Objects.equals(nome, utilizador.nome) && Objects.equals(email, utilizador.email) && Objects.equals(password, utilizador.password) && Objects.equals(gps, utilizador.gps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUtilizador, nome, email, password, gps);
    }

    @Override
    public String toString() {
        return "{" +
            " codUtilizador='" + getCodUtilizador() + "'" +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", gps='" + getGps() + "'" +
            "}";
    }



    public Utilizador clone() {
        return new Utilizador(this);
    }


}