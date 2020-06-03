package Parser;

import java.util.List;

import Base.*;
import Basic.*;
import Base.Encomenda.Encomenda;
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
        String[] campos = input.split(",");
        String nome = campos[0]; 
        String codUtilizador = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        return new Utilizador();
    }

    public Loja parseLoja(String input){
        String[] campos = input.split(",");
        String codLoja = campos[0]; 
        String nomeLoja = campos[1];
        return new Loja();
    }

    public Voluntario parseVoluntario(String input){
        //finalizar
    }

    public Encomenda parseEncomenda(String input){
        //finalizar
    }

    public Transportadora parseTransportadora(String input){
        //finalizar
    }

    public Aceite parseAceite(String input){
        //finalizar
    }


    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println(exc.getMessage()); }
        return lines;
    }

}