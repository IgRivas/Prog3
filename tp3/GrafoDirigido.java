package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {
	//Cada clave integer hace referencia a un vertice con valor de tipo NodoGrafo.
	//
	private HashMap<Integer, NodoGrafo> vertices;
	private ArrayList<Arco<T>> arcos;
	
	
	public GrafoDirigido(){
	this.vertices = new HashMap<>();
	this.arcos = new ArrayList<>();
	
	}
	//EL verticeId es la clave del HashMap, En este caso creamos el vertice con indice, pero sin valor. 
	//Consultar si podemos cambiar la asignatura del metodo para que reciba el valor del vertice.
	public void agregarVertice(int verticeId) {
		//Chequea si la clave existe en el map
		if(!vertices.containsKey(verticeId)){
			vertices.put(verticeId,new NodoGrafo(verticeId));
			System.out.println("ingresado");
		}else 
			System.out.println("El verticeID "+verticeId+ " ya existe");
		

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
	//
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> nuevo = new Arco<>(verticeId1,verticeId2,etiqueta);
		if(!arcos.contains(nuevo)){
			arcos.add(nuevo);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> aBorrar = null;
	 	for(Arco<T> a : arcos){
	 		if(a.getVerticeDestino()== verticeId2 && a.getVerticeOrigen()== verticeId1){
	 			aBorrar = a;
	 		}
	 	}
	 	if(aBorrar != null){
	 		arcos.remove(aBorrar);
	 	}
	}
	

	@Override
	public boolean contieneVertice(int verticeId) {
		if(vertices.containsKey(verticeId)){
			return true;
		}
		return false;
	}

	@Override
	public boolean existeArco(int origen, int destino) {
		 for(Arco<T> a : arcos){
	 		if(a.getVerticeDestino()== destino && a.getVerticeOrigen()== origen){
	 			return true;
	 		}
	 	}
	 	return false;
	}

	@Override
	public Arco<T> obtenerArco(int origen ,int destino) {
		Arco<T> aRetornar = null;
		for(Arco<T> a: arcos){
			if(a.getVerticeDestino()== destino && a.getVerticeOrigen()== origen){
	 			aRetornar = a;
	 			return aRetornar;
	 			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return arcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		
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