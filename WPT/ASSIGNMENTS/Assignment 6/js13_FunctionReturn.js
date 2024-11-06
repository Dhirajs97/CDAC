//Create a function that returns another function, demonstrating closure

function myfun(a){
    
    return function(b){
        return a + b;
    }

}


const call1 = myfun(10);
const call2 = myfun(20);

console.log(call1(5));
console.log(call2(5));




