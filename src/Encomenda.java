import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Encomenda
 */
public class Encomenda{
    private String nome;
    private int NIF;
    private String morada;
    private int code;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> lista;


    public Encomenda() {
    }

    public Encomenda(Encomenda a) {
        this.nome = a.getNome();
        this.NIF = a.getNIF();
        this.morada = a.getMorada();
        this.code = a.getCode();
        this.data = a.getData();
        this.lista = a.getLista();
    }

    public Encomenda(String nome, int NIF, String morada, int code, LocalDate data, ArrayList<LinhaEncomenda> lista) {
        this.nome = nome;
        this.NIF = NIF;
        this.morada = morada;
        this.code = code;
        this.data = data;
        this.lista = lista;
    }

    public Encomenda clone() 
    {
        return new Encomenda(this);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNIF() {
        return this.NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<LinhaEncomenda> getLista() {
        ArrayList<LinhaEncomenda> ret = new ArrayList<>();

        for(LinhaEncomenda i : this.lista) {
            ret.add(i.clone());
        }

        return ret;
    }

    public void setLista(ArrayList<LinhaEncomenda> lista) {
        this.lista = lista;
    }

    public double calculaValorTotal() {
        double total = 0;
        for(LinhaEncomenda i : this.lista) {
            total += i.calculaValorLinhaEnc();
        }
        return total;
    }

    public double calcularValorDesconto() {
        double total = 0;
        for(LinhaEncomenda i : this.lista) {
            total += i.calculaValorDesconto();
        }
        return total;
    }

    public int numeroTotalProdutos() {
        int total = 0;
        for(LinhaEncomenda i : this.lista) {
            total += i.getQuantidade();
        }
        return total;
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        for(LinhaEncomenda i : this.lista) {
            if(i.getReferencia() == refProduto){
                return true;
            }
        }
        return false;
    }

    public void adicionaLinha(LinhaEncomenda linha) {
        this.lista.add(linha);
    }

    public void removeProduto(String codProd) {
        for(LinhaEncomenda i : this.lista) {
            if (i.getReferencia() == codProd) this.lista.remove(i);
        }
    }
}