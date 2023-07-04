// Fetch cart items using cart controller
fetchCartItems();
function fetchCartItems(){
    fetch('/cart/view')
        .then(response => response.json())
        .then(data => {
            console.log(JSON.stringify(data))
            // Process the retrieved data
            displayCartItems(data);
        })
        .catch(error => console.error(error));
}
function displayCartItems(cartItems) {
    // Access the product-container element
    //const productList = document.getElementById('product-list');
    if(cartItems==null){
        document.getElementById('cart-items').style.display='block';
        document.getElementById('shopping-cart-table').style.display='none';

        document.getElementById('cart-message').innerHTML='Your cart is empty.';
        document.getElementById('cart-actions').innerHTML="<a class=\"cart-read\" href=\"/products\">" +
                                                            "Start shopping!" +
                                                            "</a></div>";
    }
    else {
        document.getElementById('cart-items').style.display='none';
        document.getElementById('shopping-cart-table').style.display='block';

        const tableContainer = document.getElementById('shopping-cart-tablebody');
        // Create HTML markup for each product
        const productTableHTML = cartItems.map(cartItem => `
        <tr>
            <td>
            <img src="${cartItem.imageSource}" alt="${cartItem.name}" width="50px">
            </td>
            <td>${cartItem.name}</td>
            <td>${cartItem.quantity} piece(s)</td>
        </tr>
    `).join('');
        tableContainer.innerHTML = productTableHTML;


    }
}