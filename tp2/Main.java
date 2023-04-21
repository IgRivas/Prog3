package tp2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Tree t1 = new Tree(6);
//t1.add(6);
//t1.add(3);
t1.add(3);
t1.add(2);
t1.add(4);
t1.add(1);
t1.add(8);
t1.add(7);
//t1.add(17);
//t1.add(20);

System.out.println("PreOrder");
t1.imprimirPreOrden();
System.out.println("borrado");
t1.delete(2, null);
t1.imprimirPreOrden();
//
//System.out.println("PostOrder");
//t1.imprimirPostOrder();
//
//System.out.println("InOrder");
//t1.imprimirInOrder();
//
//System.out.println(t1.getLongestBranch());
//System.out.println(t1.getElemGreaterThan(t1, 2));
	}
}