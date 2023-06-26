import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Vertice> letras = new ArrayList<Vertice>();
        letras.add(new Vertice("A"));
        letras.add(new Vertice("B"));
        letras.add(new Vertice("C"));
        letras.add(new Vertice("D"));
        letras.add(new Vertice("H"));
        letras.add(new Vertice("R"));
        letras.add(new Vertice("T"));
        
        try {
            GrafoMatriz matrizAdyacencia = new GrafoMatriz(letras.size());
            matrizAdyacencia.mostrarMatriz();
            System.out.println();            
            System.out.println("====================");
            System.out.println();          
            Iterator<Vertice> it= letras.iterator();
            while(it.hasNext()){
                matrizAdyacencia.nuevoVertice(it.next().nomVertice());
            }
            
            matrizAdyacencia.mostrarMatriz();
            System.out.println();          
            System.out.println("====================");
            System.out.println();
            matrizAdyacencia.nuevoArco("D", "B");
            matrizAdyacencia.nuevoArco("D", "C");
            matrizAdyacencia.nuevoArco("B", "H");
            matrizAdyacencia.nuevoArco("C", "R");
            matrizAdyacencia.nuevoArco("R", "H");
            matrizAdyacencia.nuevoArco("H", "A");
            matrizAdyacencia.nuevoArco("H", "T");
          
            matrizAdyacencia.mostrarMatriz();
            System.out.println("====================");
            System.out.println();
            RecorreGrafo.recorrerAnchura(matrizAdyacencia, "D");
            
            
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
