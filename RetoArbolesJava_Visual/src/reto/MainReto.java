package reto;

import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;
import arboles.vista.VistaArbol;

public class MainReto {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   PARTE 1: CONSTRUIR EL ÁRBOL A");
        System.out.println("=========================================");

        ArbolBinario<String> arbolA = new ArbolBinario<>();
        
        // Construcción del árbol A
        Nodo<String> raizA = arbolA.crearRaiz("LTX");
        
        // Rama Izquierda
        Nodo<String> atf = arbolA.agregarIzquierdo(raizA, "ATF");
        arbolA.agregarIzquierdo(atf, "TUA");
        arbolA.agregarDerecho(atf, "IBB");
        
        // Rama Derecha
        Nodo<String> mch = arbolA.agregarDerecho(raizA, "MCH");
        Nodo<String> snc = arbolA.agregarIzquierdo(mch, "SNC");
        arbolA.agregarIzquierdo(snc, "LGQ");
        arbolA.agregarDerecho(mch, "OCC");

        System.out.println("
--- Vista Visual del Árbol A (8 nodos) ---");
        VistaArbol.mostrar(arbolA);

        System.out.println("
--- Vista Textual (Formato Guía) ---");
        VistaArbol.mostrarTexto(arbolA);

        System.out.println("
=========================================");
        System.out.println("   PARTE 2: CONSULTAR EL ÁRBOL A");
        System.out.println("=========================================");

        System.out.println("Raíz: " + arbolA.getRaiz().getDato());
        System.out.println("Cantidad de nodos: " + arbolA.contarNodos());
        System.out.println("Cantidad de hojas: " + arbolA.contarHojas());
        System.out.println("Altura: " + arbolA.altura());
        System.out.println("Grado de LTX: " + arbolA.grado(raizA));
        System.out.println("Grado de SNC: " + arbolA.grado(snc));

        System.out.println("
=========================================");
        System.out.println("   PARTE 3: CONSTRUIR EL ÁRBOL B Y PROBAR esCadena");
        System.out.println("=========================================");

        ArbolBinario<String> arbolB = new ArbolBinario<>();
        
        // Construcción del árbol B (cadena / lista)
        Nodo<String> gps = arbolB.crearRaiz("GPS");
        Nodo<String> scy = arbolB.agregarDerecho(gps, "SCY");
        Nodo<String> mrr = arbolB.agregarDerecho(scy, "MRR");
        Nodo<String> ptz = arbolB.agregarDerecho(mrr, "PTZ");
        arbolB.agregarDerecho(ptz, "TPN");

        System.out.println("
--- Vista Visual del Árbol B (5 nodos / Cadena) ---");
        VistaArbol.mostrar(arbolB);

        System.out.println("
¿El árbol A es cadena?: " + esCadena(arbolA));
        System.out.println("¿El árbol B es cadena?: " + esCadena(arbolB));

        System.out.println("
=========================================");
        System.out.println("   PRUEBA DE CASOS LÍMITE");
        System.out.println("=========================================");

        // Caso Límite 1: Árbol vacío
        ArbolBinario<String> arbolVacio = new ArbolBinario<>();
        System.out.println("¿Árbol vacío es cadena?: " + esCadena(arbolVacio)); // Debe dar false

        // Caso Límite 2: Árbol de un solo nodo
        ArbolBinario<String> arbolUnNodo = new ArbolBinario<>();
        arbolUnNodo.crearRaiz("SOLO");
        System.out.println("¿Árbol de un solo nodo es cadena?: " + esCadena(arbolUnNodo)); // Debe dar true

        // Caso Límite 3: Agregar hijo en posición ocupada
        System.out.println("Intentando agregar un hijo donde ya existe uno:");
        try {
            arbolA.agregarIzquierdo(raizA, "ERROR");
        } catch (Exception e) {
            System.out.println("Excepción capturada exitosamente: " + e.getMessage());
        }

        System.out.println("
=========================================");
        System.out.println("   RESPUESTAS A LAS PREGUNTAS DEL RETO");
        System.out.println("=========================================");
        
        System.out.println("1. ¿Cuál árbol se parece a una lista?");
        System.out.println("   Respuesta: El Árbol B.");
        
        System.out.println("2. ¿Qué pasaría al buscar un dato en él?");
        System.out.println("   Respuesta: La búsqueda pasa de complejidad O(log n) a O(n), comportándose como lista secuencial.");

        System.out.println("
=========================================");
        System.out.println("   RECORRIDO EXTRA: I -> D -> I en Árbol A");
        System.out.println("=========================================");
        
        Nodo<String> paso1 = arbolA.getRaiz().getIzquierdo(); // ATF
        if (paso1 != null) {
            Nodo<String> paso2 = paso1.getDerecho(); // IBB
            if (paso2 != null) {
                Nodo<String> paso3 = paso2.getIzquierdo();
                if (paso3 != null) {
                    System.out.println("Aeropuerto encontrado: " + paso3.getDato());
                } else {
                    System.out.println("Se llegó a IBB, pero no tiene hijo izquierdo (es nodo hoja).");
                }
            }
        }
    }

    public static <T> boolean esCadena(ArbolBinario<T> arbol) {
        if (arbol == null || arbol.esVacio()) {
            return false;
        }
        return arbol.altura() == (arbol.contarNodos() - 1);
    }
}