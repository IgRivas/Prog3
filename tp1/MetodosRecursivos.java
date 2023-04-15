package tp1;

public class MetodosRecursivos {

public MetodosRecursivos(){

}
	//Metodo recursivo para dos cadenas, retorna si son o no capicuas
	public boolean capicuaRecursivo(String a, String b){
		if(a.length()<=1 && b.length()<=1){
			
		return a.equals(b);
		}
		 if (a.charAt(0) == b.charAt(b.length() - 1)) {
		        // Llamada recursiva sin el primer y último caracter
		        return capicuaRecursivo(a.substring(1), b.substring(0, b.length() - 1));
		    } else {
		        return false;
		    }
		}
	public static boolean esCapicua(String str) {
	    // Verifica si la cadena es de longitud 0 o 1
	    if (str.length() <= 1) {
	        return true;
	    }
	    
	    // Compara el primer y último caracter de la cadena
	    if (str.charAt(0) == str.charAt(str.length() - 1)) {
	        // Llamada recursiva sin el primer y último caracter
	        return esCapicua(str.substring(1, str.length() - 1));
	    } else {
	        return false;
	    }
	}
	 //Necesito pasarle el n, para poder retroceder la posicion a la hora de comparar
	public boolean ArrayOrdenado(int [] array, int n){
			if( n == 1 || n==0){
				return true;
				
			}
			if(array[n-1] < array[n-2]){
				return false;
			}		
		return ArrayOrdenado(array,n-1);
	}
	//tengo que preguntar si n es m
	public boolean buscarEnArrayOrdenado(int[] array, int n, int pos){
	
	}

}

