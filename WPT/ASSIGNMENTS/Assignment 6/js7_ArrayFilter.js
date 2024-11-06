// Use the filter method to create a new array containing only the even numbers from the given array

const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function isEven(num){
    for(let i=0; i<num; i++){
        if(num % 2 === 0){
            return true;
        }
    }
}

const evenNumbers = arr.filter(isEven)
console.log(evenNumbers);



