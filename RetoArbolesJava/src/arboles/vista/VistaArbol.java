package arboles.vista;

import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;

public class VistaArbol {

    public static <T> void mostrar(ArbolBinario<T> arbol) {
        if (arbol.esVacio()) {
            System.out.println("(Árbol vacío)");
            return;
        }
        imprimirNodo(arbol.getRaiz(), "", true);
    }

    private static <T> void imprimirNodo(Nodo<T> nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.getDato());
            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");
            boolean tieneDer = nodo.getDerecho() != null;
            if (nodo.getIzquierdo() != null) {
                imprimirNodo(nodo.getIzquierdo(), nuevoPrefijo, !tieneDer);
            }
            if (nodo.getDerecho() != null) {
                imprimirNodo(nodo.getDerecho(), nuevoPrefijo, true);
            }
        }
    }
}