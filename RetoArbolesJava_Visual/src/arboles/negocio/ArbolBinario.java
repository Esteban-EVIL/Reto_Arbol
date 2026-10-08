package arboles.negocio;

import arboles.modelo.Nodo;

public class ArbolBinario<T> {
    private Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public Nodo<T> crearRaiz(T dato) {
        this.raiz = new Nodo<>(dato);
        return this.raiz;
    }

    public Nodo<T> agregarIzquierdo(Nodo<T> padre, T dato) {
        if (padre == null) {
            throw new IllegalArgumentException("El nodo padre no puede ser nulo.");
        }
        if (padre.getIzquierdo() != null) {
            throw new IllegalStateException("El nodo ya tiene un hijo izquierdo.");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setIzquierdo(nuevo);
        return nuevo;
    }

    public Nodo<T> agregarDerecho(Nodo<T> padre, T dato) {
        if (padre == null) {
            throw new IllegalArgumentException("El nodo padre no puede ser nulo.");
        }
        if (padre.getDerecho() != null) {
            throw new IllegalStateException("El nodo ya tiene un hijo derecho.");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setDerecho(nuevo);
        return nuevo;
    }

    public int contarNodos() {
        return contarNodosRec(raiz);
    }

    private int contarNodosRec(Nodo<T> nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodosRec(nodo.getIzquierdo()) + contarNodosRec(nodo.getDerecho());
    }

    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(Nodo<T> nodo) {
        if (nodo == null) return 0;
        if (nodo.esHoja()) return 1;
        return contarHojasRec(nodo.getIzquierdo()) + contarHojasRec(nodo.getDerecho());
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo<T> nodo) {
        if (nodo == null) return -1;
        int altIzq = alturaRec(nodo.getIzquierdo());
        int altDer = alturaRec(nodo.getDerecho());
        return 1 + Math.max(altIzq, altDer);
    }

    public int grado(Nodo<T> nodo) {
        if (nodo == null) return 0;
        int g = 0;
        if (nodo.getIzquierdo() != null) g++;
        if (nodo.getDerecho() != null) g++;
        return g;
    }
}