
class Array1{

	// Search for an element -key
	static int search(int arr[], int size, int key){
		
		for(int i=0; i<size; i++){	
			if(arr[i] == key){
				return i;	// returning index			
			}
		}
		return -1; // Element does not found
	}
	
	// Insert 
	static int insert(int arr[], int size, int key, int capacity){
		if(size > capacity){
			System.out.println("Array is full ! ");
			return size;
		}
		arr[size] = key;	// insert new element
		return size + 1;	// return updated size
	}
	
	// Delete
	static int delete(int arr[], int size, int key){	
		int pos = search(arr, size, key);  // to find the element 
		if(pos == -1){
			System.out.println("Not found");		
			return size;
		}
		else{
			for(int i=pos; i<size-1; i++){	// delete element 
				arr[i] = arr[i+1];			// update index
			}
			return size -1;
		}	
	}


	public static void main(String args[]){
	
		int[] a1 = new int[100];
		
		int size = 10;
			
		a1[0] = 10;
		a1[1] = 51;	
		a1[2] = 60;
		a1[3] = 11;
		a1[4] = 11;
		a1[5] = 70;
		a1[6] = 45;
		a1[7] = 100;
		a1[8] = 30;
		a1[9] = 11;
		
		for(int i=0; i<size; i++){
			System.out.print(a1[i]+ "  ");
		}
		
		// Search
		int key = 70;
		int pos = search(a1, size, key);
		if(pos != -1)
			System.out.println("\n Found at "+pos);
		else
			System.out.println("Not Found ");
		
		// Insert
		key = 111;
		size = insert(a1, size, key, 100);
		for(int i=0; i<size; i++){
			System.out.print(a1[i]+ "  ");
		}
		
		System.out.println();
		
		// Delete
		key = 51;
		size = delete(a1, size, key);
		for(int i=0; i<size; i++){
			System.out.print(a1[i]+ "  ");
		}
		
		// print repeated elements
		System.out.print("\nRepeted elements : ");
		for(int i=0; i<size; i++){
			for(int j=i+1; j<size; j++){
				if(a1[i] == a1[j])
					System.out.print(a1[j]+ "  ");
				break;
			}
			
		}			
	}
}