Reto: ¿Árbol sano o árbol en cadena?
Proyecto desarrollado en Java para la materia de Estructuras de Datos / Algoritmos. El objetivo principal es construir y manipular árboles binarios de búsqueda/representación, analizando las métricas clave de la estructura (nodos, hojas, altura, grados) y determinando cuándo un árbol binario se degrada en una cadena secuencial (similar a una lista enlazada).
👥 Integrantes y Participación
Participante
Rol / Responsabilidades
Porcentaje de Participación
Esteban Manobanda
Implementación de la lógica de construcción del Árbol A y B, desarrollo del algoritmo esCadena y pruebas de casos límite.
50%
Sebastián Tenorio
Implementación de consultas de métricas, análisis de complejidad de búsqueda, pruebas de recorridos () y documentación.
50%

📁 Estructura del Proyecto
El código está organizado bajo la arquitectura de paquetes requerida:
RetoArbolesJava/
├── README.md
└── src/
    ├── arboles/
    │   ├── modelo/
    │   │   └── Nodo.java            # Clase contenedora del nodo del árbol
    │   ├── negocio/
    │   │   └── ArbolBinario.java    # Métodos principales y métricas del árbol
    │   └── vista/
    │       └── VistaArbol.java      # Utilidad para la visualización del árbol
    └── reto/
        └── MainReto.java            # Ejecución principal y respuesta al reto


🚀 Compilación y Ejecución
Para compilar y ejecutar el proyecto desde la terminal en la raíz del proyecto:
# 1. Compilar los archivos Java
javac -encoding UTF-8 -d out src/arboles/modelo/*.java src/arboles/negocio/*.java src/arboles/vista/*.java src/reto/MainReto.java

# 2. Ejecutar la aplicación principal
java -cp out reto.MainReto


📊 Respuestas al Reto
¿Cuál árbol se parece a una lista?
El Árbol B se comporta exactamente como una lista enlazada, ya que todos sus nodos tienen únicamente un hijo a la derecha.
¿Qué pasaría al buscar un dato en él?
Al degradarse a una lista enlazada (cadena), la eficiencia de búsqueda se reduce de una complejidad logarítmica  (propia de un árbol equilibrado) a una complejidad lineal .
Recorrido Extra ( en el Árbol A):
Partiendo de LTX, al ir a la izquierda se llega a ATF, luego a la derecha a IBB. Como IBB es una hoja y no posee hijo izquierdo, el recorrido se detiene en ese punto.
