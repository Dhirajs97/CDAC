//  Create an object to represent a book with properties such as title, author, and year published. Add a method to display book details

const book = {

    printBookDetails: function() {
        console.log(`Book Title : ${this.title}`);
        console.log(`Author: ${this.author}`);
        console.log(`Year Published: ${this.published_year}`);
    }

};

const bookobj = Object.create(book);
bookobj.title = "Wings of Fire";
bookobj.author = "Dr. A. P. J. Abdul Kalam";
bookobj.published_year = 2013;

bookobj.printBookDetails();



