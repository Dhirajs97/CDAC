
const arr = [1,2,3,4,5,6,7,8,9];

function isEven(num){
    for(let i=0; i<num; i++){
        if(num % 2 === 0){
            return true;
        }
    }
}

const evenNumbers = arr.filter(isEven)


const arr2 = evenNumbers.map((x)=> x*2);


const sum = arr2.reduce((accumulator, currentValue) => accumulator + currentValue, 0,
);

console.log(sum);





