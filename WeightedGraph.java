package lab05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WeightedGraph {
    public static HashMap<Long,HashMap<Long,Integer>> edges;

    public static int infinite = Integer.MAX_VALUE;

    public WeightedGraph() {
        edges = new HashMap<>();
    }

    public static void main (String [] args) throws FileNotFoundException {
        new WeightedGraph();
        textToGraph();
        /*List<Long> keysAsArray = new ArrayList<>(edges.keySet());
        Random r = new Random();
        shortestPath(keysAsArray.get(r.nextInt(keysAsArray.size())),keysAsArray.get(r.nextInt(keysAsArray.size())));*/
        shortestPath(60192001006L,60068201511L);
        shortestPath(60192001006L,60120003653L);
        shortestPath(60192001006L,60029101731L);
        shortestPath(60192001006L,70201074701L);
    }

    public static void textToGraph() throws FileNotFoundException {
        File fileToBeRead = new File("/Users/martin/Downloads/bvg.txt");
        Scanner myReader = new Scanner(fileToBeRead);
        while (myReader.hasNextLine()) {
               String s = myReader.nextLine();
               int pos = s.indexOf(' ');
               String origin = s.substring(0,pos);
               long station = Long.parseLong(origin);
               edges.put(station,new HashMap<>());
               while(pos<s.length() && pos != -1) {
                   String finalStation = s.substring(pos+1,s.indexOf(',',pos+1));
                   String duration;
                   if(s.indexOf(' ',pos+1) == -1) duration = s.substring(s.indexOf(',',pos+1)+1);
                   else duration = s.substring(s.indexOf(',',pos+1)+1,s.indexOf(' ',pos+1));
                   edges.get(station).put(Long.parseLong(finalStation),Integer.parseInt(duration));
                   pos = s.indexOf(' ',pos+1);
               }
        }
    }

    public static void shortestPath(long origin, long destination) throws FileNotFoundException {
        HashMap<Long,Integer> dijkstra = new HashMap<>();
        HashMap<Long,Integer> aux = new HashMap<>();
        dijkstra.put(origin,0);
        Set<Long> keys = edges.get(origin).keySet();
        for (Long a: keys) {
            int value = edges.get(origin).get(a);
            aux.put(a,value);
            dijkstra.put(a,value);
        }
        while(!aux.isEmpty()) {
            long min = lookForTheMin(aux);
            keys = edges.get(min).keySet();
            for (Long a: keys) {
                if(dijkstra.get(a) == null){
                    dijkstra.put(a,edges.get(min).get(a)+dijkstra.get(min));
                    aux.put(a,edges.get(min).get(a)+dijkstra.get(min));
                } else if(edges.get(min).get(a)+dijkstra.get(min) < dijkstra.get(a)) {
                    dijkstra.replace(a,edges.get(min).get(a)+dijkstra.get(min));
                    aux.replace(a,edges.get(min).get(a)+dijkstra.get(min));
                }
            }
            aux.remove(min);
        }
        printResult(origin,destination,dijkstra);
    }

    public static long lookForTheMin(HashMap<Long,Integer> aux){
        Set<Long> keys = aux.keySet();
        int minValue = infinite;
        long min = infinite;
        for (Long a: keys) {
            if(aux.get(a) < minValue) {
                minValue = aux.get(a);
                min = a;
            }
        }
        return min;
    }

    public static String GraphToText(long station) throws FileNotFoundException {
        File fileToBeRead = new File("/Users/martin/Downloads/stations.txt");
        String result = "";
        Scanner myReader = new Scanner(fileToBeRead);
        while (myReader.hasNextLine() && result.equals("")) {
            String s = myReader.nextLine();
            String stationNumber = s.substring(0,s.indexOf(','));
            if(Long.parseLong(stationNumber) == station) result = s.substring(s.indexOf(", ")+2);
        }
        return result;
    }

    public static void printResult(long origin, long destination, HashMap<Long,Integer> dijkstra) throws FileNotFoundException {
        double minutes = dijkstra.get(destination) / 60.0;
        System.out.println(GraphToText(origin) + " -> " + GraphToText(destination) + ": " + dijkstra.get(destination) + " seconds"
                + " / " + minutes + " minutes. \n");
    }

}
