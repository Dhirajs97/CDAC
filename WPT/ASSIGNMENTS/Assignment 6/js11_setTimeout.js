// Write a  function that accepts a callback and executes it after a delay

function result(sum, a, b){
    console.log("Sum is : ");

    sum(a, b);
}

function sum(a, b){
    setTimeout(()=> 2000);
    console.log(a+b);
}

setTimeout(()=> result(sum, 10, 20), 2000);


