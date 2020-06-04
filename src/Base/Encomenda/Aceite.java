package Base.Encomenda;


public class Aceite {
    String codEncomenda;

    public Aceite() {
    }

    public Aceite(String codEncomenda) {
        this.setCodEncomenda(codEncomenda);
    }

    public Aceite(Aceite x) {
        this.codEncomenda = x.getCodEncomenda();
    }

    public String getCodEncomenda() {
        return this.codEncomenda;
    }

    public void setCodEncomenda(String codEncomenda) {
        this.codEncomenda = codEncomenda;
    }

    public Aceite codEncomenda(String codEncomenda) {
        this.codEncomenda = codEncomenda;
        return this;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof Aceite)) {
    //         return false;
    //     }
    //     Aceite aceite = (Aceite) o;
    //     return Objects.equals(codEncomenda, aceite.codEncomenda);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hashCode(codEncomenda);
    // }

    @Override
    public String toString() {
        return "{" +
            " codEncomenda='" + getCodEncomenda() + "'" +
            "}";
    }
}