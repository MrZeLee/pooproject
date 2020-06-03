package Base.Basic;

import java.util.TreeSet;

public class Aceite {
    TreeSet<String> codEncomenda;

    public Aceite() {
    }

    public Aceite(TreeSet<String> codEncomenda) {
        this.setCodEncomenda(codEncomenda);
    }

    public Aceite(Aceite x) {
        this.codEncomenda = x.getCodEncomenda();
    }

    public TreeSet<String> getCodEncomenda() {
        TreeSet<String> ret = new TreeSet<>();
        for (String string : this.codEncomenda) {
            ret.add(string);
        }
        return ret;
    }

    public void setCodEncomenda(TreeSet<String> codEncomenda) {
        TreeSet<String> ret = new TreeSet<>();
        for (String string : codEncomenda) {
            ret.add(string);
        }
        this.codEncomenda = ret;
    }

    public Aceite codEncomenda(TreeSet<String> codEncomenda) {
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
            " codEncomenda='" + getCodEncomenda().toString() + "'" +
            "}";
    }
}