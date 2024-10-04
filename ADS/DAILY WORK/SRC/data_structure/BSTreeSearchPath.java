/* Search for a Node and Print Path */
import java.util.Scanner;

class BSTreeSearchPath{

	Node root;
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	BSTreeSearchPath(){
		root = null;		
	}
	BSTreeSearchPath(int d){
		root = new Node(d);
	}
	
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
	
	// Search Node and print path of Node
	void searchNodePrintPath(Node root, int key){
		StringBuilder path = new StringBuilder();
		
		boolean found = searchPath(root, key, path);
		
		if(found){
			System.out.println(path.toString());
		}
		else{
			System.out.println("Not Found");
		}
	}
	boolean searchPath(Node root, int key, StringBuilder path){
		if(root == null){
			return false;
		}
		if(path.length() == 0){
			path.append("Root");
		}
		else{
			path.append("");
		}
		
		if(root.data == key){
			return true;
		}
		
		if(key < root.data){
			path.append(" L");
			return searchPath(root.left, key, path);
		}
		else{
			path.append(" R");
			return searchPath(root.right, key, path);
		}
	}
	

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		BSTreeSearchPath bst = new BSTreeSearchPath();
		
		int key=0;
		while(key != -1){
			key = sc.nextInt();
			if(key == -1)
				break;
			bst.root = bst.insert(bst.root, key);
		}
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			key = sc.nextInt();
			bst.searchNodePrintPath(bst.root, key);
		}
	
	}

}