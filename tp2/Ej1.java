package tp2;

public class Ej1 {
	//Nota: El ordenamiento por selección no es muy eficiente para arrays grandes 
	//debido a su complejidad de tiempo de O(n^2).
	//En la primer iteracion, voy guardando el menor comparado con el primer elemento, en la variable indice
	public void selectionSort(int[] arr){
		int n = arr.length;
		for(int i =0; i< n-1; i++){
			int indice =i;
			for(int j= i+1; j<n; j++){
				if(arr[j]< arr[indice]){
					indice = j;
				}
			}
			//Intercambio de valores.
			int temp = arr[indice];
			arr[indice] = arr[i];
			arr[i] = temp;
		}
	}
	
	public void bubbleSort(int[] arr){
		boolean intercambio = true;
		int j = 0;
		int temp;
		while(intercambio == true){
			intercambio = false;
			j++;
			for(int i =0;i<arr.length-j; i++){
				if(arr[i] > arr[i+1]){
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]= temp;
					intercambio = true;
				}
			}
		}
	}
	public class Mergesort {
		private int[ ] numbers;
		private int[ ] helper;
		private int size;
		
		public void sort(int[ ] values) {
		this.numbers = values;
		size = values.length;
		this.helper = new int[size];
		mergesort(0, size - 1);
		}
		private void mergesort(int low, int high) {
//		 si low es menor que high continua el ordenamiento
//		 si low no es menor que high entonces el array está ordenado
//		 ya que es el caso base donde el array tiene un solo elemento.
		if (low < high) {
		// obtener el indice del elemento que se encuentra en la mitad
		// al ser int redondea el resultado al entero menor
		int middle = (low + high) / 2;
		// ordenar la mitad izquierda del array – llamada recursiva
		mergesort(low, middle);
		// ordenar la mitad derecha del array – llamada recursiva
		mergesort(middle + 1, high);
		// combinar ambas mitades ordenadas
		merge(low, middle, high);
		}
		}

	private void merge(int low, int middle, int high) {
		// copiar ambas partes al array helper
		for (int i = low; i <= high; i++) {
		helper[i] = numbers[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		// copiar de manera ordenada al array original los valores de la
		// mitad izquierda o de la derecha
		while (i <= middle && j <= high) {
		if (helper[ i ] <= helper[ j ]) {
		numbers[ k ] = helper[ i ];
		i++;
		} else {
		numbers[ k ] = helper[ j ];
		j++;
		}
		k++;
		}
		// si quedaron elementos copiarlos al array original
		while (i <= middle) {
		numbers[ k ] = helper[ i ];
		k++;
		i++;
		}
		while (j <= high) {
		numbers[ k ] = helper[ j ];
		k++;
		j++;
		}
		}
		}
	

}
	
	
