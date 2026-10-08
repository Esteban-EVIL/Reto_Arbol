Reto: ¿Árbol sano o árbol en cadena?
Estructuras de Datos y Algoritmos — Universidad Técnica de Ambato
1. Descripción del Proyecto
Proyecto desarrollado en Java para evaluar el comportamiento y métricas clave de los árboles binarios. El objetivo principal es construir y manipular estructuras arbóreas, analizando métricas como nodos, hojas, altura y grados, para determinar cuándo un árbol binario se degrada en una cadena secuencial (lista enlazada).
2. Integrantes y Participación
Participante	Rol / Responsabilidades	% Participación
Esteban Manobanda	Implementación de la lógica de construcción de los Árboles A y B, desarrollo del algoritmo esCadena y pruebas de casos límite.	50%
Sebastián Tenorio	Implementación de consultas de métricas, análisis de complejidad de búsqueda, pruebas de recorridos (I ➔ D ➔ I) y documentación.	50%

3. Estructura del Proyecto
RetoArbolesJava/
└── src/
    ├── arboles/
    │   ├── modelo/
    │   │   └── Nodo.java             # Clase contenedora del nodo del árbol
    │   ├── negocio/
    │   │   └── ArbolBinario.java     # Métodos principales y métricas del árbol
    │   └── vista/
    │       └── VistaArbol.java       # Utilidad para la visualización gráfica
    └── reto/
        └── MainReto.java             # Ejecución principal y respuesta al reto
4. Compilación y Ejecución
Comandos para ejecutar desde la consola:
# 1. Compilar los archivos Java
javac -encoding UTF-8 -d out src/arboles/modelo/*.java src/arboles/negocio/*.java src/arboles/vista/*.java src/reto/MainReto.java

# 2. Ejecutar la aplicación principal
java -cp out reto.MainReto
5. Respuestas al Reto
• ¿Cuál árbol se parece a una lista?
El Árbol B se comporta exactamente como una lista enlazada, ya que todos sus nodos poseen únicamente un hijo a la derecha (degenere).
• ¿Qué pasaría al buscar un dato en él?
Al degradarse a una lista enlazada (cadena), la eficiencia de búsqueda se reduce de una complejidad logarítmica O(log n) (propia de un árbol equilibrado) a una complejidad lineal O(n).
• Recorrido Extra (I ➔ D ➔ I en el Árbol A):
Partiendo de LTX, al ir a la izquierda se llega a ATF, luego a la derecha a IBB. Como IBB es un nodo hoja y no posee hijo izquierdo, el recorrido se detiene en ese punto.
