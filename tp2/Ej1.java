package tp2;

public class Ej1 {
	
	public void selectionSort(int[] arr){
		int n = arr.length;
		for(int i =0; i< n-1; i++){
			int indice =i;
			for(int j= i+1; j<n; j++){
				if(arr[j]< arr[indice]){
					indice = j;
				}
			
			}
		}
	}
}
