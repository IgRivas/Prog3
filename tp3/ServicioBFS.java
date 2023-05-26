package tp3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class ServicioBFS {
	private HashMap<Integer, Boolean> visitados;
	private Queue<Integer>cola;
	
	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitados = new HashMap<>();
		this.cola = new LinkedList<>();
	}
	
	public List<Integer> bfsForest() {
		ArrayList<Integer>toReturn = new ArrayList<>();
		//vacio la fila
		this.cola.clear();

		Iterator<Integer> iterador = grafo.obtenerVertices();
		Iterator<Integer> iterador2 = grafo.obtenerVertices();
		
		//marco todos los vertices como no visitados
		while(iterador.hasNext()){
			this.visitados.put(iterador.next(), false);
		}
		//Mientras haya un siguiente
		while(iterador2.hasNext()) {
			int vertice = iterador2.next();
			//Asigno el valor v/f del vertice y si es falso, llamo a BFS con esa clave
			Boolean i = this.visitados.get(vertice);
			if(i.equals(false)) {
				BFS(vertice);
			}
			//Una vez que pasaron todos, los agrego a la lista a retornar
			toReturn.add(vertice);
		}
		
		return toReturn;
	}

	private void BFS(int vertice) {
		//Al hacer put con una clave existente, se modifica el valor. En este caso lo cambiamos a true.
		this.visitados.put(vertice, true);
		
		this.cola.add(vertice);
		//Mientras la cola no este vacia, retiro el primer elemento y sigo procesando
		while(!this.cola.isEmpty()) {
			this.cola.poll();
			Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(vertice);
			//Obtengo todos los adyacentes del vertice seleccionado y los recorro mientras tenga un siguiente
			while(adyacentes.hasNext()) {
				int ady = adyacentes.next();
				//cada vertice que no este en el map visitados, lo agrego, y lo añado a la cola para que luego sea procesado.
				if(!this.visitados.containsKey(ady)) {
					this.visitados.put(ady,true);
					this.cola.add(ady);
				}
			}
		}
	}
	/*

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> bfsForest() {
		
		HashMap<Integer, Boolean> visitados = new HashMap<>();
		Queue<Integer>cola = new LinkedList<Integer>();
		ArrayList<Integer>toReturn = new ArrayList<>();
		//vacio la fila
		cola.clear();

		Iterator<Integer> iterador = grafo.obtenerVertices();
		
		//marco todos los vertices como no visitados
		while(iterador.hasNext()){
			visitados.put(iterador.next(), false);
		}
		
		for(Integer v: visitados.keySet()) {
			if(!visitados.get(v)) {
				toReturn.addAll(BFS(v, visitados, cola));
			}
		}
		
		return toReturn;
	}

	private ArrayList<Integer> BFS(int vertice, HashMap<Integer,Boolean>visitados, Queue<Integer>cola) {
		ArrayList<Integer>toReturn = new ArrayList<Integer>();
		visitados.put(vertice, true);
		
		cola.add(vertice);
		toReturn.add(vertice);
		while(!cola.isEmpty()) {
			int v = cola.poll();
			
			Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(v);
			while(adyacentes.hasNext()) {
				int ady = adyacentes.next();
				Boolean i = visitados.get(ady);		
				if(i.equals(false)) {
					visitados.put(ady,true);
					cola.add(ady);
					toReturn.add(ady);

				}
			}

		}
		
		return toReturn;
	}
	
}


	 * 
	 */
}