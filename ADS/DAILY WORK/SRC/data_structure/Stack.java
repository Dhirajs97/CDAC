/* Stack operations */

class Stack{
	
	static final int MAX=10;	// max size of the stack
	int top;	// current posion 
	
	int arr[] = new int[MAX];
	
	boolean isEmpty(){
		return (top < 0); 	// check if top is empty return if -1
	}
	
	Stack(){		// Constructor
		top = -1;	// Stack will be empty primarily
	}

	// Insertion
	boolean push(int x){
		if(top >= (MAX-1)){		// check if the stack have the space to insert - 
			System.out.println("Stack is Overflow");
			return false;
		}
		arr[++top] = x;		// increase the top+1 and insert the element	|| before that it will indiate that the top is at the top element 
		return true;
	}
	
	// Deletion
	int pop(){	// top will be deleted | we can delete only the top element only | we cannot delete by giving the value we want to delete
		if(top < 0){	// check if stack is empty
			System.out.println("Stack Underflow");
			return 0;
		}	

		return arr[top--];	// decrese the top by 1 | the element at the top will get deleted 
		
	}
	
	// peek() - to know the position of top
	int peek(){
		return (top < 0) ? -1 : arr[top];
	}
	
	void display(){
		if(isEmpty()){
			System.out.println("Empty Stack");
		}
		else{
			System.out.println("Stack Elements are : ");
			show(top);
			System.out.println();
		}
		
	}
	void show(int index){
		
		if(index < 0)		// base condition
			return;
		System.out.println(arr[index] + "  ");
		show(index-1);	// recursive call
	}
	/*//Display elements of Stack
	void d(){
		for(int i=top; i>=0; i--){
			System.out.println(arr[i]);
		}
	}
	*/
	
	public static void main(String rags[]){
	
		Stack stack = new Stack();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		stack.display();
		
		stack.pop();
		stack.display();
		//stack.d();
		System.out.println("Top element : " + stack.peek());
	}

}

