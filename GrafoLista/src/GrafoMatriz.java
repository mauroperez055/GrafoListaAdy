public class GrafoMatriz {

    int numVerts;
    static int MaxVerts = 20;
    Vertice[] verts;
    int[][] matAd;

    public GrafoMatriz() {
        this(MaxVerts);
    }

    public GrafoMatriz(int mx) {
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; i < mx; i++) {
                matAd[i][j] = 0;
            }
        }
        numVerts = 0;
    }

    public Vertice[] obtenerVertices() {
        return verts;
    }

    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom);
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = verts[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }
        return (i < numVerts) ? i : -1;
    }

    public void nuevoArco(String a, String b) throws Exception {
        int va,
                vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) {
            throw new Exception("Vértice no existe");
        }
        matAd[va][vb] = 1;
    }

    public void nuevoArco(int va, int vb) throws Exception {
        if (va < 0 || vb < 0) {
            throw new Exception("Vértice no existe");
        }
        matAd[va][vb] = 1;
    }

    public boolean adyacente(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) {
            throw new Exception("Vértice no existe");
        }
        return matAd[va][vb] == 1;
    }

    public boolean adyacente(int va, int vb) throws Exception {
        if (va < 0 || vb < 0) {
            throw new Exception("Vértice no existe");
        }
        return matAd[va][vb] == 1;
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    public void mostrarMatriz() {
        try {
            System.out.print("  | ");

            for (int i = 0; i < verts.length; i++) {
                System.out.print(verts[i].nomVertice() + " ");
            }
            System.out.println();
            System.out.print("----");
            for (int i = 0; i < verts.length; i++) {
                System.out.print("--");
            }

            System.out.println();
            for (int i = 0; i < matAd.length; i++) {

                System.out.print(verts[i].nomVertice() + " | ");

                for (int j = 0; j < matAd.length; j++) {
                    System.out.print(matAd[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {

            System.out.println("MATRIZ VACIA");
        }
    }

    public int[][] obtenerMatAd() {
        return matAd;
    }

    public Vertice obtenerVertice(int v) {
        return verts[v];
    }
}