import GenericBinarySearchTree.Node;

public class BinarySearchTree <T extends Comparable<T>>
{ 
	private class Node
	{
		private T data;
		private Node leftChild;//Less than 
		private Node rightChild;//Greater than 
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null; 
		}
	}
	private Node root;
	public BinarySearchTree() 
	{
		root = null; 
	}
	public void add(T aData) 
	{
		if(root == null)
			root = new Node(aData);
		else
			add(root,aData);
	}
	private Node add(Node aNode, T aData) 
	{
		if(aNode == null)//Found a leaf 
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)//GO left 
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//GO Right 
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode; }
	private void printPostOrder(Node aNode)
	{
		if(aNode ==null)
			return;
		printInOrder(aNode.leftChild);
		printInOrder(aNode.rightChild);
		System.out.println(aNode.data);
	}
	public void printPostOrder()
	{
		printPostOrder(root);
	}
	public void printPreOrder() 
	{
       printPreOrder(root);
    }
	private void printPreOrder(Node aNode) 
	{
		if(aNode == null) 
			return;
	System.out.println(aNode.data);//Process 
	printPreOrder(aNode.leftChild);//GO left 
	printPreOrder(aNode.rightChild);//GO right
	}
	public void printInOrder() 
	{
		printInOrder(root);
	}
	private void printInOrder(Node aNode) 
	{
		if(aNode == null) 
			return;
		printInOrder(aNode.leftChild); 
		System.out.println(aNode.data);
		printInOrder(aNode.rightChild); 
	}
	public boolean search(T aData) 
	{
		return recursiveSearch(root,aData); 
	}
	private boolean recursiveSearch(Node aNode, T aData) 
	{
		if(aNode == null)
			return false;
		if(aNode.data.compareTo(aData) == 0) 
			return true;
		else if(aData.compareTo(aNode.data)< 0)
			return recursiveSearch(aNode.leftChild,aData);
		else
			return recursiveSearch(aNode.rightChild,aData);
	}	
	public void remove(T aData) 
	{
		root = remove(root,aData); 
	}
	private Node remove(Node aNode, T aData) 
	{
		if(aNode == null)
			return null;
		if(aData.compareTo(aNode.data)<0)
			aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0) 
			aNode.rightChild = remove(aNode.rightChild,aData);
		else
		{
			if(aNode.rightChild == null)
				return aNode.leftChild; 
			if(aNode.leftChild == null)
				return aNode.rightChild;
		Node temp = findMinInTree(aNode.rightChild); 
		aNode.data = temp.data;
		aNode.rightChild = remove(aNode.rightChild,temp.data);
		}
		return aNode;
	}
	private Node findMinInTree(Node aNode) 
	{
		if(aNode == null) 
			return null;
		if(aNode.leftChild == null) 
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
}



