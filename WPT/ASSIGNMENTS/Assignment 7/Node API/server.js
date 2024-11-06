
const express = require('express');
const mongoose = require('mongoose');
const app = express()
const Product = require('./models/productModel');

app.use(express.json())
app.use(express.urlencoded({extended: false}))

// declare route to access on browser - / root directory
app.get('/',  (req, res)=>{
    res.send("Hello NODE API");
})

app.get('/blog',  (req, res)=>{
    res.send("Hello Blog, My name is Devtamin");
})

app.get('/products', async(req, res)=>{
    try{
        const products = await Product.find({});
        res.status(200).json(products);
    }
    catch(error){
        console.log(error.message);
        res.status(500).json({message: error.message});
    }5
})

app.get('/products/:id', async(req, res)=>{
    try{
        const {id} = req.params;
        const product = await Product.findById(id);
        res.status(200).json(product);
    }
    catch(error){
        res.status(500).json({message: error.message});
    }
})

app.post('/product', async(req, res)=>{
    try{
        const product = await Product.create(req.body)
        res.status(200).json(product);
        
    
    }catch(error){
        console.log(error.message);
        res.status(500).json({message: error.message})
    }
    
});

// update a product
app.put('/products/:id', async(req, res)=>{
    try{
        const {id} = req.params;
        const product = await Product.findByIdAndUpdate(id, req.body);
        // if no product found in database
        if(!product){
            return res.status(404).json({message: `Product not found with ID ${id}`})
        }
        const updatedProduct = await Product.findById(id);
        res.status(200).json(updatedProduct);
    }
    catch(error){
        res.status(500).json({message: error.message})
    }
})

// Delete the product by id
app.delete('/products/:id', async(req, res)=>{
    try{
        const {id} = req.params;
        const product = await Product.findByIdAndDelete(id);
        if(!product){
            return res.status(404).json({message: `Unable to find any Product with ID ${id}`})            
        }
        res.status(200).json(product)
    }
    catch(error){
        res.status(500).json({message: error.message})
    }
})



mongoose.set("strictQuery", false)
mongoose.
connect('mongodb+srv://sdhiraj1997:cdac@devtaminapi.hzg5h.mongodb.net/NodeAPI?retryWrites=true&w=majority&appName=DevtaminAPI')
.then(() =>{
    console.log("Connected to MongoDB");
    app.listen(5000, ()=>{
        console.log("Node API app is running on port 5000");
    });
   
}).catch((error)=>{
    console.log(error);
})





