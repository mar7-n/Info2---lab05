package lab05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeightedGraph {
    public HashMap<Integer,HashMap<Integer,Integer>> edges;
    public static int n;

    public WeightedGraph() {
        edges = new HashMap<>();
    }

    public static void main (String [] args) throws FileNotFoundException {
        textToGraph();
    }

    public static void textToGraph() throws FileNotFoundException {
        n = 0;
        File fileToBeRead = new File("/Users/martin/Downloads/graph1.txt");
        String s = "";
        Scanner myReader = new Scanner(fileToBeRead);
        while (myReader.hasNextLine()) {
               s = myReader.nextLine();
               String t = s.replace(' ','/');
               System.out.print(t + "\n");
               //String aux = s.substring(0,s.indexOf(' ')-1);
        }
        System.out.print(s);
        String aux = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ' ' && s.charAt(i) != '|') aux += s.charAt(i);
        }

    }

    public int nextCharacter(String s, int i){
        if(i < s.length()){
            System.out.print(s.charAt(i));
            return s.charAt(i);
        } else return -1;
    }

}
