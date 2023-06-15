// Sample product data
var products = [
    {
        name: "TOTAL | Γιαούρτι Στραγγιστό 5% Λιπαρά 1kg",
        image: "/images/products/product1.jpg",
        price: 4.38,
        type: "dairy"
    },
    {
        name: "ΝΙΤΣΙΑΚΟΣ | Chicken Nuggets Κοτόπουλο 400g",
        image: "/images/products/product2.jpg",
        price: 5.15,
        type: "meat"
    },
    {
        name: "NIRVANA | Παγωτό Pralines & Cream 650gr",
        image: "/images/products/product3.jpg",
        price: 8.76,
        type: "dairy"
    },
    {
        name: "THINK BIO | Τοματίνια Βελανίδι Βιολογικής Γεωργίας Ελληνικά 250gr",
        image: "/images/products/product4.jpg",
        price: 2.09,
        type: "vegetable"
    },
    {
        name: "ΟΛΥΜΠΟΣ | Ρόφημα Καρπός Αμύγδαλο Χωρίς Ζάχαρη 1 Lt",
        image: "/images/products/product5.jpg",
        price: 3.27,
        type: "vegetable"
    },
    // Add more products as needed
];

var productList = document.getElementById("product-list");
var totalAmountElement = document.getElementById("totalAmount");
var totalAmount = 0;

// Function to display products on the page
function displayProducts(products) {
    productList.innerHTML = "";

    products.forEach(function(product) {
        var productDiv = document.createElement("div");
        productDiv.classList.add("product");

        var image = document.createElement("img");
        image.src = product.image;

        var name = document.createElement("h3");
        name.textContent = product.name;


        var price = document.createElement("p");
        price.textContent = "Price: €" + product.price.toFixed(2);

        var button = document.createElement("button");
        button.textContent = "Add to Cart";
        button.addEventListener("click", function() {
            addToCart(product);
        });

        productDiv.appendChild(image);
        productDiv.appendChild(name);
        productDiv.appendChild(price);
        productDiv.appendChild(button);

        productList.appendChild(productDiv);
    });
}

// Display all products initially
displayProducts(products);

// Function to filter products based on price range
function applyPriceFilter() {
    var priceRange = document.getElementById("priceRange").value;

    var filteredProducts = products.filter(function(product) {
        return product.price <= priceRange;
    });

    displayProducts(filteredProducts);
}

// Function to filter products based on type
function applyTypeFilter() {
    var productType = document.getElementById("productType").value;

    var filteredProducts;
    if (productType === "All") {
        filteredProducts = products;
    } else {
        filteredProducts = products.filter(function(product) {
            return product.type === productType || productType === "";
        });
    }

    displayProducts(filteredProducts);
}

// Function to add product to cart
function addToCart(product) {
    // Replace with your own logic to add product to cart
    totalAmount += product.price;
    totalAmountElement.textContent = totalAmount.toFixed(2);
}

// Update price range value display
var priceRange = document.getElementById("priceRange");
var priceValue = document.getElementById("priceValue");
priceValue.textContent = "Price Range: €" + priceRange.value;

priceRange.addEventListener("input", function() {
    priceValue.textContent = "Price Range: €" + priceRange.value;
});