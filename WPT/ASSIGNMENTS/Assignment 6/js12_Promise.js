// create  a promise that resolves with a message after 3 seconds.

const myPromise = new Promise((resolve, reject)=>{
    setTimeout(()=>{
        resolve("Success !!!");
    }, 3000);
});

myPromise.then((successmsg)=>{
    console.log(`${successmsg}`);
});


