
const cart = [];

const tax = 0.18;
let totalPrice =0;
let totalItems = 0;

const addItem = (productName, price, quantity) =>{
    const item = {productName, price, quantity};
    cart.push(item);
    totalItems = totalItems + quantity;
    updatePrice(price * quantity);
    console.log(`${productName}, added to the cart`);
}

function updatePrice(amount){
    totalPrice += amount;
}

const displayItems = ()=>{
    cart.forEach(({productName, quantity, price})=>{
        console.log(`${productName}   ${quantity}   ${price}`);
    })
}

const calculateBill = () =>{
    const taxAmount = totalPrice * tax;
    const billamount = totalPrice + taxAmount;

    console.log(`Total Price : ${totalPrice}`);
    console.log(`Tax amount 18% : ${taxAmount}`);
    console.log(`Billing Amount : ${billamount}`);
     
}

addItem("Apple", 40, 5);
addItem("Ice-Cream", 50, 10);
addItem("Sweets", 100, 10);

displayItems();
calculateBill();