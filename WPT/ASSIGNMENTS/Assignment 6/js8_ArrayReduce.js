// Use the reduce method to find the total price of items in a shopping cart

const objects = [{x: 100}, {x: 500}, {x:250}, {x: 1210}];

const sum = objects.reduce((accumulator, currentValue) => accumulator + currentValue.x, 0,
);

console.log(sum);