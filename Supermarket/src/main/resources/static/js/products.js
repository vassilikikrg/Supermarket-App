fetch('/all')
    .then(response => response.json())
    .then(data => {
        // Process the retrieved data
        displayProducts(data);
    })
    .catch(error => console.error(error));



/*
// Sample product data
var products = [
    {
        id: 1,
        name: "TOTAL | Γιαούρτι Στραγγιστό 5% Λιπαρά 1kg",
        description: "Γιαούρτι στραγγιστό 5% λιπαρά\n" +
            "\n" +
            "Το αγαπημένο στραγγιστό γιαούρτι με την χαρακτηριστική γεύση και βελούδινη υφή.\n" +
            "\n" +
            "Στραγγιστό γιαούρτι αγελάδος\n" +
            "5% λιπαρά\n" +
            "Απλά φυσικά συστατικά\n" +
            "Πλούσιο σε πρωτεΐνη",
        image: "/images/products/product1.jpg",
        price: 4.38,
        type: "dairy"
    },
    {
        id: 2,
        name: "ΝΙΤΣΙΑΚΟΣ | Chicken Nuggets Κοτόπουλο 400g",
        description: "Η ποιοτική πρώτη ύλη, συναντά την καινοτομία και την δημιουργικότητα: κοτόπουλο και γαλοπούλα ΝΙΤΣΙΑΚΟΣ, προψημένα και παναρισμένα σε 5 διαφορετικές εκδοχές.\n" +
            " \n" +
            "Τραγανές μπουκιές από τα καλύτερα κομμάτια κρέατος, προψημένα και παναρισμένα με αναλλοίωτη τη γεύση τους και τα χαρακτηριστικά τους, προσθέτουν αξία στο μενού σας.",
        image: "/images/products/product2.jpg",
        price: 5.15,
        type: "meat"
    },
    {
        id: 3,
        name: "NIRVANA | Παγωτό Pralines & Cream 650gr",
        description: "Παγωτό καραμέλα με σιρόπι καραμέλας 12,3% και καραμελωμένα πεκάν 8,5%.",
        image: "/images/products/product3.jpg",
        price: 8.76,
        type: "dairy"
    },
    {
        id: 4,
        name: "THINK BIO | Τοματίνια Βελανίδι Βιολογικής Γεωργίας Ελληνικά 250gr",
        description: "Τα τοματίνια περιέχουν βιταμίνες, μέταλλα και ιχνοστοιχεία που ενισχύουν το ανοσοποιητικό σύστημα, προστατεύουν από τον καρκίνο, ρυθμίζουν το σάκχαρο, βοηθούν στη μείωση της χοληστερίνης και ενισχύουν τα οστά. Είναι εξαιρετική πηγή βιταμινών Α, C και Κ, καλίου και μαγγανίου. Επίσης, είναι πολύ πλούσια σε βιταμίνη Ε (α-τοκοφερόλη), θειαμίνη, νιασίνη, βιταμίνη Β6, φυλλικό οξύ, μαγνήσιο, φώσφορο, χαλκό και β-καροτένιο .Έχουν ισχυρή αντιοξειδωτική δράση, κυρίως λόγω της υψηλής περιεκτικότητας σε λυκοπένιο.",
        image: "/images/products/product4.jpg",
        price: 2.09,
        type: "vegetable"
    },
    {
        id: 5,
        name: "ΟΛΥΜΠΟΣ | Ρόφημα Καρπός Αμύγδαλο Χωρίς Ζάχαρη 1 Lt",
        description: "Το ΚΑΡΠΟΣ ΑΜΥΓΔΑΛΟ είναι ένα ρόφημα αμυγδάλου το οποίο παράγεται αποκλειστικά από ελληνικά αμύγδαλα. Επιλέγουμε τα καλύτερα αμύγδαλα, σε συνεργασία με τους Έλληνες παραγωγούς και σας προσφέρουμε ένα φυτικό ρόφημα με όλη την υψηλή θρεπτική αξία των ελληνικών καρπών χωρίς προσθήκη ζάχαρης.\n" +
            "\n" +
            "Eίναι μη γαλακτοκομικό προϊόν & δεν περιέχει γλουτένη και λακτόζη. Παράγεται αποκλειστικά από ελληνικά αμύγδαλα. Είναι κατάλληλο για χορτοφάγους και για όσους δεν καταναλώνουν γαλακτοκομικά προϊόντα.\n" +
            "\n" +
            "Απολαύστε τη γεύση των αμυγδάλων σε ένα 100% φυτικό ρόφημα με υψηλή περιεκτικότητα εδώδιμων ινών, πλούσιο σε ασβέστιο, βιταμίνη Ε και βιταμίνη D! Η νέα πρόταση της ΟΛΥΜΠΟΣ, με υψηλή διατροφική αξία και με υπέροχη γεύση, για να έχετε στο ποτήρι σας όλη τη γεύση του αμυγδάλου!",
        image: "/images/products/product5.jpg",
        price: 3.27,
        type: "vegetable"
    },
    // Add more products as needed
];*/

var productList = document.getElementById("product-list");
var totalAmountElement = document.getElementById("totalAmount");
var totalAmount = 0;




// Function to display products on the page
function displayProducts(products) {
    /*
    productList.innerHTML = "";

    products.forEach(function(product) {
        var productDiv = document.createElement("div");
        productDiv.className = "product-card";
        productDiv.id = "product-" + product.id;
        productDiv.classList.add("product");

        var productImage = document.createElement("img");
        productImage.src = product.imageSource;
        productImage.alt = product.name;
        productImage.className = "product-image";

        var productDetails = document.createElement("div");
        productDetails.className = "product-details";

        var productLink = document.createElement("a");
        productLink.href = "/product?products=" + encodeURIComponent(JSON.stringify(products)) + "&id=" + product.id;
        productDiv.appendChild(productLink);


        var productName = document.createElement("h3");
        productName.className = "product-title";
        productName.textContent = product.name;

        var productPrice = document.createElement("p");
        productPrice.className = "product-price";
        productPrice.textContent = "Price: €" + product.price.toFixed(2);


        var button = document.createElement("button");
        button.className = "add-to-cart";
        button.textContent = "Add to Cart";
        button.addEventListener("click", function() {
            addToCart(product);
        });

        productDiv.appendChild(productDetails);
        productDiv.appendChild(productImage);
        productDiv.appendChild(productName);
        productDiv.appendChild(productPrice);
        productDiv.appendChild(button);

        productList.appendChild(productDiv);



            var productCards = document.getElementsByClassName("product-card");


            Array.from(productCards).forEach(function(card) {
                var titleElement = card.querySelector(".product-title");
                var productId = parseInt(card.id.replace("product-", ""));

                titleElement.addEventListener("click", function() {
                    window.location.href = "/product?id=" + productId;
                });
            });

    });*/


    // Access the product-container element
    //const productList = document.getElementById('product-list');
    const container = document.getElementById('product-list');

    // Create HTML markup for each product
    const productsHTML = products.map(product => `

      <div class="product">
    <img class="product-image" src="${product.imageSource}" alt="${product.name}">
    
      <h3 class="product-title">${product.name}</h3>
      <p class="product-details">Description: ${product.description}</p>
      <p id="product-Type">Category ID: ${product.categoryID}</p>
      <p class="product-price">Price: ${product.price}</p>
      <button class="add-to-cart" onclick="addToCart()">Add to Cart </button>
    
  </div>
`).join('');



    // Add the HTML markup to the container
    container.innerHTML = productsHTML;


    var productCards = document.getElementsByClassName("product");


    Array.from(productCards).forEach(function(card) {
        var titleElement = card.querySelector(".product-title");
        var productId = parseInt(card.id.replace("product-", ""));

        titleElement.addEventListener("click", function() {
            window.location.href = "/product?id=" + productId;
        });
    });

}

// Display all products initially
//displayProducts(products);

// Function to filter products based on price range
function applyPriceFilter() {

    /*
    var priceRange = document.getElementById("priceRange").value;

    var filteredProducts = products.filter(function(product) {
        return product.price <= priceRange;
    });

    displayProducts(filteredProducts);*/

    var priceRange = document.getElementById("priceRange").value;

    fetch('/all/prods?price=' + encodeURIComponent(priceRange))
        .then(response => response.json())
        .then(data => {
            // Process the retrieved data
            displayProducts(data);
        })
        .catch(error => console.error(error));
}

// Function to filter products based on type
function applyTypeFilter() {
    /*
    var productType = document.getElementById("productType").value;

    var filteredProducts;
    if (productType === "All") {
        filteredProducts = products;
    } else {
        filteredProducts = products.filter(function(product) {
            return product.type === productType || productType === "";
        });
    }

    displayProducts(filteredProducts);*/

    var productType = document.getElementById("productType").value;

    if (productType === "All")
    {
        fetch('/all')
            .then(response => response.json())
            .then(data => {
                // Process the retrieved data
                displayProducts(data);
            })
            .catch(error => console.error(error));

    }
    else
    {
        fetch('/all?type=' + encodeURIComponent(productType))
            .then(response => response.json())
            .then(data => {
                // Process the retrieved data
                displayProducts(data);
            })
            .catch(error => console.error(error));
    }



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

// Fetch products from the database using an AJAX request
function fetchProducts() {
    fetch("/all")
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            displayProducts(data);
        })
        .catch(function(error) {
            console.log(error);
        });
}

// Call the fetchProducts function to retrieve and display the products
fetchProducts();