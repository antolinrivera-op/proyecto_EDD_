# SynapseLogic - Simulador de Redes Neuronales

**SynapseLogic** es una aplicación Java que modela una red neuronal como un **grafo dirigido**, donde cada neurona es un nodo y cada conexión sináptica es una arista ponderada. Permite cargar redes desde archivos CSV, analizar conectividad, calcular rutas óptimas de transmisión (menor tiempo) y simular efectos como la fatiga sináptica.

## Características principales

- **Modelado de red neuronal**: neuronas con identificador único y conexiones sinápticas dirigidas.
- **Diccionario de neurotransmisores**: 50 neurotransmisores predefinidos (glutamato, dopamina, serotonina, etc.) almacenados en una **tabla hash** propia, con búsqueda O(1).
- **Carga y guardado en CSV**: importar/exportar redes neuronales y diccionarios desde archivos de texto estructurados.
- **Algoritmos de recorrido**:
  - **BFS** (búsqueda en anchura) y **DFS** (búsqueda en profundidad) para determinar neuronas alcanzables.
  - Detección de **zonas aisladas** (neuronas no alcanzables desde una fuente).
- **Ruta óptima (Dijkstra)**: calcula la ruta de **menor tiempo de transmisión** entre dos neuronas, usando la fórmula:
    tiempo = distancia / (velocidad_neurotransmisor * coeficiente_eficiencia)
- - **Análisis de conectividad**: verifica si la red es **fuertemente conexa** (desde cualquier neurona se puede llegar a cualquier otra).
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
Ejemplo:  GLU,DA,0.75,GLU,0.9

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

## tecnologías

- **Java 21+** (el proyecto está configurado para JDK 25, pero funciona con versiones modernas).
- **NetBeans** (archivos de proyecto incluidos).
- **Ant** para la construcción (build.xml).

## Estructura del proyecto
  src/
  ├── BfsDfs/ # BFS y DFS
  ├── Clases/ # Neuronas, conexiones, red, diccionario, analizadores
  ├── Edd/ # Lista enlazada, pila, cola, tabla hash
  └── proyectoneuronal/ # Clase principal (main vacío por ahora)
  
## 👥 Autores

Proyecto desarrollado por Isaac Charco, Christian García y Antolin Rivera

## 📄 Licencia

UNIMET
