public class RecorreGrafo {
    public static final int CLAVE = -1;

   public static int[] recorrerAnchura(GrafoMatriz g, String org) throws Exception {
       int w, v;
       int[] m;
       v = g.numVertice(org);
       if (v < 0) throw new Exception("Vértice origen no existe");
       ColaLista cola = new ColaLista();
       m = new int[g.numeroDeVertices()];
       for (int i = 0; i < g.numeroDeVertices(); i++)
           m[i] = CLAVE;
       m[v] = 0;
       cola.insertar(v);
       while (!cola.colaVacia()) {
           int cw = (int) cola.quitar();
           w = cw;
           System.out.println("Vértice " + g.obtenerVertice(w).nomVertice() + " visitado");
           for (int u = 0; u < g.numeroDeVertices(); u++) {
               if ((g.obtenerMatAd()[w][u] == 1) && (m[u] == CLAVE)) {
                   m[u] = m[w] + 1;
                   cola.insertar(u);
               }
           }
       }
       return m;
   }
}
