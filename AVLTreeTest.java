
																																													//Cesar Garcia
																																												   //Project 3
																																												  // 10/23/14


public class AVLTreeTest {
	 public static void main(String[] args)
	   {
	      AVLTree<Integer> tree = new AVLTree();
	      int [] tenint = { 20,500,50,60,35,45,200,-15,25,20};
	      for(int k = 0; k < tenint.length; k++)
	            tree.insert(tenint[k]);
	      
	      System.out.println("Tree is height balanced?  " + tree.isHeightBalanced() );
	      System.out.println("Max Tree height " + tree.height());
	      System.out.println("Number of Nodes " + tree.size());
	      tree.printInorder();
	      tree.printPreorder();
	      
	      System.out.println("Is 500 in tree? "+ tree.search(500));
	      System.out.println("Is 20 in tree? "+ tree.search(20));
	      System.out.println("Is 22 in tree? "+ tree.search(22));
	      System.out.println("Is 25 in tree? "+ tree.search(25));
	      System.out.println("Tree is height balanced?  " + tree.isHeightBalanced() );
	      tree.delete(500);
	      tree.delete(50);
	      tree.delete(60);
	      tree.delete(22);
	      System.out.println("Tree is height balanced?  " + tree.isHeightBalanced() );
	      System.out.println("Max Tree height " + tree.height());
	      System.out.println("Number of Nodes " + tree.size());
	      tree.printInorder();
	      tree.printPreorder();
	      tree.delete(20);    
	      tree.delete(35);     
	      tree.delete(45);
	      tree.delete(200);
	      tree.delete(-15);
	      tree.delete(25);
	      tree.delete(20);
	      System.out.println("Is the tree Empty? "+ tree.isEmpty());
	      AVLTree tree2 = new AVLTree();
	      int n = 1000;
	      for( int k = 0; k < n; k++)
	         tree2.insert(  (int) (Math.random() * 100) );
	      System.out.println("Tree is height balanced?  " + tree.isHeightBalanced() );
	      System.out.println("Max Tree height " + tree.height());
	      System.out.println("Number of Nodes " + tree.size());
	   }
}
