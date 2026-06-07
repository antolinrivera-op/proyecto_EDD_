- **Análisis de conectividad**: verifica si la red es **fuertemente conexa** (desde cualquier neurona se puede llegar a cualquier otra).
- **Gestor de fatiga**: multiplica el coeficiente de eficiencia `k` de todas las conexiones por 1.2, simulando el desgaste sináptico.

## Estructuras de datos implementadas desde cero

El proyecto no utiliza colecciones de Java (`ArrayList`, `HashMap`, etc.), sino que implementa sus propias estructuras genéricas:

- `ListaEnlazada<T>` – lista simplemente enlazada.
- `Pila<T>` y `Cola<T>` – basadas en lista enlazada para BFS/DFS.
- `TablaHash<K, V>` – hash con resolución de colisiones por encadenamiento.
- `Nodo<T>` y `NodoHash<K, V>` – nodos reutilizables.

## Formato de archivos

**Red neuronal (CSV)**  
`origen,destino,distancia,ID_Neurotransmisor,coheficiente_eficiencia_sináptica`  
Ejemplo:  

**Diccionario de neurotransmisores (CSV)**  
`id,nombre,efecto,velocidad,descripcion`

## Cómo usar

1. Cargue primero un **diccionario** (o use el que viene por defecto con 50 neurotransmisores).
2. Cargue una **red neuronal** desde un archivo CSV.
3. Explore las opciones:
   - Calcular zonas aisladas desde una neurona.
   - Ejecutar BFS o DFS.
   - Encontrar la ruta más rápida entre dos neuronas.
   - Aplicar fatiga y observar cómo aumentan los tiempos de transmisión.
   - Verificar si la red es fuertemente conexa.
4. Guarde la red modificada en un nuevo archivo CSV.

## Tecnologías

- **Java 21+** (el proyecto está configurado para JDK 25, pero funciona con versiones modernas).
- **NetBeans** (archivos de proyecto incluidos).
- **Ant** para la construcción (build.xml).

## Estructura del proyecto
src/
├── BfsDfs/ # BFS y DFS
├── Clases/ # Neuronas, conexiones, red, diccionario, analizadores
├── Edd/ # Lista enlazada, pila, cola, tabla hash
└── proyectoneuronal/ # Clase principal (main vacío por ahora)

## Autores

Proyecto desarrollado por Isaac Charco, Christian García y Antolin Rivera

## 📄 Licencia

UNIMET
