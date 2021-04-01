/*
 * David Keen
 * CSCE 146 H
 * Exam 02 Question 03
 */
public class DoubleBinarySearchTree 
{
	//Do not alter---------------------
	public class Node//This is public for testing purposes
	{
		public double data;
		public Node leftChild;
		public Node rightChild;
		public Node(double aData)
		{
			this.data = aData;
		}
	}
	public Node root;//This is public for testing purposes
	public DoubleBinarySearchTree()
	{
		root = null;
	}
	//---------------------------------
	
	public boolean search(double aData)
	{
		return recursiveSearch(root, aData);
	}
	public boolean recursiveSearch(Node n, double aData)
	{
		if(n == null)
			return false;
		if(n.data == aData) 
			return true;
		else if(aData < n.data)
			return recursiveSearch(n.leftChild,aData);
		else
			return recursiveSearch(n.rightChild,aData);
	}
	

}

