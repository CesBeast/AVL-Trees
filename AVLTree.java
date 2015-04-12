

																																													//Cesar Garcia
	class AVLNode<E extends Comparable<E> >   //non-public class
	{   private  E  item;
	    private AVLNode<E>  parent;
	    private AVLNode<E>  left;   //leftChild
	   private AVLNode<E>  right;  ///rightChild
	   public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
	public AVLNode<E> getParent() {
		return parent;
	}
	public void setParent(AVLNode<E> parent) {
		this.parent = parent;
	}
	public AVLNode<E> getLeft() {
		return left;
	}
	public void setLeft(AVLNode<E> left) {
		this.left = left;
	}
	public AVLNode<E> getRight() {
		return right;
	}
	public void setRight(AVLNode<E> right) {
		this.right = right;
	}
	private int height;  //Optional. Add setter and getter if you use this
	   public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public AVLNode ( E item) {
		
	}  //constructor that sets left, right and parent to null
	   public AVLNode(E item,AVLNode<E> p, AVLNode<E> lft, AVLNode<E> rt ) {
		   item.toString();
	   }
	/* Add public setters and getters for item, parent, leftChild and rightChild and 
	   Add a toString()  that returns a string with item in it.  */
	}

	public  class AVLTree<E extends Comparable<E> >
	{
    private  AVLNode<E> root;
     int sizeValue=0;
/* ---------  public methods  ------*/
   public AVLTree( )  {  
	   root= new AVLNode(null);
   }
  public boolean isEmpty(){
	  if(sizeValue==0)
			 return true;
		 else
			 return false;    }
   public int size () {
	return sizeValue;  
	}    // number of nodes 
  public int height()  {
	  if(root!=null)
	return root.getHeight();  //return height from root
	  else return 0;
	}   
  public boolean search (E item)   {
	  AVLNode<E> tempNode3=root;
	  AVLNode<E> fixNode = new AVLNode(null);
	  fixNode.setItem(item);

		 int loop=0;
		 while(loop==0){
		 if((fixNode.getItem().compareTo(tempNode3.getItem()))==1){//greater
			 tempNode3=tempNode3.getRight();
			
			 
			 if(tempNode3==null){
				 return false;
			 }
		 }
			 if((fixNode.getItem().compareTo(tempNode3.getItem()))==0){//equal
				 return true;
			 }
		 
		 if((fixNode.getItem().compareTo(tempNode3.getItem()))==-1){//less
			 tempNode3=tempNode3.getLeft();
			 
			 if(tempNode3==null){
				 return false;
			 	}
		 	}
		 }

		 
	return false;  }
   public void insert ( E  item ) {  
	   if(sizeValue==0){
		   root.setHeight(1);
		   root.setItem(item);
	   }
	   else findSpot(item);
	   sizeValue++;
   }   //Duplicates ok
   public boolean delete (E  item ){
	   int loop=0;
	   if(root==null)
		   return false;
	     AVLNode<E> tempNode=root;
	     AVLNode<E> pNode=null;
		 AVLNode<E> fixNode = new AVLNode(null);
		 AVLNode<E> LMS = new AVLNode(null);
		 int rightcount=0;
		 fixNode.setItem(item);
		 
		while(loop==0){
		 if((fixNode.getItem().compareTo(tempNode.getItem()))==1){//greater
			 tempNode=tempNode.getRight();
			 if(tempNode==null)
				 return false;
		 }
		 else if((fixNode.getItem().compareTo(tempNode.getItem()))==-1){//less
			 tempNode=tempNode.getLeft();
			 if(tempNode==null)
				 return false;
		 }
		 else if((fixNode.getItem().compareTo(tempNode.getItem()))==0){
			 pNode=LMS;
			 LMS=tempNode.getRight();
			 //check if root is being passed in
			 if(LMS==null&&tempNode.getLeft()==null&&tempNode.getParent()==null&&tempNode.getItem().equals(item)){
				 root=null;
				 sizeValue--;
				 return true;
			 }
			 if(LMS==null&&tempNode.getLeft()==null){//if last node in tree
				 	 pNode=tempNode.getParent();
					 if(tempNode.getParent().getRight()==(tempNode))
					 tempNode.getParent().setRight(null);
					 else tempNode.getParent().setLeft(null);
					 triNodeFixHeight(root);
					 checkStruct(pNode);
					 sizeValue--;
				 return true;				 
				 }
				 break;
			 }
		}
			 rightcount++;
			 if(LMS!=null){
			 while(LMS.getLeft()!=null){
				 pNode=LMS;
				 LMS=LMS.getLeft();
				 rightcount=0;
				 }
			 
			 }

				 
			 if(LMS==null&&tempNode.getLeft()!=null){
				 pNode=LMS;
				 LMS=tempNode.getLeft();
				 rightcount=0;
			 }
			 tempNode.setItem(LMS.getItem());
			 if(rightcount==1){//LMS is right node
				 pNode=tempNode;
				 if(LMS.getRight()!=null){	 
				 tempNode.setRight(LMS.getRight());
				 LMS.getRight().setParent(tempNode);
				 LMS.setParent(null);
				 }
				 else{
					 LMS.setParent(null);
					 tempNode.setRight(null);
				 }
			 }
			 else	 {
			if(LMS.getRight()==null)
				LMS.getParent().setLeft(null);
			else{
				LMS.getParent().setLeft(LMS.getRight());
				LMS.getRight().setParent(LMS.getParent());
			}
			}
			 
			 triNodeFixHeight(root);
			 checkStruct(pNode);
			
			
			 //checks left of node for missing unbalanced tree
			 //when iserting duplicates
			 LMS.setParent(null);
			 triNodeFixHeight(root);
			 sizeValue--;
			 return true;
		 
		
	}
   
  public boolean isHeightBalanced() {
	  return heightBalanced(root);
  }
 private boolean heightBalanced(AVLNode<E> root2) {
	 AVLNode<E> heightNode=root2;
	  if(heightNode==null)
		  return true;
	  else{

		int left,right;
		if(heightNode.getLeft()==null)
			left=0;
		else
			left=heightNode.getLeft().getHeight();
		if(heightNode.getRight()==null)
			right=0;
		else
		  right=heightNode.getRight().getHeight();
		  if ( Math.abs( left-right) > 1 )
			  return false;
		  else
			  return (heightBalanced(heightNode.getLeft())&&heightBalanced(heightNode.getRight()));
		  }
	  }

public void printPreorder() { 
	if(root==null)
		System.out.println("Empty Tree");
	else{
	preOrderPrint(root);
	System.out.println("");}
}
 private void preOrderPrint(AVLNode<E> rootnode1) {
	 AVLNode<E> verNode1=rootnode1;
		if(verNode1!=null){
			
			System.out.print(verNode1.getItem()+" ");
			preOrderPrint(verNode1.getLeft());
			preOrderPrint(verNode1.getRight());
		}
		
	}
	

public void printInorder() {  
	if(root==null)
		System.out.println("Empty Tree");
	else{
	 inOrderPrint(root);
	 System.out.println("");}
 } 
 
 private void inOrderPrint(AVLNode<E> rootnode) {
	 AVLNode<E> verNode=rootnode;
	if(verNode!=null){
		inOrderPrint(verNode.getLeft());
		System.out.print(verNode.getItem()+" ");
		inOrderPrint(verNode.getRight());
	}
	
}

public void findSpot(E item){
	 AVLNode<E> tempNode=root;
	 AVLNode<E> fixNode = new AVLNode(null);
	 AVLNode<E> changeNode = new AVLNode(null);
	 fixNode.setItem(item);

	 int loop=0;
	 while(loop==0){
	 if((fixNode.getItem().compareTo(tempNode.getItem()))==1){//greater
		 changeNode=tempNode;
		 tempNode=tempNode.getRight();
		
		 
		 if(tempNode==null){
			 
			 tempNode=new AVLNode(null);
			 tempNode.setItem(item);
			 tempNode.setParent(changeNode);
			 changeNode.setRight(tempNode);
			
			 triNodeFixHeight(root);
			 checkStruct(tempNode);
			 break;
		 }
	 }
	 else if((fixNode.getItem().compareTo(tempNode.getItem()))==0){//equal
			 if(tempNode.getRight()==null){
			 fixNode.setParent(tempNode);
			 tempNode.setRight(fixNode);
			 }
			 else{
				 tempNode.getRight().setParent(fixNode);
				 fixNode.setRight(tempNode.getRight());
				 tempNode.setRight(fixNode);
				 fixNode.setParent(tempNode);
			 }
			 triNodeFixHeight(root);
			 checkStruct(fixNode);
			 if(tempNode.getLeft()!=null)
				 checkStruct(tempNode.getLeft());
			
			
//			 AVLNode<E> checkNode=fixNode;
//			 if(checkNode.getRight()!=null){
//				 checkNode=checkNode.getRight();
//				 if(checkNode.getRight()!=null)
//					 checkStruct(fixNode.getRight());
//				 else
//					 checkStruct(fixNode);
//				 }
			 
			 break;
		 }
	 
	 else if((fixNode.getItem().compareTo(tempNode.getItem()))==-1){//less
		 changeNode=tempNode;
		 tempNode=tempNode.getLeft();
		 
		 if(tempNode==null){
			 tempNode=new AVLNode(null);
			 tempNode.setItem(item);
			changeNode.setLeft(tempNode);
			 tempNode.setParent(changeNode);
			 triNodeFixHeight(root);
			 checkStruct(tempNode);
			 break;
		 	}
	 	}
	 }

	 
 }
 public void checkStruct(AVLNode<E> Node){
	 AVLNode<E> checkNode=Node;
	 AVLNode<E> trailNode=null;
	 AVLNode<E> xNode=null;
	 AVLNode<E> returnNode=null;
	 int resultA,resultB,result;
	 while(checkNode!=null){
		 returnNode=null;
	 if(checkNode.getLeft()==null)
		 resultA = 0;
	 else resultA=rheight(checkNode.getLeft())+1;
	 if(checkNode.getRight()==null)
		 resultB = 0;
	 else resultB=rheight(checkNode.getRight())+1;
	 result=resultA-resultB;
	 
	 
	 if(Math.abs(result)>1){  //unbalanced
		 //find Y Node
		 if(checkNode.getLeft()==null)
			 resultA = 0;
		 else resultA=rheight(checkNode.getLeft())+1;
		 if(checkNode.getRight()==null)
			 resultB = 0;
		 else resultB=rheight(checkNode.getRight())+1;
		 if(resultA>resultB)
			 trailNode=checkNode.getLeft();
		 else
			 trailNode=checkNode.getRight();
		 // End Find Y Node
		 
		 //Find X Node
		 if(trailNode.getLeft()==null)
			 resultA = 0;
		 else resultA=rheight(trailNode.getLeft())+1;
		 if(trailNode.getRight()==null)
			 resultB = 0;
		 else resultB=rheight(trailNode.getRight())+1;
		 if(resultA>resultB){
			 xNode=trailNode.getLeft();
			 xNode.setParent(trailNode);
		 }
		 if(resultB>resultA)
			 xNode=trailNode.getRight();
		 if(resultA==resultB){
			if(trailNode.getParent().getRight()!=null){
				 if(trailNode.getParent().getRight()==trailNode){
					 xNode=trailNode.getRight();
					 xNode.setParent(trailNode);
				 }
			}
			else {
				xNode=trailNode.getLeft();
				xNode.setParent(trailNode);
			}
		 }
		 
		 // End Find X Node
		 if(xNode!=null)
			 returnNode=triNodeRestructure(xNode);
		 triNodeFixHeight(root);
		 }
	 if(returnNode==null)
		 checkNode=checkNode.getParent();
	 else
	 checkNode=returnNode.getParent();
	 
	 
	 
	 }
	
 }
 
private void triNodeFixHeight(AVLNode<E> xNode) {
	 AVLNode<E> verNode=xNode;
		if(verNode!=null){
			triNodeFixHeight(verNode.getLeft());
			verNode.setHeight(rheight(verNode)+1);
			triNodeFixHeight(verNode.getRight());
		}
		
	
}
private void fixHeight(AVLNode<E> tempNode) {
	 if(tempNode.getRight()==null&&tempNode.getLeft()==null){
		int i=1;
		tempNode.setHeight(i);
		while(tempNode!=root){
			i++;
			if(tempNode.getParent().getHeight()<i){
			tempNode=tempNode.getParent();
			tempNode.setHeight(i);
			}
			else
				break;
		}
	 }
	 else{
		 tempNode.setHeight(tempNode.getParent().getHeight()-1);
		 while(tempNode!=null){
		 if(tempNode.getRight().getHeight()==tempNode.getHeight()||tempNode.getLeft().getHeight()==tempNode.getHeight()){
			 tempNode.setHeight(tempNode.getHeight()+1);
			 if(tempNode.getParent()!=null)
				 tempNode.getParent().setHeight(tempNode.getParent().getHeight()+1);
		 }
		 checkStruct(tempNode);//fix tree if not height balance after height is fixed.
		 if(tempNode.getParent().getParent()==null)
			 break;
		 else
			 tempNode=tempNode.getParent().getParent();
	 }
	 }
}
/* --------- Private Methods ---*/
 private int rheight( AVLNode<E>  t  ) {
	 int leftheight,rightheight;//returns height of node
	 if(t==null)
		 return -1;
	  leftheight = rheight(t.getLeft());
	  rightheight =rheight(t.getRight());

	    if(leftheight > rightheight)
	        return leftheight + 1;
	    else
	        return rightheight +1;
	        		
	} 
 private AVLNode<E> triNodeRestructure(AVLNode<E> x)
 {
 
    AVLNode<E> y = x.getParent();
    AVLNode<E> z = x.getParent().getParent();
    AVLNode<E> ggparent = z.getParent();  //may be null
    
    AVLNode<E> a,b,c;
   AVLNode<E> t1,t2, t3, t4;
  
       
    if( x == y.getLeft() && y == z.getLeft())
    {  
         //x is left of y and y is left  of z 
       a =x; b = y; c =z;
       t1 = x.getLeft();
       t2 =  x.getRight();
       t3 = y.getRight();
       t4 = z.getRight();
          
    }
    else if( x==y.getRight() && y == z.getLeft())
    {
       //x right of y and y left of z
       a = y; b =x; c = z;
       t1 = y.getLeft();
       t2 = x.getLeft();
       t3 = x.getRight();
       t4 = z.getRight();
          
    }
    else if(x == y.getRight() && y == z.getRight())
    {
       
       //x right of y and y right of z
       a=z; b=y; c=x;
       t1 = z.getLeft(); 
       t2 = y.getLeft();
       t3 = x.getLeft();
       t4 = x.getRight();
          
          
    }
    else if (x == y.getLeft() && y == z.getRight())
    {
       //x left of y and y right of z
       a =z; b = x; c = y;
       t1 = z.getLeft();
      t2 = x.getLeft();
       t3 = x.getRight();
       t4 = y.getRight();
    }
    else  //should not get here
    {
       a = b = c = null;
       t1 = t2 =t3 = t4 = null;
    }
         
    if(ggparent == null)
    {
       root = b;
       b.setParent(null);
    }
    else if(z == ggparent.getLeft())
    {
      ggparent.setLeft(b);
       b.setParent(ggparent);
    }
    else
    {
       ggparent.setRight(b);
       b.setParent(ggparent);
    }
 
    b.setLeft(a);
    a.setParent(b);
    b.setRight(c);
    c.setParent(b);
    a.setLeft(t1);
    if ( t1 != null)
       t1.setParent(a);
    a.setRight(t2);
    if (t2!= null)
       t2.setParent(a);
    c.setLeft( t3);
    if ( t3 != null)
       t3.setParent(c);
    c.setRight(t4);
    if ( t4 != null)
       t4.setParent(c);
                 
    return b;
 }// triNodeRestructure
}
