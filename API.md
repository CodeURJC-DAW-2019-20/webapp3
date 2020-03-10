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
	"country":"España",
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
	"country":"España",
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
	"city":"Mostoles","country":"España",
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
	"country":"España",
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
	"country":"España",
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
	"detail":"tiene botones en los puños de las mangas y en el cuello"
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
	"detail":"tiene botones en los puños de las mangas y en el cuello"
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

* ##### Método:

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


