package tp2;

import java.util.ArrayList;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Integer getValue() {
		return value;
	}

	public void add(Integer newValue) {
		if (newValue < this.value) {
			if (this.left == null)
				this.left = new Tree(newValue);
			else
				this.left.add(newValue);
		} else if (newValue > this.value) {
			if (this.right == null)
				this.right = new Tree(newValue);
			else
				this.right.add(newValue);
		}
	}
	
	public Integer getRoot(){
		Integer toReturn = null;
		if(this.value != null ){
			toReturn = this.value;
		}
		return toReturn;
	}
	
	
	public void imprimirPreOrden(){
	
		//siempre que me encuentro con un valor nulo, imprimo un guion
		if(this.value == null){
			System.out.println("-");
		}
		else{
			
			//si el arbol no esta vacio, imprimo el primer valor con el qye me encuentro
			System.out.println(this.value);
			
			//se verifica si su izq no es nula para pedirle que se imprima su valor
			if(this.left != null){
				this.left.imprimirPreOrden();
			} else System.out.println("-");
		
			//se verifica si su derecha no es nula para pedirle que se imprima su valor
			if(this.right != null){
				this.right.imprimirPreOrden();
			} else System.out.println("-");
		}
	}
	
	public void imprimirPostOrder(){
		if(this.left != null){
			this.left.imprimirPostOrder();
		}
		if(this.right!= null){
			this.right.imprimirPostOrder();
		}
		System.out.println(this.value);
		if(this.left== null && this.right == null){
			System.out.println("-");
		}
	}
	
	public void imprimirInOrder(){
		if(this.left != null){
			this.left.imprimirInOrder();
		}
		System.out.println(this.value);
		if(this.right != null){
			this.right.imprimirInOrder();
		}
		
	}
	
	public boolean hasElement(Integer e){
		//Primero pregunto si el valor que ingresa es igual al valor del arbol en el que estoy parado.
			if(this.value.equals(e)){
				return true;
			}else{
				//Si no, pregutno si es mayor o menor al valor del arbol para saber por que rama buscar, si es menor izq si es mayor derecha
				if(this.value < e){
					this.right.hasElement(e);
				}
				if(this.value> e){
					this.left.hasElement(e);
				}
			}
		return false;
		
	}

	public boolean isEmpty(){
		//para saber si el arbol esta vacio, me basta con preguntar por el valor de su raiz.
		return this.getRoot()!= null;
	}
	
	public int getHeight(){
		int heightLeft =0;
		int heightRight= 0;
		//para cada rama de un arbol, primero consutlto que no sea nullo para pode pedirle su propia altura
		// la raiz no se cuenta, se cuentan los niveles...
		if(this.right!= null){
			heightRight = this.right.getHeight()+1;
		}
		if(this.left != null){
			heightLeft = this.left.getHeight()+1;
		}
		if(heightRight > heightLeft){
			return heightRight;
		}
		if(heightRight < heightLeft){
			return heightLeft;
		}
		return 0;
		
		
	}
	//Rama mas larga del arbol
	public ArrayList<Integer> getLongestBranch(){
		//Dos listas para comparar ramas derecha e izquierda y una para retornar la mas larga
		ArrayList<Integer> finalList = new ArrayList<>();
		ArrayList<Integer> listLeft = new ArrayList<>();
		ArrayList<Integer> listRight = new ArrayList<>();
		//Si la rama izq no es nula, la agrego a la lista izq y recursivamente le pido su rama mas larga
		if(this.left !=null){
			listLeft.add(this.value);
			listLeft.addAll(this.left.getLongestBranch());
		}
		//Lo mismo que en la rama izq
		if(this.right !=null){
				listRight.add(this.value);
				listRight.addAll(this.right.getLongestBranch());
		}	 
		//Si sus ramas izq y der son nullas, es una hoja, entonces agregamos ese valor en ambas listas
		if(this.left == null && this.right== null){
			listLeft.add(this.value);
			listRight.add(this.value);
		}
		//Elijo la mas larga y la agrego en la lista a retornar
		if(listLeft.size()< listRight.size()){
			finalList.addAll(listRight);
		}else{
			finalList.addAll(listLeft);
		}
	return finalList;
	}
	
	//Devolvemos una lista con las hojas del arbol, es decir los que no tienen hijos, ni en izq ni der
	public ArrayList<Integer> getFrontera(){
		ArrayList<Integer> frontera = new ArrayList<>();
		//si izq no es nulla, le pido a mi izq que me devuelva su frontera almacenandola en la lista.
			if(this.left != null){
				frontera.addAll(this.left.getFrontera())	;
			}
			//lo mismo que en izq
			if(this.right!= null){
				frontera.addAll(this.right.getFrontera());
			}
			//cuando encontramos la hoja, guardamos su valor en la lista para retornar
			if(this.left== null && this.right== null){
				frontera.add(this.value);
			}
			
		return frontera;
	}
	//Al ser un ABB, todo valor mayor va a estar a la derecha, entonces buscamos el elemento mas a la derecha que encontremos
	public Integer getMaxElem(){
		Integer max = null;
		if(this.right!= null){
			max= this.right.getMaxElem();
		}
		if (this.right== null){
			max = this.value;
		}
		return max;
	}
	//En este metedo, necesitamos una variable que nos diga en que 
	//nivel del arbol estamos para comparar con el que nos llega por parameto
	public ArrayList<Integer> getElemAtLevel(int a, int cursor){
		ArrayList<Integer> levelList = new ArrayList<>();
		//Aca si encontramos el nivel solicitado, el valor se agrega a la lista.
		if(cursor == a){
			levelList.add(this.value);
		}if(this.left != null){
			levelList.addAll(this.left.getElemAtLevel(a, cursor +1));
			
		}
		if(this.right != null){
			levelList.addAll(this.right.getElemAtLevel(a, cursor +1));
			
		}
		
		return levelList;
	}
	
	//Metodo para sumar todos los elementos de un arbol
	public Integer getSuma(Tree t){
		Integer suma = 0;
		if(this.left != null){
			suma+=(this.left.getSuma(t));
		}
		if(this.right!= null){
			suma+=(this.right.getSuma(t));
		}
		suma += this.value;
		
		return suma;
		
	}
	//Metodo que nos retorna una lista con el valor de los elementos "hoja"
	// que son mayores al valor que nos llega por parametro.
	public ArrayList<Integer> getElemGreaterThan(Tree t, int i){
		ArrayList<Integer> result = new ArrayList<>();
		
		if(this.left != null){
			result.addAll(this.left.getElemGreaterThan(t, i));
			
		}
		if(this.right != null){
			result.addAll(this.right.getElemGreaterThan(t, i));
			
		}// Debe ser hoja para incluirse a la lista
		if(this.left == null && this.right == null && this.value > i){
			result.add(this.value);
		}
		return result;
	}
	
	
	//En este metodo tendremos 3 casos
		/*
		 * Caso 1: Eliminar un arbol sin hijos(Hoja)
		 * Caso 2: Eliminar un arbol con un solo hijo
		 * Caso 3: Eliminar un arbol con 2 hijos%
		 */
		public boolean delete(Integer	toDelete, Tree father){
			if(toDelete > this.value){
				if(this.right!= null){
					this.right.delete(toDelete, this);
				}else {
					return false;
				}
			}else if(toDelete < this.value){
				if(this.left!= null){
					this.left.delete(toDelete,this);
				}else{
					return false;
				}
			}
			//Si encontramos el valor...
			else{
			//Caso 1
				if(this.right == null && this.left == null){
					this.value = null;
					return true;
				}
				//Caso 2
				//Aca vamos a necesitar al padre
				//Si tiene solo el hijo izq
				else if(this.left!= null && this.right== null){
//					Debo saber en que ramam padre estoy
						if(father == null){ //En el caso de que quiera borrar la raiz, esta bien usar right.left??
							this.value = this.left.value;
							this.right = this.left.right;
							this.left = this.left.left;
						}else if(father.value < this.value){
							father.right = this.left;
							this.value = null;
							return true;
						}else{
						//Si valor padre es mayor, el elemento a borrar esta a la izq del padre
							father.left = this.left;
							this.value = null;
							return true;
					}
				}
//				Si tiene solo el hijo der
				else if(this.right!= null && this.left== null){
//				 Si valor padre es menor, el elemento a borrar esta a la derecha del padre
						if(father == null){
							this.value = this.right.value;
							this.left = this.right.left;
							this.right = this.right.right;
						}else if(father.value < this.value){
							father.right= this.right;
							this.value = null;
							return true;
						}else{ //Si valor padre es mayor, el elemento a borrar esta a la izq del padre
							father.left = this.left;
							this.value = null;
							return true;
						}	
				}//Caso 3 tiene dos hijos
				else{ 
					Tree aux = this.right.getNMI();
					this.value = aux.value;
					this.right.delete(aux.value, this);
					return true;
				}
			}
			return true;
		}

		
//		Este metodo deberia retornar una copia? o con que sea privado basta para que no rompa encapsulamiento?
		public Tree getNMI(){
			Tree toReturn = this;
			if(toReturn.left != null){
				return toReturn.left.getNMI();
			} else return toReturn;
		}
}