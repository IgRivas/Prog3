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
	}
	
	
