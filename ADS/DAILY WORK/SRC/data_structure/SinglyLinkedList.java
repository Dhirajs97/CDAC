/* Singly Linked List*/


class SinglyLinkedList{

	Node head;	// reference to first node is declared	|| head is reference of Node class

	// Nested class - to create a Node
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
		}
	}

	void display(){		// for List iteration we prefer while()
		Node n = head;				// should not start with head - instead of it define new pointer  as the starting point will miss
		
		while(n != null){	// check if head/ n points to the any node  | If there is no next node it will fail
			System.out.print(n.data + " ----> " );	// n.data - to take the value of the node
			n = n.next;		// to move to the next node
		}
		
	}
	
	// Insertion at the begining
	void insert(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;	// next link of the new node need to point to the current head of the already present node or to null if empty
		head = new_node;		// shift head pointer to the new node
	}
	
	// Insertion in between 
	void insertAfter(Node prev_node, int new_data){
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;		// link to the next node
		prev_node.next = new_node;			// the previous node link will connect to our new node
	}
	
	// Insert at the last
	void append(int new_data){	  // append at the end
		Node new_node = new Node(new_data);
		if(head == null){		// check if the list is empty
			head = new Node(new_data); 	// new_node will get added at head 
			return;
		} 
		new_node.next = null;	// new node which is adding at the last - it's next/link should point to Null
		Node last = head;		// create new pointer which will take us to the last node
		while(last.next != null){		// go to the last node  - till get the last node which will point to null
			last = last.next;	// hoppint to the next node
		}		
		last.next = new_node; 	// next/link of the last node connect with new_node
	}
	
	//-----------------------
	// Deletion 
	
	void deleteNode(int key){	// key - which element to be deleted
		Node temp = head;	// temp- current pointer to traverse and check if the 
		Node prev = null;	//
		
		// Deletion at the begining
		if(temp != null && temp.data == key){	// check if the list is empty  & check if the values of first node and the value we want to delete is the same
			head = temp.next;		// move the head to the next node	- deletion at the begining
			return;
		}
		
		// Deletion in between
		
		while(temp != null && temp.data != key){	// check if the list is not empty and deletion element is not at the first node
			prev = temp;		//move prev to temp
			temp = temp.next;	// move temp to the next node and check if the data matches
				
			if(temp == null){	// check if the node points to the node
				return;
			}
			prev.next = temp.next;	// next/link of previous node connect to the next of the node to be deleted | so that the next/link of previous node will save the address of the next node of the node which we want to delete
		}	
	}
	
	//---------------------
	// Deletion at index 
	void deleteNodeAtIndex(int position){
		if(head == null){		// check if the list is empty
			return;
		}
		
		Node temp = head;
		
		if(position == 0){	// to delete node at begining at 0 position
			head = temp.next;	// shift the head position
			return;
		}
		
			//  i<position-1  =>suppose we have position =3 at index 3 we want to delete the node | so  i<position-1 loop will stop at 3-1 = 2  - at 2 index the loop will get exit 'temp=2'  | and we will next/link of this 2 temp node to the 'temp.next.next' node (next node of node of which we want to delete)  2-->4 2 will point to 4 and 3 will get deleted  */
		for(int i=0; temp!=null && i<position-1; i++){  	
			temp = temp.next;		// till we get the position move the temp pointer
		
		}
		if(temp == null || temp.next == null){
			return;
		}

		Node next = temp.next.next;		// next/link of temp connext with next of next node  | as next node after node need to be deleted
		temp.next = next;
		
	}
	
	
	// get center element of the list
	void middlePoint(){
		Node ptr1 = head;	// slow pointer - will move by 1 element
		Node ptr2 = head; 	// fast pointer - will move by 2 elements
		
		while(ptr1 != null && ptr2.next !=null){		// this works fine for total odd numbers
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;				// ptr2 will traverse by 2 and if there is null the ptr1 will be on the middle position in the list
		}
		System.out.println("\nMiddle Element in the Linked List : "+ptr1.data);
	}
	
	// Print the reversed linked list 
	
	Node reverse(Node node){
		Node prev = null;
		Node current = node;	// Starting point of list	
		Node next = null;
		
		while(current != null){
			next = current.next;	// next(pointer) shift to next
			current.next = prev;	// reversing the link pointer of curreent node    | the link of current node will be pointing to the next node  - that link we need to reverse from the current node pointing to the previous node
			prev = current;			//move prev pointer to curent node
			current = next;			// move current pointer to next node
		}	
		return prev;
	}

	public static void main(String args[]){
		
		SinglyLinkedList l1 = new SinglyLinkedList(); // created object
		
		l1.head = new Node(10);	// referening the head to connect head to the first node  | data value is 10
		
		Node second = new Node(20);  // new node will get created 
		
		Node third = new Node(30);	// new node will get created

		//In above only nodes are created

		// Link the nodes
		l1.head.next = second;	// link first node 'next' to second node
		second.next = third; 	// second 'next' coneccted to the third node
		
		l1.display();
		
		// Insertion at the begining to the Linked List 
		l1.insert(40);
		l1.insert(50);
		System.out.println("\n Insertion at the begining");		
		l1.display();
		
		// Insertion between nodes
		//insert after the head
		l1.insertAfter(l1.head, 60);
		System.out.println("\n Insertion in between after head");
		l1.display();
		// insert at the next after the head
		l1.insertAfter(l1.head.next, 100);
		System.out.println("\n Insertion in between after head");
		l1.display();
		
		// insert at the end of the list
		l1.append(11);
		System.out.println("\n Insertion at the end of the list");
		l1.display();
		
		// Deletion
		//System.out.println("\n Delete node with value -50");
		//l1.deleteNode(50);
		//l1.display();
		
		System.out.println("\n Delete node with index : 3");
		l1.deleteNodeAtIndex(3);
		l1.display();
	
		// It you want to delete complete linked List : we can assign the 'head=null'  means the linked list logically does not exist  | but the linked list will be present in the memory
		
		
		// display middle element 
		l1.middlePoint();
		
		// reverse the linked list
		l1.head = l1.reverse(l1.head);
		l1.display();
		
		
	}

}


/*
10 ----> 20 ----> 30 ---->
*/