let bookstore  = document.getElementById('title');

// bookstore.style.color = "red";


let books = document.getElementById('books');

books.innerHTML = '<h1>look at all these books</h1>';

const url = 'http://localhost:8081/productservice/product';

var cors = require(cors());
app.use(cors());
app.options('*',cors());
var allowCrossDomain = function(req,res,next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Methods', 'GET, PUT, POST, DELETE');
  res.header('Access-Control-Allow-Headers', 'Content-Type');
  next();  
}

app.use(allowCrossDomain);

let response = fetch(url)
    .then(response =>{
        console.log(response);
    })
    .catch(error => {
        console.log(error);
    });