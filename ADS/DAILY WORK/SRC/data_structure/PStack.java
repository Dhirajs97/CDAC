/* Stack Push and Pop operation*/
import java.util.Scanner;
class PStack{
	
	int[] arr;
	int top;
	int capacity;
	
	PStack(int n){
		arr = new int[n];
		this.capacity = n;
		top = -1;
	}
	
	boolean isEmpty(){
		return (top == -1);		
	}
	boolean isFull(){
		return(top == capacity-1);
	}
	
	void push(int x){
		if(isFull()){
			System.out.println("Stack Overflow !");
			return;
		}
		arr[++top] = x;
	}	
	int pop(){
		if(isEmpty()){
			System.out.println("Stack Underflow !");
			return -1;
		}
		return arr[top--];		
	}
	void display(){
		if(isEmpty()){
			return;
		}
		for(int i=top; i>=0; i--){
			System.out.println(arr[i] + "  ");
		}
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		PStack stack = new PStack(n);
		
		String operation = "";
		while(!operation .equals("exit")){
				
			operation = sc.next();
			switch(operation){			 			
				
				case "push":					
					int value = sc.nextInt();
					stack.push(value);				
					break;
				case "pop":					
					int poppedValue = stack.pop();
					if(poppedValue != -1)
						System.out.println(poppedValue);
					break;
				case "display":					
					stack.display();
					break;
			}
		}		
	}
}

