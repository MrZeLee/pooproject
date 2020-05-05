import java.util.ArrayList;

public class Aceite {
    ArrayList<String> codEncomenda;

    public Aceite() {
    }

    public Aceite(ArrayList<String> codEncomenda) {
        this.setCodEncomenda(codEncomenda);
    }

    public Aceite(Aceite x) {
        this.codEncomenda = x.getCodEncomenda();
    }

    public ArrayList<String> getCodEncomenda() {
        ArrayList<String> ret = new ArrayList<>();
        for (String string : this.codEncomenda) {
            ret.add(string);
        }
        return ret;
    }

    public void setCodEncomenda(ArrayList<String> codEncomenda) {
        ArrayList<String> ret = new ArrayList<>();
        for (String string : codEncomenda) {
            ret.add(string);
        }
        this.codEncomenda = ret;
    }

    public Aceite codEncomenda(ArrayList<String> codEncomenda) {
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