[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
<h1 align="center" style="font-weight: bold;">VeniMarket API </h1>
<div align="center">
  
![spring][SPRING_BADGE]
![java][JAVA_BADGE]
<img src="https://img.shields.io/badge/H2 Database-darkblue?style=for-the-badge&logo=java" alt="Sistema Mercado">
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
	![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
 <img src="https://img.shields.io/badge/Version 2.0-gray?style=for-the-badge&logo=java" alt="Sistema Mercado">
</div>
<p align="center">
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#database">Database</a> •
   <a href="#br">Business Rules</a> •
  <a href="#dockerfile">Dockerfile</a> •
</p>
<p align="center">
  <b>This is a simple API that you can use in your retail software.</b>
</p>
<h2 id="started">🚀 Getting started</h2>
<p>If you want just use the API for your front-ends projects, download the <a href="https://drive.google.com/drive/folders/1RDBeI_3PHm5evwipRkZmRlu-96NUJv8b?usp=sharing">api-venimarket.jar</a> file.</p>
<p>To take a look, modify and debug the code in your IDE, clone this repository:</p>

```bash
git clone https://github.com/Venicode/venimarket-api.git
```

<h3>Prerequisites</h3>

<p>To running this project, you must have all prerequisites below:</p>

- Java SDK 17+

<h3>Starting</h3>

<p>When download to <a href="https://www.transfernow.net/dl/202406204jSKnS5V">api-venimarket.jar</a> is done, move this file whatever you want and open a command prompt. Then, check the path's file and type the command below:</p>

```bash
C:\path\to\file>java -jar api-venimarket.jar
```
<p>If you do this correctly, the api server will run: </p>

![spring-print](https://github.com/Venicode/venimarket-api/assets/44931124/5d40b74f-bea1-4430-ae67-240d5fd4b0ab)

<p>After that, you can access the swagger page: <a href="http://localhost:8080/swagger-ui/index.html#/">http://localhost:8080/swagger-ui/index.html#/</a></p>

<h2 id="routes">📍 API Endpoints</h2>

<p>Example to request something: <a href="http://localhost:8080/supplier">http://localhost:8080/supplier</a></p>
<p>All endpoints that you can use in the application group by entities:</p>

<p>Supplier Endpoints</p>

```

GET /supplier - Retrieve a list of all suppliers.

GET /supplier/{id} - Retrieve a specific supplier by ID.

POST /supplier - Register a new supplier.

PUT /supplier/{id} - Update the supplier informations.

DELETE /supplier/{id} - Delete(disable changing isActive=false) a specific supplier by ID.

```

<p>Product Category Endpoints</p>

```

GET /productCategory - Retrieve a list of all product categories.

GET /productCategory/{id} - Retrieve a specific product category by ID.

POST /productCategory - Register a new product category.

PUT /productCategory/{id} - Update the product category informations.

DELETE /productCategory/{id} - Delete a specific product category by ID.

```

<p>Product Endpoints</p>

```

GET /product - Retrieve a list of all products.

GET /product/{barcode} - Retrieve a specific product by barcode.

POST /product - Register a new product.

PUT /product/{id} - Update the product informations.

DELETE /product/{id} - Delete(disable changing isActive=false) a specific product by ID.

```

<p>Method Payment Endpoints</p>

```

GET /methodPayment - Retrieve a list of all method payments.

GET /methodPayment/{id} - Retrieve a specific method payment by ID.

GET /methodPayment/descriptionMethodPayment/{descriptionMethodPayment} - Retrieve a specific method payment by description.

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

<p>Order Endpoints</p>

```

GET /order - Retrieve a list of all orders.

POST /order - Register a new order.

```

<p>Item Order Endpoints</p>

```

GET /itemOrder - Retrieve a list of all item orders.

POST /itemOrder - Register a new item order.

```

<h2 id="database">📝 Database</h2>

<p>For this project, I chose the H2 Database, it stores data in memomy, being ideal for testing, where it doesn't not persist the data on disk. So, when closing the terminal, all data will be lost.</p>

<h2 id="br">⛔ Business Rules</h2>

<p>When you register a new sell, if it's your first once, a new cash register will be created. But, in your second sell, the balance will be added, unless you close the cash register. If the last cash register is closed, a new one will be created.</p>

<h2 id="dockerfile">⬇️ Dockerfile</h2>

<p>If you are familiar with Docker, be comfortable to download the image about this project: <a href="https://hub.docker.com/r/venitt/api-venimarket">Download docker file</a></p>
<p>Then, just execute the command below in your command prompt or in your virtual machine:</p>

```
docker pull venitt/api-venimarket
```
