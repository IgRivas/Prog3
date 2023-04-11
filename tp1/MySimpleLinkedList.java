package tp1;

import java.util.Comparator;

public class MySimpleLinkedList<T>  implements Iterable<T>{
	
	private Node<T> first;
	private int size;
	private Comparator<T> comparador;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size =0;
		
	}
	
	public MySimpleLinkedList(Comparator<T> comparador) {
		this.first = null;
		this.size =0;
		this.comparador= comparador;
	}
	
	public void insertFront(T info) { // first se vuelve el siguiente del nodo temporal y el nodo temporal se vuelve first.
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size ++;
	}
	
	public T extractFront() {	//Si la lista no esta vacia, guardo el valor del ultimo agregado para poder eliminarlo y luego retornarlo.
		if(!this.isEmpty()){
			T aux = this.first.getInfo();
			if(this.first.getNext()!= null){
				this.first= this.first.getNext();
			}
			this.size--;
			return aux;
		}
		return null;
	}

	public boolean isEmpty() {
		// TODO
		return(this.first == null);
	}
	
	public T get(int index) {//si la lista no esta vacia, recorro la lista hasta que encuentro la posicion y retorno su valor.
		if(!isEmpty()){
			int aux = 0;
			Node<T> temp = this.first;
			while(aux < index){
				if(temp.getNext()!= null){
					temp = temp.getNext();
					aux++;
				}
			}
		return temp.getInfo();
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		if(!isEmpty()){
			Node<T> temp =this.first;
			String result = "";
			while(temp!=null){
				result+= temp.toString();
				temp = temp.getNext();
				
			}
			return result;
		}
		return null;
	}
	
	
	
	    public int indexOf(T element) {//recorro los nodos de la lista y comparo su valor, cuando coinciden retorno su pos
	        int index = 0;
	        Node<T> temp = this.first;
	        while (temp != null) {
	            if (temp.getInfo().equals(element)) {
	                return index;
	            }
	            temp = temp.getNext();
	            index++;
	        }
	        return -1;
	    }
	    
	    @Override
		public Iterador<T> iterator() {
			Iterador<T> i = new Iterador<T>(this.first); 
			return i;
		}
	    
	    public MySimpleLinkedList<T> listaDeComunes(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2){
			MySimpleLinkedList<T> aux =  new MySimpleLinkedList<T>();
			if(!lista1.isEmpty()&& !lista2.isEmpty()){
				Iterador<T> i1 = lista1.iterator();
				Iterador<T> i2 = lista2.iterator();
				while(i1.hasNext()&& i2.hasNext()){
					if(comparador.compare(i1.getElemento(),i2.getElemento())< 1 ){
						i1.next();
					}
					if(comparador.compare(i2.getElemento(),i1.getElemento())< 1 ){
						i2.next();
					}
					if(comparador.compare(i1.getElemento(),i2.getElemento())== 0){
						aux.insertOrdenado(i1.getElemento());
						i1.next();
						i2.next();
					}
						
				}
				
			}
			
			
	    	return aux;
	    }
	 
	    public void insertOrdenado(T info) {
	        // Crea un nuevo nodo con la información que se desea insertar
	        Node<T> entrada = new Node<T>(info, null);

	        // Si la lista está vacía, convierte el nuevo nodo en la cabeza de la lista
	        if (this.isEmpty()) {
	            this.first = entrada;
	            this.size++;
	            return;
	        }

	        // Si la lista no está vacía, busca el lugar donde debe insertar el nuevo nodo
	        if (this.comparador.compare(this.first.getInfo(), entrada.getInfo()) > 0) {
	            // Si la información del primer nodo es mayor que la información del nuevo nodo, convierte el nuevo nodo en la nueva cabeza de la lista
	            entrada.setNext(first);
	            this.first = entrada;
	            return;
	        }
	        Node<T> aux = this.first;
	        boolean agregado = false;
	        while (agregado == false && aux.getNext() != null) {
	            if (this.comparador.compare(aux.getNext().getInfo(), entrada.getInfo()) > 0) {
	                // Si la información del siguiente nodo es mayor que la información del nuevo nodo, inserta el nuevo nodo antes del siguiente nodo
	                Node<T> tmp = aux.getNext();
	                aux.setNext(entrada);
	                entrada.setNext(tmp);
	                agregado = true;
	                this.size++;
	            }
	            aux = aux.getNext();
	        }
	        if (!agregado) {
	            // Si se recorre toda la lista sin encontrar un lugar donde insertar el nuevo nodo, inserta el nuevo nodo al final de la lista
	            aux.setNext(entrada);
	        }
	    }


}
