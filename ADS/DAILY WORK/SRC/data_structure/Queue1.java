/* Simple Queue */


class Queue1 {

	int size = 5;
	int Q[] = new int[size];
	
	int front, rear;
	
	Queue1(){		
		front = -1;	// When queue is empty  Front and Rear will point to -1
		rear = -1;
	}
	
	boolean isEmpty(){
		return(front == -1); 	//  front > rear
	}
	
	boolean isFull(){
		return(rear == size-1);	// Rear points the last element of array
	}
	
	// Insertion
	void enqueue(int x){
		// check queue not to be full
		if(isFull()){
			System.out.println("Queue is full !");
		}
		else{			
			if(front == -1){	// queue is empty and we are adding the first element so we need to set the Front to first element
				front = 0; // Set the FRONT to arr[0] position	|| It will be for only once on inserting the first element
				
			}	 
			
			rear++;		// increasing the rear+1 
			Q[rear] = x; // insert the X value
			System.out.println(x + " Inserted");
		}
	}
	
	// Deletion
	int dequeue(){
		
		if(isEmpty()){	// Check if the Queue is empty  | 
			System.out.println("Queue is empty");
			return -1;
		}
		else{
			int x = Q[front];	// 
			System.out.println(x + "Deleted");
			
			if(front > rear){	// FRONT > REAR means that the element was last one and queue is empty 
				front = -1;		// so when queu is empty, we can reset the front and rear values to the -1 for empty queue
				rear = -1;				
			}
			else{
				// frter the deletion of element, we have more elements in the queue so FRONT will increase and point to the first element available in the queue at it's location
				front++;	//  FRONT need to be increased to point to the next element		
			}
			return x;
		}					
	}
	
	// display elements of Queue
	void display(){
		if(isEmpty()){
			System.out.println("Empty Queue !");
		}
		else{
			System.out.println("Queue elements : ");
			
			for(int i=front; i<=rear; i++){		// we need to print the present elements of the queue only | blank will not be allowed | so start from FRONT to REAR
				
				System.out.print(Q[i]+ "  ");  // 	
			
			}
		}
	}
	
	public static void main(String args[]){
		
		Queue1 q1 = new Queue1();
		
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		
		q1.display();
		
		q1.dequeue();
		q1.display();
		
		q1.dequeue();
		q1.display();
		
		q1.dequeue();
		q1.display();
		
		q1.dequeue();
		q1.display();
		
		q1.dequeue();
		q1.display();
			
	}	
}