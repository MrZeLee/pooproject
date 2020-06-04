package Parser;

import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import Base.*;
import Base.Basic.Coordenadas;
import Base.Encomenda.Aceite;
//import Basic.*;
import Base.Encomenda.Encomenda;
import Base.Encomenda.LinhaEncomenda;
import Users.*;


public class Logparser {
    
    public void parse(){
        List<String> linhas = lerFicheiro("LogsGerados.csv"); //alterar nome do ficheiro
        String[] linhaPartida;
        for (String linha : linhas) {
                linhaPartida = linha.split(":", 2);
                switch(linhaPartida[0]){
                    case "Utilizador": 
                        Utilizador u = parseUtilizador(linhaPartida[1]); // criar um Utilizador
                        System.out.println(u.toString()); //enviar para o ecra apenas para teste
                        break;
                    case "Loja": 
                        Loja l = parseLoja(linhaPartida[1]);
                        System.out.println(l.toString());
                        break;
                    case "Voluntario":
                        Voluntario v = parseVoluntario(linhaPartida[1]);
                        System.out.println(v.toString());
                        break;
                    case "Transportadora":
                        Transportadora t = parseTransportadora(linhaPartida[1]);
                        System.out.println(t.toString());
                        break;
                    case "Encomenda":
                        Encomenda e = parseEncomenda(linhaPartida[1]);
                        System.out.println(e.toString());
                        break;
                    case "Aceite":
                        Aceite a = parseAceite(linhaPartida[1]);
                        System.out.println(a.toString());
                        break;                            
                    default: 
                        System.out.println("Linha invalida.");
                        break;
                }
        }
        System.out.println("done!");
    }
                                

    public Utilizador parseUtilizador(String input){
        Utilizador u = new Utilizador();
        Coordenadas xy = new Coordenadas();
        String[] campos = input.split(",");
        String nome = campos[0]; 
        String codUtilizador = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        xy.setLatitude(gpsx);
        xy.setLongitude(gpsy);
        u.setNome(nome);
        u.setCodUtilizador(codUtilizador);
        u.setGps(xy);
        return u;
    }

    public Loja parseLoja(String input){
        Loja l = new Loja();
        Coordenadas xy = new Coordenadas();
        String[] campos = input.split(",");
        String codLoja = campos[0]; 
        String nomeLoja = campos[1];
        xy.setLatitude(Double.parseDouble(campos[2]));
        xy.setLongitude(Double.parseDouble(campos[3]));
        l.setCodLoja(codLoja);
        l.setNomeLoja(nomeLoja);
        l.setGps(xy);
        return l;
    }

    public Voluntario parseVoluntario(String input){
        Voluntario v = new Voluntario();
        Coordenadas xy = new Coordenadas();
        String[] campos = input.split(",");
        v.setCodVoluntario(campos[0]);
        v.setNome(campos[1]);
        xy.setLatitude(Double.parseDouble(campos[2]));
        xy.setLongitude(Double.parseDouble(campos[3]));
        v.setRaio(Double.parseDouble(campos[4]));
        v.setRating(0);
        v.setLivre(false);
        v.setGps(xy);
        return v;
    }

    public Encomenda parseEncomenda(String input){
        Encomenda e = new Encomenda();
        String[] campos = input.split(",");
        int conta = 0;
        e.setCodEncomenda(campos[conta++]);
        e.setCodUtilizador(campos[conta++]);
        e.setCodLoja(campos[conta++]);
        e.setPeso(Double.parseDouble(campos[conta++]));
        while(conta<campos.length){
            LinhaEncomenda l = new LinhaEncomenda();
            l.setCodProduto(campos[conta++]);
            l.setDescricao(campos[conta++]);
            l.setQuantidade(Double.parseDouble(campos[conta++]));
            l.setValorUnitario(Double.parseDouble(campos[conta++]));
            e.adicionaLinha(l);
        }
        return e;
    }

    public Transportadora parseTransportadora(String input){
        Transportadora t = new Transportadora();
        Coordenadas xy = new Coordenadas();
        String[] campos = input.split(",");
        t.setCodEmpresa(campos[1]);
        t.setNomeEmpresa(campos[2]);
        xy.setLatitude(Double.parseDouble(campos[3]));
        xy.setLongitude(Double.parseDouble(campos[4]));
        t.setGps(xy);
        t.setNif(Integer.parseInt(campos[5]));
        t.setRaio(Double.parseDouble(campos[6]));
        t.setPriceKm(Double.parseDouble(campos[7]));
        return t;
    }

    public Aceite parseAceite(String input){
        Aceite a = new Aceite();
        String[] campos = input.split(",");
        a.setCodEncomenda(campos[0]);
        return a;
    }


    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println(exc.getMessage()); }
        return lines;
    }

}