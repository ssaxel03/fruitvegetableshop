# Fruits and Vegetables Shop

## Description
This REST API was developed in 3 hours as part of a technical exercise for an interview. It is a fruits and vegetables shop that allows users to:
- Create, read, and update products.
- Buy or sell products to the shop.
- Check the wallet balance of the shop.
- List all transactions.

Currently deployed [here](https://fruitvegetableshop.onrender.com).

## Technologies Used
- Java
- Spring Boot
- H2 Database

## Installation
To run the application, use the following command:
```sh
mvn spring-boot:run
```

## API Endpoints
- `GET /products` - List all products.
- `POST /products` - Create a new product.
- `GET /products/{id}` - Get details of a specific product.
- `GET /transactions` - List all transactions.
- `POST /transactions` - Create a new transaction (buy/sell).
- `GET /transactions/{id}` - Get details of a specific transaction.
- `GET /transactions/type/{type}` - Get transactions filtered by type (BUY/SELL).
- `GET /wallet` - Get the current wallet balance.

## Usage Example
Example of buying a product via a POST request:

```javascript
const transaction = {
    "customerName": "Axel",
    "product": {
        "id": 1
    },
    "quantity": 1,
    "value": 1.6,
    "type": "BUY"
};

try {
    const response = await fetch(`${url}transactions`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(transaction)
    });

    if (!response.ok) {
        throw new Error(`Failed to buy product`);
    }

    const result = await response.json();
    console.log("Transaction done:", result);
} catch (error) {
    console.error('Error adding product:', error);
}
```

## Known Issues & TODOs
- The shop has infinite stock (no inventory management yet).
- A `TransactionDTO` should be implemented to simplify API requests and fix incorrect values in transactions (currently dependent on client).
- Transactions should support multiple products.
- The wallet balance does not persist across restarts.

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for more informtion.
