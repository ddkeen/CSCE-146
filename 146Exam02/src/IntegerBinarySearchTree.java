
/*
 *David Keen
 *CSCE 146H
 *EXAM 02 QUESTION 02
 */
public class IntegerBinarySearchTree 
{
	//Do not alter---------------------
	public class Node//This is public for testing purposes
	{
		public int data;
		public Node leftChild;
		public Node rightChild;
		public Node(int aData)
		{
			this.data = aData;
		}
	}
	private Node root;
	public IntegerBinarySearchTree()
	{
		root = null;
	}
	public Node getRoot()
	{
		return root;
	}
	//--------------------------------
	
	
	public void add(int aData)
	{
		//Write your code here
		if(root == null)
			root = new Node(aData);
		else
			add(root,aData);
	}
	private Node add(Node aNode, int aData) 
	{
		if(aNode == null) 
			aNode = new Node(aData);
		else if(aData < aNode.data) 
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData > aNode.data)
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode; 
	}

}