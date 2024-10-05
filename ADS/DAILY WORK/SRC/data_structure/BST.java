/*Binary Search Tree*/

import java.util.Scanner;
class BST{

	Node root;
	
	class Node{
		int data;
		Node left = null;
		Node right = null;
		
		Node(int d){
			data = d;
			left = null;
			right = null;
		}	
	}	

	BST(){	
		root = null;
	}
	BST(int d){
		root = new Node(d);
	}
	
	/**** Insertion ***/

	Node insert(Node root, int key){
		if(root == null){
			root = new Node(key);
			return root;
		}
		if(key <= root.data){
			root.left = insert(root.left, key);
		}
		else{
			root.right = insert(root.right, key);
		}
		return root;
	}
	void printInsert(int key){
		root = insert(root, key);
	}
	
	/***  Deletion ***/
	Node delete(Node root, int key){
		if(root == null){
			
			return null;
		}
		if(key < root.data){
			root.left = delete(root.left, key);
		}
		else if(key > root.data){
			root.right = delete(root.right, key);
		}
		
		else{
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			
			root.data = minValue(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}
	int minValue(Node root){
		int x = root.data;
		while(root.left != null){
			x = root.left.data;
			root = root.left;
		}
		return x;
	}
	void printDelete(int key){
		root = delete(root, key);
	}
	
	/***  Traverse  Print Inorder sort ***/
	void printInorder(Node node){
		if(node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
	}
	void inorder(){
		printInorder(root);
	}
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		BST bst = new BST();
		
		
		while(true){
			int key = sc.nextInt();		// no. of element want to insert
			if(key == -1)
				break;
			bst.root = bst.insert(bst.root, key);			
		}
		// check path
		int n = sc.nextInt();	// no element for path check
			bst.printDelete(n);

		// print Inorder
		bst.inorder();
		
	}
}
