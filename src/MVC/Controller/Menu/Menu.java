package MVC.Controller.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<String> opcoes;
    private int op;

    public Menu(String[] opcoes) {
        this.opcoes = Arrays.asList(opcoes);
        this.op = 0;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("\n *** Menu *** \n");
        for (int i = 0; i < this.opcoes.size(); i++) {
            ret.append(i+1);
            ret.append(" - ");
            ret.append(this.opcoes.get(i) + "\n");
        }
        ret.append("0 - Sair");
        return ret.toString();
    }

    public int lerOpcao() {
        //int op; 
        Scanner is = new Scanner(System.in);
        
        System.out.print("Opção: ");
        try {
            op = is.nextInt();
        }
        catch (InputMismatchException e) { // Não foi inscrito um int
            op = -1;
        }
        if (op<0 || op>this.opcoes.size()) {
            System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }
}