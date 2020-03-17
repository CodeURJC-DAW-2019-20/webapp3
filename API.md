# SWAP IT- API REST Documentation

## About our API
All you can find in our API Rest is information about users, products, suggestions and transactions. All you need to do is simply; you have to follow the API rules. If you try to do following a different way, it's probably what you will recieve an error.

## How to use our API
1. Download [Postman](https://www.getpostman.com/).
2. You only can send GET, POST, PUT and DELETE requests.

## API requests

### Resources
The resource API has GET, POST, PUT and DELETE methods.
http: // localhost: 8443 followed by the containt request URL.

**All API queries have been preceded by /api**

## USERS
The following queries will be preceded by /user. 

#### Register
Allows a user to register.

* ##### URL:

	< /register >

* ##### Method:

	`POST`
* ##### Data Params

	```
	"name":"alex",
	"lastname":"aguilar",
	"passwordHash":"alex",
	"email":"swapitserver@gmail.com",
	"address":"C/ Martinez 34",
	"city":"Mostoles",
	"country":"Espa�a",
	"cp":"12496",
	"phone":"689520446"
	```	

  

	
#### Validate mail  
Allows to validate a user's account.

* ##### URL Params:
	* name=[string]	
	
* ##### Example of query:

	* URL
		
		`/api/user/validate?name=alex`
  
* ##### Method:

	`PUT`




#### Update data  
Modify a user's data.

* ##### URL:

	< /update >
	

* ##### Method:

	`PUT`

* ##### Data Params

	```
	"name":"user",
	"lastname":"Aguilar Fuertemoreno",
	"email":"swapitserver@gmail.com",
	"address":"C/ Martinez 34",
	"city":"Mostoles",
	"country":"Espa�a",
	"cp":"12496",
	"phone":"689520446"e":"689520446"
	```	

  

#### Delete User  
Delete one user.

* ##### URL Params:
	* name=[string]	
	
* ##### Example of query:

	* URL
		
		`/api/user/update?name=user`
  
* ##### Method:

	`DEL`



#### Add to favorite  
Add one product to favorite.

* ##### URL Params:
	* id=[int]	
	
* ##### Example of query:

	* URL
		
		`/api/user/addLikeIt?id=5`
  
* ##### Method:

	`PUT`
* ##### Data Params

	```
	"name":"alex"
	```	

#### Add to basket  
Add one product to favorite.

* ##### URL Params:
	* id=[int]	
	
* ##### Example of query:

	* URL
		
		`/api/user/addBasket?id=5`
  
* ##### Method:

	`PUT`
* ##### Data Params

	```
	"name":"alex"
	```	
* ##### Success respone:

	```
    {
        "id": 2,
        "name": "user",
        "passwordHash": "",
        "roles": [
            "ROLE_USER"
        ],
        "lastname": "user lastname",
        "email": "user@swapit",
        "address": "C/ Buenavista 5",
        "city": "Mostoles",
        "country": "España",
        "cp": "28358",
        "phone": "619865541",
        "puntos": 100,
        "emailVerified": true,
        "login": false,
        "balance": 0.0,
        "productsBasket": [
            {
                "pageParameter": "page",
                "sizeParameter": "size",
                "oneIndexedParameters": false,
                "prefix": "",
                "qualifierDelimiter": "_",
                "defaultPageSize": 20,
                "maxPageSize": 2000,
                "id": 3,
                "name": "Sudadera Capucha",
                "color": "Multi",
                "category": "Jersey",
                "brand": "PullAndBear",
                "size": "M",
                "price": 200.0,
                "description": "",
                "detail": "",
                "verify": true,
                "inStock": true
            },
            {
                "pageParameter": "page",
                "sizeParameter": "size",
                "oneIndexedParameters": false,
                "prefix": "",
                "qualifierDelimiter": "_",
                "defaultPageSize": 20,
                "maxPageSize": 2000,
                "id": 8,
                "name": "Jersey Gris",
                "color": "Gris",
                "category": "Jersey",
                "brand": "Primark",
                "size": "M",
                "price": 140.0,
                "description": "",
                "detail": "",
                "verify": true,
                "inStock": true
            },
            {
                "pageParameter": "page",
                "sizeParameter": "size",
                "oneIndexedParameters": false,
                "prefix": "",
                "qualifierDelimiter": "_",
                "defaultPageSize": 20,
                "maxPageSize": 2000,
                "id": 5,
                "name": "Jersey Azul",
                "color": "Azul",
                "category": "Jersey",
                "brand": "Calvin Klein",
                "size": "M",
                "price": 200.0,
                "description": "",
                "detail": "",
                "verify": true,
                "inStock": true
            }
        ],
        "itemsILikeIt": 0,
        "itemsBasket": 3,
        "priceOfBasket": 540.0,
        "likekIts": []
    }
    ``` 

#### Read by name  
Read a user's data

* ##### URL Params:
	* name=[string]	
	
* ##### Example of query:

	* URL
		
		`/api/user/?name=user`
  
* ##### Method:

	`GET`

* ##### Success respone:

	```
	{
	"id":2,
	"name":"user",
	"passwordHash":"$2a$10$IAIETtm2biA9OTDKwDg45.lSyuBcoam0uynP8a2acze/dvsvciW9.",
	"roles":["ROLE_USER"],
	"lastname":"user lastname",
	"email":"user@swapit",
	"address":"C/ Buenavista 5",
	"city":"Mostoles","country":"Espa�a",
	"cp":"28358",
	"phone":"619865541",
	"puntos":100,
	"emailVerified":true,
	"login":false,
	"productsILikeIt":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
	"likekIts":[],
	"numberOfitemsILikeIt":0,
	"numberOfitemsBasket":0
	}
	```

#### Read all  
Read all user's data
	
* ##### URL:

	< /all >
	

* ##### Method:

	`GET`

* ##### Success respone:

	```
	{
	"id":1,	
	"name":"admin",
	"passwordHash":"$2a$10$0SBACOO01cHBk.D5iV9IOOS6kJoftVDy60trVPlsFYhmGchUFIx/C",
	"roles":["ROLE_USER","ROLE_ADMIN"],
	"lastname":"admin lastname",
	"email":"admin@swapit",
	"address":"C/ Sierra 52",
	"city":"Mostoles",
	"country":"Espa�a",
	"cp":"28358",
	"phone":"699256710",
	"puntos":999999,
	"emailVerified":true,
	"login":false,
	"productsILikeIt":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
	"likekIts":[],
	"numberOfitemsILikeIt":0,
	"numberOfitemsBasket":0},
	{"id":2,
	"name":"user",
	"passwordHash":"$2a$10$IAIETtm2biA9OTDKwDg45.lSyuBcoam0uynP8a2acze/dvsvciW9.",
	"roles":["ROLE_USER"],
	"lastname":"user lastname",
	"email":"user@swapit",
	"address":"C/ Buenavista 5",
	"city":"Mostoles",
	"country":"Espa�a",
	"cp":"28358",
	"phone":"619865541",
	"puntos":100,
	"emailVerified":true,
	"login":false,
	"productsILikeIt":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
	"likekIts":[],
	"numberOfitemsILikeIt":0,
	"numberOfitemsBasket":0}
	}
	```
  

 

## Product
The following queries will be preceded by /product. 
  
### Modify data
Modify product data.

* ##### URL Params:
	* id=[int]	
	
* ##### Example of query:

	* URL
		
		`/api/product/modify?id=6`
  
* ##### Method:

	`PUT`

* ##### Data Params

	```
	"name":"Jersey Burdeos",
	"color":"Burdeos",
	"category":"Jersey",
	"brand":"Zara",
	"size":"M",
	"description":"color burdepx oscuro",
	"detail":"tiene botones en los pu�os de las mangas y en el cuello"
	```	
	

  


### Create
Create a product.

* ##### URL:

	< /load >
	
* ##### Method:

	`POST`

* ##### Data Params

	```
	imagenFile: gatito.jpg
	```	
### Create image
Create a image.

* ##### URL:

	< /21/imagen >
	
* ##### Method:

	`POST`

* ##### Data Params

	```
	imagenFile: gatito.jpg
	```		

  

### Delete
Delete a product.

* ##### URL Params:
	* id=[int]	
	
* ##### Example of query:

	* URL
		
		`/api/product/modify?id=6`
  
* ##### Method:

	`DEL`
 

  
#### Read by id

Read a product by id.

* ##### URL Params:
	* id=[int]	
	
* ##### Example of query:

	* URL
		
		`/api/product/?id=4`
  
* ##### Method:

	`GET`

* ##### Success respone:

	```
	{
	"id":4,
	"name":"Jersey Mostaza",
	"color":"Mostaza",
	"category":"Jersey",
	"brand":"Zara",
	"size":"S",
	"price":300.0,
	"description":"",
	"detail":"",
	"verify":true,
	"inStock":true
	}
	```

#### Read stock
Read a product by id.
* ##### URL Params:
	* id=[int]	
	
* ##### Example of query:

	* URL
		
		`/api/product/?id=4`
  
* ##### Method:

	`GET`

* ##### Success respone:

	```
	{
	"id":4,
	"name":"Jersey Mostaza",
	"color":"Mostaza",
	"category":"Jersey",
	"brand":"Zara",
	"size":"S",
	"price":300.0,
	"description":"",
	"detail":"",
	"verify":true,
	"inStock":true
	}
	```
 #### Read image
 Read a image for a product.
 * ##### URL:
 
 	< /3/imagen >
 	
 
 * ##### Method:
 
 	`GET`
 
 * ##### Success respone:
 
 	```
 	{
 	image-3.jpg
 	image-3.jpg
 	}
 	```
### Validate
Validate a product.

* ##### URL Params:
	* id=[int]	
	
* ##### Example of query:

	* URL
		
		`/api/product/validate?id=21`
  
* ##### Method:

	`PUT`

* ##### Data Params

	```
	"name":"Jersey Burdeos",
	"color":"Burdeos",
	"category":"Jersey",
	"brand":"Zara",
	"size":"M",
	"description":"color burdepx oscuro",
	"detail":"tiene botones en los pu�os de las mangas y en el cuello"
	```	
#### Read Prestock
Read all prestock.
* ##### URL:

	< /prestock >
* ##### Method:

	`GET`

* ##### Success respone:

	```
	{
	
	}
	```	
#### Read stock
Read  stock page.
* ##### URL Params:
	* page=[int]	
	* size=[int]
* ##### Example of query:

	* URL
		
		`/api/product/stock/page?page=0&size=5`
  
* ##### Method:

	`GET`

* ##### Success respone:

	```
	{
	    {
                    "pageParameter": "page",
                    "sizeParameter": "size",
                    "oneIndexedParameters": false,
                    "prefix": "",
                    "qualifierDelimiter": "_",
                    "defaultPageSize": 20,
                    "maxPageSize": 2000,
                    "id": 3,
                    "name": "Sudadera Capucha",
                    "color": "Multi",
                    "category": "Jersey",
                    "brand": "PullAndBear",
                    "size": "M",
                    "price": 200.0,
                    "description": "",
                    "detail": "",
                    "verify": true,
                    "inStock": true
                },
                {
                    "pageParameter": "page",
                    "sizeParameter": "size",
                    "oneIndexedParameters": false,
                    "prefix": "",
                    "qualifierDelimiter": "_",
                    "defaultPageSize": 20,
                    "maxPageSize": 2000,
                    "id": 4,
                    "name": "Jersey Mostaza",
                    "color": "Mostaza",
                    "category": "Jersey",
                    "brand": "Zara",
                    "size": "S",
                    "price": 300.0,
                    "description": "",
                    "detail": "",
                    "verify": true,
                    "inStock": true
                },
                {
                    "pageParameter": "page",
                    "sizeParameter": "size",
                    "oneIndexedParameters": false,
                    "prefix": "",
                    "qualifierDelimiter": "_",
                    "defaultPageSize": 20,
                    "maxPageSize": 2000,
                    "id": 5,
                    "name": "Jersey Azul",
                    "color": "Azul",
                    "category": "Jersey",
                    "brand": "Calvin Klein",
                    "size": "M",
                    "price": 200.0,
                    "description": "",
                    "detail": "",
                    "verify": true,
                    "inStock": true
                },
                {
                    "pageParameter": "page",
                    "sizeParameter": "size",
                    "oneIndexedParameters": false,
                    "prefix": "",
                    "qualifierDelimiter": "_",
                    "defaultPageSize": 20,
                    "maxPageSize": 2000,
                    "id": 6,
                    "name": "Jersey Burdeos",
                    "color": "Burdeos",
                    "category": "Jersey",
                    "brand": "Zara",
                    "size": "M",
                    "price": 300.0,
                    "description": "",
                    "detail": "",
                    "verify": true,
                    "inStock": true
                },
                {
                    "pageParameter": "page",
                    "sizeParameter": "size",
                    "oneIndexedParameters": false,
                    "prefix": "",
                    "qualifierDelimiter": "_",
                    "defaultPageSize": 20,
                    "maxPageSize": 2000,
                    "id": 7,
                    "name": "Jersey Blanco",
                    "color": "Blanco",
                    "category": "Jersey",
                    "brand": "HyM",
                    "size": "M",
                    "price": 200.0,
                    "description": "",
                    "detail": "",
                    "verify": true,
                    "inStock": true
                }
            ],
            "pageable": {
                "sort": {
                    "sorted": false,
                    "unsorted": true,
                    "empty": true
                },
                "offset": 0,
                "pageSize": 5,
                "pageNumber": 0,
                "unpaged": false,
                "paged": true
            },
            "totalElements": 9,
            "totalPages": 2,
            "last": false,
            "size": 5,
            "number": 0,
            "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
            },
            "numberOfElements": 5,
            "first": true,
            "empty": false
        }
	}
	```	
#### Filter
Filter products.
* ##### URL Params:
	* categorys=[string]	
	* size=[int]
	* minPrice=[int]
	* maxPrice=[int]
	* brands=[string]
* ##### Example of query:

	* URL
		
		`/api/product/filter?categorys=Jersey&minPrice=100&maxPrice=300&brands=Primark`
  
* ##### Method:

	`GET`

* ##### Success respone:

	```  
    {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 10,
            "name": "Jersey A Rayas",
            "color": "Multi",
            "category": "Jersey",
            "brand": "Primark",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 8,
            "name": "Jersey Gris",
            "color": "Gris",
            "category": "Jersey",
            "brand": "Primark",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        }
        ``` 
#### Order by name
Order all products by name.

* ##### URL:

	* URL
		
		`/order/name`
  
* ##### Method:

	`GET`

* ##### Success respone:

	```  
    {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 11,
            "name": "Camisa Pana",
            "color": "Azul",
            "category": "Camisa",
            "brand": "PullAndBear",
            "size": "M",
            "price": 300.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 10,
            "name": "Jersey A Rayas",
            "color": "Multi",
            "category": "Jersey",
            "brand": "Primark",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 5,
            "name": "Jersey Azul",
            "color": "Azul",
            "category": "Jersey",
            "brand": "Calvin Klein",
            "size": "M",
            "price": 200.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 7,
            "name": "Jersey Blanco",
            "color": "Blanco",
            "category": "Jersey",
            "brand": "HyM",
            "size": "M",
            "price": 200.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 6,
            "name": "Jersey Burdeos",
            "color": "Burdeos",
            "category": "Jersey",
            "brand": "Zara",
            "size": "M",
            "price": 300.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 8,
            "name": "Jersey Gris",
            "color": "Gris",
            "category": "Jersey",
            "brand": "Primark",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 4,
            "name": "Jersey Mostaza",
            "color": "Mostaza",
            "category": "Jersey",
            "brand": "Zara",
            "size": "S",
            "price": 300.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 9,
            "name": "Jersey Rosa",
            "color": "Rosa",
            "category": "Jersey",
            "brand": "Lefties",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 3,
            "name": "Sudadera Capucha",
            "color": "Multi",
            "category": "Jersey",
            "brand": "PullAndBear",
            "size": "M",
            "price": 200.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        }
        ```  
 #### Order by price
 Order all products by price.
 
 * ##### URL:
 
 	* URL
 		
 		`/order/price`
   
 * ##### Method:
 
 	`GET`
 
 * ##### Success respone:
 
 	``` 
    {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 8,
            "name": "Jersey Gris",
            "color": "Gris",
            "category": "Jersey",
            "brand": "Primark",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 9,
            "name": "Jersey Rosa",
            "color": "Rosa",
            "category": "Jersey",
            "brand": "Lefties",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 10,
            "name": "Jersey A Rayas",
            "color": "Multi",
            "category": "Jersey",
            "brand": "Primark",
            "size": "M",
            "price": 140.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 3,
            "name": "Sudadera Capucha",
            "color": "Multi",
            "category": "Jersey",
            "brand": "PullAndBear",
            "size": "M",
            "price": 200.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 5,
            "name": "Jersey Azul",
            "color": "Azul",
            "category": "Jersey",
            "brand": "Calvin Klein",
            "size": "M",
            "price": 200.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 7,
            "name": "Jersey Blanco",
            "color": "Blanco",
            "category": "Jersey",
            "brand": "HyM",
            "size": "M",
            "price": 200.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 4,
            "name": "Jersey Mostaza",
            "color": "Mostaza",
            "category": "Jersey",
            "brand": "Zara",
            "size": "S",
            "price": 300.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 6,
            "name": "Jersey Burdeos",
            "color": "Burdeos",
            "category": "Jersey",
            "brand": "Zara",
            "size": "M",
            "price": 300.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        },
        {
            "pageParameter": "page",
            "sizeParameter": "size",
            "oneIndexedParameters": false,
            "prefix": "",
            "qualifierDelimiter": "_",
            "defaultPageSize": 20,
            "maxPageSize": 2000,
            "id": 11,
            "name": "Camisa Pana",
            "color": "Azul",
            "category": "Camisa",
            "brand": "PullAndBear",
            "size": "M",
            "price": 300.0,
            "description": "",
            "detail": "",
            "verify": true,
            "inStock": true
        }
## Suggestions
The following queries will be preceded by /suggestion.
 
#### Create
Create a suggestion.
* ##### URL

	< />

* ##### Method:

	`GET`
	
* ##### Success respone:

	```
	{
	"name":"Alberto",
	"lastname":"Garcia",
	"email":"AlbG@hotmail.com",
	"message":"La pagina pagina tiene muchos errore"
	}
	```
  

  
#### Delete
Delete a suggestion.

* ##### URL

	< />

* ##### M�todo:

	`DEL`
  

* ##### Success response:
	```
	{
	"name":"Alberto",
	"lastname":"Garcia",
	"email":"AlbG@hotmail.com",
	"message":"La pagina pagina tiene muchos errore"
	}
	```
		

#### Read all
Read all suggestions.
* ##### URL

	< />

* ##### Method:

	`GET`
  

* ##### Success response:
	```
	{
	"name":"Alberto",
	"lastname":"Garcia",
	"email":"AlbG@hotmail.com",
	"message":"La pagina pagina tiene muchos errore"
	}
	```

## Transaction

#### Read by name
Read a transaction by name.

* ##### URL Params:
	* name=[string]	
	
* ##### Example of query:

	* URL
		
		`/transaction/?name=user`
  
* ##### Method:

	`GET`
  

* ##### Success response:
	```
	{
	"['09/03/2020',
 	'01/03/2020',
 	'29/02/2020']",
	"[1, 2, 4]",
	"['09/03/2020']",
	"[1]"
	}
	```	


