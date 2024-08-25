package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos


{
	
// ATRIBUTOS DE LA CLASE
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    
 // ESTE ES EL CONSTRUCTOR
    public SandboxArreglos( )
    {
    	// Inicializa los arreglos vacíos con tamaño 0
    	arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    
 // METODOS
    
    
    public int[] getCopiaEnteros( )
    {
        return Arrays.copyOf(arregloEnteros, arregloEnteros.length);
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        return Arrays.copyOf(arregloCadenas, arregloCadenas.length);
     
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {   
    	// Creo un nuevo arreglo con un espacio adicional (arreglo original + 1)
    	arregloEnteros = Arrays.copyOf(arregloEnteros, arregloEnteros.length + 1);
    	// Asigno el nuevo entero a la última posición del arreglo
        arregloEnteros[arregloEnteros.length - 1] = entero;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	arregloCadenas = Arrays.copyOf(arregloCadenas, arregloCadenas.length + 1);
        arregloCadenas[arregloCadenas.length - 1] = cadena;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int count = 0;// Contador para rastrear la posición en el nuevo arreglo
        for (int num : arregloEnteros)// Recorro cada elemento en arregloEnteros
        {
            if (num != valor)//Miro si el número no es igual al valor a eliminar
            {
                arregloEnteros[count++] = num;// Lo mantengo en el nuevo arreglo
            }
        }
        // Ajusto el tamaño del arreglo para reflejar solo los elementos que quedaron
        arregloEnteros = Arrays.copyOf(arregloEnteros, count);

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int count = 0;
        for (String str : arregloCadenas)
        {
            if (!str.equals(cadena))
            {
                arregloCadenas[count++] = str;
            }
        }
        arregloCadenas = Arrays.copyOf(arregloCadenas, count);

    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        if (posicion < 0)
        {
            posicion = 0;
        }
        else if (posicion > arregloEnteros.length)
        {
            posicion = arregloEnteros.length;
        }
        for (int i = 0, j = 0; i < nuevoArreglo.length; i++)
        {
            if (i == posicion)
            {
                nuevoArreglo[i] = entero;
            }
            else
            {
                nuevoArreglo[i] = arregloEnteros[j++];
            }
        }
        arregloEnteros = nuevoArreglo;

    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (posicion < 0 || posicion >= arregloEnteros.length) // Verifico si la posición es válida
        {
            return; // Si no es válida, no hago nada
        }
        int[] nuevoArreglo = new int[arregloEnteros.length - 1]; // Nuevo arreglo más pequeño
        for (int i = 0, j = 0; i < arregloEnteros.length; i++)
        {
            if (i != posicion) // Copio todos los elementos menos el que se elimina
            {
                nuevoArreglo[j++] = arregloEnteros[i];
            }
        }
        arregloEnteros = nuevoArreglo; // Actualizo el arreglo original

    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	arregloEnteros = new int[valores.length]; // Nuevo arreglo del mismo tamaño
        for (int i = 0; i < valores.length; i++)
        {
            arregloEnteros[i] = (int) Math.floor(valores[i]); // aproximo los valores decimales
        }

    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	arregloCadenas = new String[objetos.length]; // Nuevo arreglo del mismo tamaño
        for (int i = 0; i < objetos.length; i++)
        {
            arregloCadenas[i] = objetos[i].toString(); // Convierto cada objeto a cadena
        }

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	 for (int i = 0; i < arregloEnteros.length; i++)
         {
             if (arregloEnteros[i] < 0)
             {
                 arregloEnteros[i] = -arregloEnteros[i]; // Convierto el número negativo en positivo
             }
         }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	 Arrays.sort(arregloEnteros); // Uso el método sort para ordenar el arreglo

    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas); 

    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int count = 0; 
        for (int num : arregloEnteros) // Recorro cada elemento del arreglo
        {
            if (num == valor) // Si el número es igual al valor buscado
            {
                count++; // Incremento el contador
            }
        }
        return count; 
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int count = 0;
        for (String str : arregloCadenas)
        {
            if (str.equalsIgnoreCase(cadena)) // Comparo ignorando mayúsculas y minúsculas
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
  
        
        int count = 0; 
        
        // Recorro el arreglo para contar cuántas veces aparece 'valor'
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                count++;
            }
        }
        
        // Si no se encontró el valor, retorno un arreglo vacío
        if (count == 0) {
            return new int[] {}; 
        }
        
        // Si encontramos el valor, creo un arreglo del tamaño 'count' para almacenar las posiciones
        int[] posiciones = new int[count];
        int posIndex = 0; // Índice para el arreglo de posiciones
        
        // Recorro el arreglo para almacenar las posiciones donde se encuentra 'valor'
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[posIndex++] = i; // Guardo la posición y avanzo en el índice
            }
        }
        
        return posiciones; 
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros.length == 0) {
	        return new int[] {}; 
	    }
	    
	    int min = arregloEnteros[0]; 
	    int max = arregloEnteros[0]; 
	    
	    // Recorro el arreglo para encontrar el valor mínimo y máximo
	    for (int i = 1; i < arregloEnteros.length; i++) {
	        if (arregloEnteros[i] < min) {
	            min = arregloEnteros[i]; // Actualizo el mínimo
	        }
	        if (arregloEnteros[i] > max) {
	            max = arregloEnteros[i]; // Actualizo el máximo
	        }
	    }
	    
	    // Retornamos un arreglo con el mínimo y el máximo
	    return new int[] {min, max};
    	  
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	
        HashMap<Integer, Integer> histograma = new HashMap<>(); // Mapa para almacenar el histograma
        
        // Recorro el arreglo para contar las apariciones de cada valor
        for (int num : arregloEnteros) {
            histograma.put(num, histograma.getOrDefault(num, 0) + 1); // Si el valor ya está en el mapa, incremento el contador, y si no, lo agrego con valor 1
        }
        
        return histograma; 
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	HashMap<Integer, Integer> histograma = calcularHistograma(); // Esto para saber cuántas veces aparece cada valor
        int count = 0; 
        
        // Recorro el histograma para contar cuántos valores tienen más de una aparición
        for (int valor : histograma.values()) {
            if (valor > 1) {
                count++; // Si el valor aparece más de una vez, incremento el contador
            }
        }
        
        return count; 
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	return Arrays.equals(arregloEnteros, otroArreglo); // Uso Arrays.equals para comparar ambos arreglos elemento por elemento
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {

        int[] copia1 = Arrays.copyOf(arregloEnteros, arregloEnteros.length); // Hago una copia de arregloEnteros
        int[] copia2 = Arrays.copyOf(otroArreglo, otroArreglo.length); // Hago una copia de otroArreglo
        
        Arrays.sort(copia1); // Ordeno primera copia
        Arrays.sort(copia2); // Ordeno segunda copia
        
        return Arrays.equals(copia1, copia2); // Comparo para ver si contienen los mismos elementos
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	arregloEnteros = new int[cantidad]; // Creo un nuevo arreglo del tamaño cantidad
        
        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = minimo + (int)(Math.random() * (maximo - minimo + 1)); // Genero un número aleatorio en el rango [minimo, maximo]
        }

    }

}
