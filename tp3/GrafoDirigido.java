package tp3;

import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	//Cada clave integer hace referencia a un vertice con valor de tipo NodoGrafo.
	//Creo que no es necesario guardar los arcos en el Grafo, si los tenemos en la lista de adyacencia de los vertices.
	private HashMap<Integer, NodoGrafo> vertices;
	
	public GrafoDirigido(){
	this.vertices = new HashMap<>();
	}
	//EL verticeId es la clave del HashMap, En este caso creamos el vertice con indice, pero sin valor. 
	//Consultar si podemos cambiar la asignatura del metodo para que reciba el valor del vertice.
	public void agregarVertice(int verticeId) {
		//Chequea si la clave existe en el map
		if(!vertices.containsKey(verticeId)){
			vertices.put(verticeId,new NodoGrafo());
		}else 
			System.out.println("El vertice ya existe");
		

	}

	@Override
	//Elimina un vertice si es que este existe
	public void borrarVertice(int verticeId) {
		if(vertices.containsKey(verticeId)){	
			vertices.remove(verticeId);
		}
		return;
	}

	@Override
	//Instancio un arco con los vertices y lo agrego a la lista de adyacencia del vertice
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		//vertices.get(verticeId1).addArco(verticeId1,verticeId2,etiqueta;	Delegar al NodoGrafo la creacion del arco?
		Arco<T> arco = new Arco<T>(verticeId1,verticeId2, etiqueta);
		vertices.get(verticeId1).addArco(arco);
		
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		NodoGrafo n1 = vertices.get(verticeId1);
		n1.borrarArco(verticeId1,verticeId2);

	}

	@Override
	public boolean contieneVertice(int verticeId) {
		if(vertices.containsKey(verticeId)){
			return true;
		}
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		NodoGrafo n1 = vertices.get(verticeId1);
		n1.existeArco(verticeId1,verticeId2);
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}