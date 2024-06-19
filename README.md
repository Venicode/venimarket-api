[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
<h1 align="center" style="font-weight: bold;">Venimarket API </h1>
<div align="center">
  
![spring][SPRING_BADGE]
![java][JAVA_BADGE]

</div>
<p align="center">
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#database">Collaborators</a> •
</p>
<p align="center">
  <b>This is a simple API that you can use in your retail software.</b>
</p>
<h2 id="started">🚀 Getting started</h2>
<p>If you want just use the API for your front-ends projects, download the <a href="https://drive.google.com/drive/folders/14FDmYUURd62mjfDeMsx2zKf0HNrXvsjS?usp=sharing">api-venimarket.jar</a> file.</p>
<p>To take a look, modify and debug the code in your IDE, clone this repository:</p>

```bash
git clone https://github.com/Venicode/venimarket-api.git
```

<h3>Prerequisites</h3>

<p>To running this project, you must have all prerequisites below:</p>

- Java SDK 17+

<h3>Starting</h3>

<p>When download to api-venimarket.jar is done, move this file whatever you want and open a prompt command. Then, check the path's file and type the command below:</p>

```bash
C:\path\to\file>java -jar api-venimarket.jar
```
If you do this correctly, the api server will run:

![spring-print](https://github.com/Venicode/venimarket-api/assets/44931124/5d40b74f-bea1-4430-ae67-240d5fd4b0ab)

After that, you can access the swagger page: http://localhost:8080/swagger-ui/index.html#/

<h2 id="routes">📍 API Endpoints</h2>

All endpoints that you can use in the application group by entitys:

<p>Supplier Endpoints</p>

```

GET /supplier - Retrieve a list of all suppliers.

GET /supplier/{id} - Retrieve a specific supplier by ID.

POST /supplier - Register a new supplier.

PUT /supplier/{id} - Update the supplier informations.

DELETE /supplier/{id} - Delete(disable changing isActive=false) a specific supplier by ID.

```

<p>Product Endpoints</p>

```

GET /product - Retrieve a list of all products.

GET /product/{id} - Retrieve a specific product by ID.

POST /product - Register a new product.

PUT /product/{id} - Update the product informations.

DELETE /product/{id} - Delete(disable changing isActive=false) a specific product by ID.

```

<p>Method Payment Endpoints</p>

```

GET /methodPayment - Retrieve a list of all method payments.

GET /methodPayment/{id} - Retrieve a specific method payment by ID.

POST /methodPayment - Register a new method payment.

PUT /methodPayment/{id} - Update the method payment informations.

DELETE /methodPayment/{id} - Delete a specific method payment by ID.

```

<p>Customer Endpoints</p>

```

GET /customer - Retrieve a list of all customers.

GET /customer/{id} - Retrieve a specific customer by ID.

POST /customer - Register a new customer.

PUT /customer/{id} - Update the customer informations.

DELETE /customer/{id} - Delete(disable changing isActive=false) a specific customer by ID.

```

<p>Cash Register Endpoints</p>

```

GET /cashRegister - Retrieve a list of all cash registers.

PUT /cashRegister/CloseCashRegister/{id} - Close a specific cash register by Id.


```

<p>Sell Endpoints</p>

```

GET /sell - Retrieve a list of all sells.

POST /customer - Register a new sell.

```

<h2 id="database">Database</h2>

<p>For this project, I choose the H2 Database, it stores data in memomy, being ideal for testing, it doesn't not persist the data on disk. So, when closing the terminal, all data will be lost.</p>
