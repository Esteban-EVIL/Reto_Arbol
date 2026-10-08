package arboles.vista;

import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;

public class VistaArbol {

    /**
     * Muestra el árbol en formato de jerarquía con ramas verticales / diagonales
     * emulando un diagrama de diagrama o árbol visual (estilo ASCII / Unicode).
     */
    public static <T> void mostrar(ArbolBinario<T> arbol) {
        if (arbol == null || arbol.esVacio()) {
            System.out.println("(Árbol vacío)");
            return;
        }
        imprimirNodo(arbol.getRaiz(), "", true, true);
    }

    private static <T> void imprimirNodo(Nodo<T> nodo, String prefijo, boolean esUltimo, boolean esRaiz) {
        if (nodo == null) return;

        if (esRaiz) {
            System.out.println("      (" + nodo.getDato() + ")");
        } else {
            System.out.println(prefijo + (esUltimo ? "└── (" : "├── (") + nodo.getDato() + ")");
        }

        String nuevoPrefijo = prefijo + (esRaiz ? "   " : (esUltimo ? "    " : "│   "));

        boolean tieneIzq = nodo.getIzquierdo() != null;
        boolean tieneDer = nodo.getDerecho() != null;

        if (tieneIzq && tieneDer) {
            imprimirNodo(nodo.getIzquierdo(), nuevoPrefijo, false, false);
            imprimirNodo(nodo.getDerecho(), nuevoPrefijo, true, false);
        } else if (tieneIzq) {
            imprimirNodo(nodo.getIzquierdo(), nuevoPrefijo, true, false);
        } else if (tieneDer) {
            imprimirNodo(nodo.getDerecho(), nuevoPrefijo, true, false);
        }
    }

    /**
     * Muestra una representación textual limpia del árbol como en el enunciado.
     */
    public static <T> void mostrarTexto(ArbolBinario<T> arbol) {
        if (arbol == null || arbol.esVacio()) {
            System.out.println("(Árbol vacío)");
            return;
        }
        System.out.println(arbol.getRaiz().getDato());
        imprimirTextoRec(arbol.getRaiz(), "");
    }

    private static <T> void imprimirTextoRec(Nodo<T> nodo, String indent) {
        if (nodo == null) return;

        if (nodo.getIzquierdo() != null) {
            System.out.println(indent + "+-- I: " + nodo.getIzquierdo().getDato());
            imprimirTextoRec(nodo.getIzquierdo(), indent + "|   ");
        }
        if (nodo.getDerecho() != null) {
            System.out.println(indent + "`-- D: " + nodo.getDerecho().getDato());
            imprimirTextoRec(nodo.getDerecho(), indent + "    ");
        }
    }
}