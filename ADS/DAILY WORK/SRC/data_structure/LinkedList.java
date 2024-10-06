package test;

import java.util.Scanner;

class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// add node at the begining
	void insertBegining(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	// add node at the end of the List
	void append(int data) {
		Node new_node = new Node(data);
		if (head == null) {
			head = new Node(data);
			return;
		}
		new_node.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new_node;
	}

	// AMA add node after particular node
	void insertAfter(int prev_data, int data) {
		Node current = head;
		while(current!=null&&current.data!=prev_data){ 
			current = current.next;
		}
		Node new_node = new Node(data);
		new_node.next = current.next;
		current.next=new_node;
	}

	// add node before particular node

	void insertBefore(int next_data, int data) {
		Node prev_node = null; 
		Node current = head;
		while(current != null && current.data != next_data){
			prev_node = current;
			current = current.next;
		}
		Node new_node = new Node(data);
		prev_node.next = new_node;
		new_node.next = current;
	}

	// DN - Delete the particular node
	void deleteNode(int data) {
		Node current = head;
		Node prev_node = null;
		if (current != null && current.data == data) {
			head = current.next;
			return;
		}
		while (current != null && current.data != data) {
			prev_node = current;
			current = current.next;
		}
		prev_node.next = current.next;
	}

	//DNA - Delete node after particular node
	void deleteNodeAfter(int data){
		Node current = head;
		while(current != null && current.data != data){
			current = current.next;
		}
		if(current != null && current.next != null){
			current.next = current.next.next;
		}
	}

	//DNB Delete node before particular node 
	void deleteNodeBefore(int data) {
		if(head==null || head.next==null){
			return;
		}
		if(head.next.data == data){
			head = head.next;
			return;
		}
		Node prev_node = null;
		Node current = head;
		Node next_node = head.next;
		while(next_node != null && next_node.data != data) {
			prev_node = current;
			current = next_node;
			next_node = next_node.next;
		}
		if(next_node == null){
			return;
		} 
		if(prev_node != null) {
			prev_node.next = next_node;
		}
	}

	// Print of the Linked List
	void printLinkedList() {
		if (head == null) {
			System.out.println("Empty");
		}
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println("");
	}

	// Fancy Print of the Linked List
	void printFancy(){ 
		Node n = head; 
		System.out.println(); 
		while(n != null){ 
			System.out.print(n.data); 
			if(n.next != null){ 
				System.out.print("->"); 
			}
			n = n.next;
		} 
		System.out.println();
	}
	
	//Reverse print the Linked List
	void printreverse(){ 
		printReverse (head);
		System.out.println("\n");
	}
	void printReverse(Node temp) { 
		if(temp == null){
			return;
		}
		else {
			printReverse(temp.next); 
		}
		System.out.print(temp.data + " ");
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		LinkedList ll = new LinkedList();
		
		String operation = "";
		while(!operation.equals("EXIT")){
			
			operation = sc.next();			
			switch(operation){
				case "AB":
					ll.insertBegining(sc.nextInt());
					break;
				case "AE":
					ll.append(sc.nextInt());
					break;
				case "PR":
					ll.printLinkedList();
					break;
				case "AMA":
					ll.insertAfter(sc.nextInt(), sc.nextInt());
					break;
				case "AMB":
					ll.insertBefore(sc.nextInt(), sc.nextInt());
					break;
				case "DN":
					ll.deleteNode(sc.nextInt());
					break;
				case "DNA":
					ll.deleteNodeAfter(sc.nextInt());
					break;
				case "DNB":
					ll.deleteNodeBefore(sc.nextInt());
					break; 
				case "FPR":
					ll.printFancy();
					break;
				case "RPR":
					ll.printReverse(ll.head);
					break;
			}
		}
	}
	
}
