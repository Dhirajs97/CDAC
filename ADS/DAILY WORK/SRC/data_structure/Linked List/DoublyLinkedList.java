

class DoublyLinkedList{

	Node head;

	class Node{
		int data;
		Node prev;
		Node next;
		
		Node(int d){
			data = d;
			prev = null;
			next = null;
		}
	}
	
	// insert at the begining
	void insert(int new_data){
		Node new_node = new Node(new_data);		// created a new_node reference - created a new node with value of new_data
												// it will be the first element/node in the linked list
		new_node.next = head;
		new_node.prev = null;	// set prev points to null  as first element prev will be connected with null
		
		if(head != null){
			head.prev = new_node;
		}
		head = new_node; 	// move head to the new_node which is added at the first position in the list
	
	}
	
	
	// Insert in between - After specific element   (so we will pass the previous node)
	void insertAfter(Node prev_node, int new_data){
		// check if the previous node exists or not	 
		if(prev_node == null){
			System.out.println("Empty List");
			return;
		}
		Node new_node = new Node(new_data);
		
		new_node.next = prev_node.next;		// next of new_node connect with next_node
		prev_node.next = new_node;			//next of prev_node connect with new_node
		new_node.prev = prev_node;			// prev of new_node connect with prev_node
				
		if(new_node.next != null){	// check if the inserted new_node is pointing to null i.e. it is last element 
			new_node.next.prev = new_node;	// prev of next_node connect with with new_node
		}	
	}
	
	
	// insert in between - at the specific index
	void insertinBetween(int new_data, int index){
		Node new_node = new Node(new_data);		
		Node temp = head;								
				
		for(int i=0; i<index-1; i++){		
			temp = temp.next;
		}
		new_node.next = temp.next;
		new_node.prev = temp;
		
		if (temp.next != null) {
			temp.next.prev = new_node;
		}	
		temp.next = new_node;
		
	}

	// Insert at the end
	
	void append(int new_data){

		Node new_node = new Node(new_data);
		Node last = head;	// creating a reference last and pointing head to it
		new_node.next = null;	// the new_node we are enteringf at last so need to point it's next to null
		
		if(head == null){
			head = new_node;	// if the list is empty head will point to the new_node we are adding
			new_node.next = null;
			return;
		}		
		
		while(last.next != null){	//traverse till we get the last node
			last = last.next;
		}
		last.next = new_node;		
		new_node.prev = last;
	}
	
	// Deletion of Node
	void deleteNode(Node del){	// del is reference pointer to delete particular node

		if(head == null || del == null){	//check if the list is empty or del reference to null
			System.out.println("List is empty");
			return;
		}
		// if list have only one node that to be deleted
		if(head == del){	// check if the element to be deleted is at the first position in the begining
			head = del.next;  //  shift the head to next node
		}
		// If the element present inbetween the nodes
		if(del.next !=null){	// if next node is present then 
			del.next.prev = del.prev;	// connext the prev of next_node to the prev_node of deleting node
		}
		//
		if(del.prev != null){
			del.prev.next = del.next;	// next of prev_node connect to the next_node of the delting node
		}		
		return;
	}
	
	
	
	// Display elements of the Doubly linked list
	void display(Node n){
		Node p = null;
		//Node n = head;	// n will point to head
		System.out.println("\n In Forward direction : ");
		while(n != null){
			System.out.print(n.data + " --> ");
			p=n;		// shift p to n - we will shift the p to the current node and after that we will move the n to next node
			n = n.next;		// move n to next node
		}
		// at last n will point to null and p will point to the last element of list - so we can use the p to furether access elements in reverse order using p
		
		System.out.println("\n In Reverse Direction direction : ");
		while(p != null){	// in the above code the p will come at the last node so we will do the reverse now  using -prev
			System.out.print(" <-- " + p.data);
			p = p.prev;
		}
		
	}
	

	
	
	
	public static void main(String args[]){
		
		DoublyLinkedList dl1 = new DoublyLinkedList();
	
		// Insert at the begining
		dl1.insert(10);
		dl1.display(dl1.head);
		dl1.insert(20);
		dl1.insert(30);
		dl1.insert(40);
		dl1.insert(50);
		dl1.insert(60);
		dl1.display(dl1.head);
		
		// insert afetr specific element/node
		dl1.insertAfter(dl1.head, 90);
		dl1.display(dl1.head);
		
		// Insert in between  at specific index
		dl1.insertinBetween(100, 4);
		dl1.display(dl1.head);
		
		// Insert at the end
		dl1.append(200);
		dl1.display(dl1.head);
		
		// Deletion  of first node in the list
		System.out.println("\nAfter deletion of fist node of list");
		dl1.deleteNode(dl1.head);
		dl1.display(dl1.head);
		
		// Deletion  of second node in the list
		System.out.println("\nAfter deletion of second node of list");
		dl1.deleteNode(dl1.head.next);
		dl1.display(dl1.head);
		
	}

}