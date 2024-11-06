// Given an object representing a car, use object destructuring to extract its properties

const car = {
    make: 'curve',
    model: 'curve',
    color: 'silver',
    price: '11 Lac'
}

const {make, model, color, price} = car;

console.log(make);
console.log(model);
console.log(color);
console.log(price);