/*
 * David Keen
 * 4/1/20
 * CSCE 146H
 * Lab 07 Fruit Tree
 */
public class GenericBinarySearchTree <T extends Comparable <T>>{
	//private internal class for our child Nodes
	private class Node
	{
		private Node leftChild;
		private Node rightChild;
		private T data;
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;
	public GenericBinarySearchTree()
	{
		root = null;
	}
	//add an element in a leaf
	public void add(T aData) 
	{
		//create root if null
		if(root == null)
			root = new Node(aData);
		//add starting at this new root
		else
			add(root,aData);
	}
	private Node add(Node aNode, T aData) 
	{
		if(aNode == null)//Found a leaf 
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)//GO left and recursivly call 
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//GO Right and recursivly call
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode; 
	}
	public void remove(T aData) 
	{
		//remove starting at the root
		root = remove(root,aData); 
	}
	private Node remove(Node aNode, T aData) 
	{
		//if null, we have reach a lead and haven't found our element we want to remove
		if(aNode == null)
			return null;
		//go left and recurvsivly call if less then
		if(aData.compareTo(aNode.data)<0)
			aNode.leftChild = remove(aNode.leftChild,aData);
		//go left and recursivily call if greater then
		else if(aData.compareTo(aNode.data)>0) 
			aNode.rightChild = remove(aNode.rightChild,aData);
		//if equal, find lowest element in right subtree and replace
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
	//just keep going left
	private Node findMinInTree(Node aNode) 
	{
		if(aNode == null) 
			return null;
		if(aNode.leftChild == null) 
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	public boolean search(T aData) 
	{
		//start at the root
		return recursiveSearch(root,aData); 
	}
	private boolean recursiveSearch(Node aNode, T aData) 
	{
		//reached a leaf and not founf
		if(aNode == null)
			return false;
		//we have found the element if equal
		if(aNode.data.compareTo(aData) == 0) 
			return true;
		else if(aData.compareTo(aNode.data)< 0)
			return recursiveSearch(aNode.leftChild,aData);
		else
			return recursiveSearch(aNode.rightChild,aData);
	}	
	public void printPreOrder() 
	{
       printPreOrder(root);
    }
	//prints the parent, then goes left, then goes right 
	private void printPreOrder(Node aNode) 
	{
		if(aNode == null) 
			return;
	
	System.out.println(aNode.data);//Process 
	printPreOrder(aNode.leftChild);//GO left 
	printPreOrder(aNode.rightChild);//GO right
	}
	//goes left, prints the parent, then goes right
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
	public void printPostOrder()
	{
		printPostOrder(root);
	}
	//goes left, goes right, then prints the parent
	private void printPostOrder(Node aNode)
	{
		if(aNode ==null)
			return;
		printInOrder(aNode.leftChild);
		printInOrder(aNode.rightChild);
		System.out.println(aNode.data);
	}
	

}
