// Create a function that takes any number of arguments and returns their sum using the rest operator

function sum(... args){
    let total = 0;

    for(const arg of args){
        total = total + arg;
    }
    return total;
}

console.log(sum(10, 20, 30));





