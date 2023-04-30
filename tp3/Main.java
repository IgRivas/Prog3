package tp3;



public class Main {
	public static void main(String[]args) {
		GrafoDirigido gd1 = new GrafoDirigido();
		
		gd1.agregarVertice(1);
		gd1.agregarVertice(2);
		gd1.agregarVertice(3);
		gd1.agregarVertice(4);
		gd1.agregarVertice(3);
		System.out.println(gd1.cantidadVertices());
		gd1.agregarArco(1, 2, "uno a dos");
		gd1.agregarArco(1, 3, "uno a tres");
		gd1.agregarArco(3, 2, "tres a dos");
		System.out.println(	gd1.obtenerArco(3,2));
		System.out.println(gd1.cantidadArcos());
		
}
}
