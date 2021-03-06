# ADDA. Java
Prácticas con Java de la asignatura Análisis y Diseño de Datos y Algoritmos (Universidad de Sevilla).

## Práctica 1

- **Ejercicio 1** (EJ.38): Dado un entero *n* obtener un lista con sus divisores.
- **Ejercicio 2** (EJ.11): Dada una lista de puntos, agrupar los puntos por cuadrantes, devolviendo un ListMultimap en el que se asocie a cada cuadrante los puntos que están en él.
- **Ejercicio 3** (EJ.21): Encontrar la inversa de una cadena de caracteres.

## Práctica 2

- **Ejercicio 1** (EJ.60): Generar la lista de los cuadrados de los números primos hasta un número dado.
- **Ejercicio 2** (EJ.53): Dadas dos listas de números reales del mismo tamaño, decidir si los incrementos del valor almacenado en cada posición con respecto a la anterior son del mismo signo en ambas listas para todas las posiciones.


## Práctica 3

- **Ejercicio 1** (EJ.68): Diseñar un algoritmo que calcule los valores de la recurrencia<br> ``F(n) = 2 * F(n - 1) + 3 * F(n - 2) - F(n - 3) con F(2) = 1, F(1) = 1, F(0) = 2``<br> Realizar el cálculo de los valores de recurrencia de abajo a arriba. Proporcionar una solución:
    - Recursiva no final sin memoria en C.
    - Iterativa (usando while) en C.
    - Recursiva final en C.
    - Recursiva no final con memoria en C.
- **Ejercicio 2** (EJ.70): Diseñar un algoritmo para el cálculo de un número combinatorio a partir de la siguiente definición:
<img src="./images/pract3-ej2.png" alt="Definición para ejercicio 2 de práctica 3." width=80% style="display:block"> <br>Proporcionar una solución:
    - Recursiva no final sin memoria en Java.
    - Recursiva no final con memoria en Java.


## Práctica 4

- **Ejercicio 1** (EJ.77): Sea *a* un array de n elementos de tipo entero ordenados en orden estrictamente creciente. Encontrar un algoritmo de complejidad (log n) en el caso peor, para determinar la posición *i* tal que ``a[i] = i``.
    - Solución iterativa (usando while).
    - Solución funcional.
    - Solución recursiva lineal.
- **Ejercicio 2** (EJ.71): Se dispone de una lista no ordenada de canciones. Se quiere buscar la canción que ocuparía la posición *k* si estuvieran ordenadas según su duración (primero las canciones más cortas).


## Práctica 5

- **Ejercicio 1** (EJ.104): Determinar si un árbol *n-ario* contiene una etiqueta dada.
- **Ejercicio 2** (EJ.106): Comprobar si dos árboles *n-arios* son iguales.
- **Ejercicio 3** (EJ.102): Obtener la menor etiqueta de un árbol binario respecto a un orden.
- **Ejercicio 4** (EJ.108): Obtener la copia simétrica de árbol binario.


## Práctica 6

- **Ejercicio 1** (EJ.101): Suma de las etiquetas del árbol (binario / *n-ario*) que son pares (asumiendo que son de tipo Integer).
- **Ejercicio 2** (EJ.116): Convertir un árbol binario en una lista que contiene sus etiquetas en recorrido en posorden. En este recorrido se añaden primero las etiquetas de su hijo izquierdo, luego las del derecho y por último la etiqueta del árbol actual.
- **Ejercicio 3** (EJ.43): Encontrar la raíz cuadrada de un número (la raíz cuadrada de un entero *a* es el mayor valor de un entero *n* tal que *a* >= *n*^2). (Iterativo, recursivo y funcional).
    - Usar una búsqueda secuencial en el rango de 2...*n*-1.
    - Usar una búsqueda binaria en el rango de 2...*n*-1.
