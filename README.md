# Tittle of the Proyect: Swap it!
## Table of Content

- [Phase 0](#Pre-Requisites/phase-0)
    + [Authors](#authors)
    + [Sections description](#sections-description)
      - [Entities](#entities)
      - [Users and permissions](#users-and-permissions)
      - [Images](#images)
      - [Graphics](#graphics)
      - [Complementary technology](#complementary-technology)
      - [Advanced Algorithmic](#advanced-algorithmic)
- [Phase 1](#phase-1)
    + [Screenshots](#screenshots)
    + [Navigation Diagram](#navigation-Diagrams)
- [Phase 2](#phase-2)
    + [Navigation Screenshoots](#navigation-Screenshots)
    + [Development Instructions](#Development-Instructions)
    + [BD Entity Diagram](#BD-Entity-Diagram)
    + [Class Diagram and Templates](#Class-Diagram-and-Templates)
- [Phase 3](#phase-3)
    + [REST API Documentation](#REST-API-Documentation)
    + [BD Entity Diagram](#BD-Entity-Diagram)
    + [Class Diagram and Templates](#Class-Diagram-and-Templates)
- [Phase 4](#phase-4)
    + [Development Enviroment](#Development-Enviroment)
    + [Class Diagram and Templates](#Class-Diagram-and-Templates)
    + [Member Participation](#Member-Participation)
    + [Youtube Video](#Youtube-Video)
    



Our purpose is to create an APP web to sell second-hand clothes through a monetary change or virtual money to use in the same APP.

## Begining

If you want get a copy of our proyect to development and testing you will download the project in: https://github.com/CodeURJC-DAW-2019-20/webapp3.git


## Pre-Requisites / Phase 0 

The name of the App Web is Swap It!

We recommend the use of Brackets to change de code of the APP Web.

### Entities

The entities could be User Types and Second Entities.

### User Types


* Admin User: Each of the managers of the App Web, responsible for the control of the proper functioning of the App.  A Registered User do a request to a Admin User to upload a product. If the admin check the request and all are ok, the product will upload.

* Registered User: A person who can sell or buy something in the App Web. They must register, their id will become their NID and they must choose a alphanumeric password.


* Anonymous User: A person who can only see the published information in the App Web.


### Second Entities

* Product: Our products are clothes and accessories which people can sell or/and buy in the App Web.

* Complain: A Registered User do a complain to other Register User or product. If the admin check the complain and find a problem, the Registeres User could be penalized and even expelled from the Registered Users.

* Transfer: A transfer is the relation between a Registered User and a product, also could have a complain if the buyer isn't according with the bought product.

* To Buy: Web App products can be bought.

* To Sell: New products can be added to be sold in the App Web.

An example of relation, is Registered User buys Product, or Registered User sells Product in the APP web.

An anonymous user that has registered it in the App Web becomes a Registered User. A Registered User after logging in can buy products, check his historical movements or upload products to sell. 


### Pictures

The App Web must allow to upload pictures, for example, a Registered User wants to change his user avatar.

Always the uploaded product will be accompanied with its respective photo.

### Graphics

In the profile a Registered User can see their expenses and benefits in form of graphics.


### Complementary Technology

In this moment we don't use any complementary technology, but in the future we will use it. For example, the database that collects all the information.

### Advanced Query Algorithm

We will use a Advanced Query Algorithm to recommend products to a customer based on their previous purchases.

## Phase 1 

### Screenshots

Our Start Page is **index.html**, in this page you can see the categories of the Sales App Web, the new products, the acess to the profile section, the opening month offer, the record to the news and another themes.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/Index1.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/Index2.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/Index3.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/Index4.png)

In the page product we can see a particular product with its details and other similar products.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/product1.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/product2.png)

In the Profile page we can change our information and we can see the graphics about our expenses and incomes, also we can see recommended articles based on our purchases.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/profile1.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/profile2.png)

In the checkout page we can finish a purchase introducing tha address data and payment details.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/Checkout.png)

By last, the store page show a lot of products and filters to search a particular product according to the search wish of the customer.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/store.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/store1.png)

### Navigation Diagrams

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/img/Diagrama.png)

## Phase 2

### Navigation Screenshots

Our Start Page is **index.html**, in this page you can see the categories of the Sales App Web, the new products, the acess to the profile section, the opening month offer, the record to the news and another themes.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Annexed/screenshot/Index5.png)

In the page product we can see a particular product with its details and other similar products.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Annexed/screenshot/product3.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-1/HTML%20y%20CSS/screenshot/product2.png)

In the Profile page we can change our information and we can see the graphics about our expenses and incomes, also we can see recommended articles based on our purchases.

AdminUser
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Annexed/screenshot/profile3.png)

BasicUser
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Annexed/screenshot/profile4.png)

In the checkout page we can finish a purchase introducing tha address data and payment details.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Annexed/screenshot/Checkout1.png)

By last, the store page show a lot of products and filters to search a particular product according to the search wish of the customer.

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Annexed/screenshot/store2.png)


### Navigation Diagram

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Backend/src/main/resources/static/img/Diagrama4.png)

### Development Instructions

1. Create the html template with CSS and JS
2. Create a spring project with maven and web dependencies, jpa, h2, mustache.
3. Create in resources a static folder and another of templates.
4. We put all our css, js, images and static elements that we already had in the static folder.
5. We have to put the html in the templates folder because we will use mustache and it is the configuration that it requires.
6. We will have to change the links to all the css, js from the html because the static address does not work, so we will have to put, for example, /css/bootstrap.min.css
7. In the application.properties file we add: a. spring.mustache.suffix = .html i. so that mustache understands the .html files. b. spring.h2.console.enabled = true i. For h2 to work.
8. We tried to make everything work.
9. To see that the bbdd works, we load localhost: port / h2-console and on the screen that comes out, we will have to leave everything the same changing what is in JDBC URL by jdbc: h2:        mem: testdb and should connect and see the administrator of the bbdd. 10 .The project could already be uploaded to github, because it works, even if it doesn't detect the links between      html (index load only).

### BD Entity Diagram

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Backend/src/main/resources/static/img/Diagrama1.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Backend/src/main/resources/static/img/Diagrama2.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Backend/src/main/resources/static/img/Diagrama3.png)

### Class Diagram and Templates

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-2/Backend/src/main/resources/static/img/Diagrama5.png)

## Phase 3 
### REST API documentation
Document [Api documentation](API.md) with information about the REST API.

### BD Entity Diagram

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-3/Backend/src/main/resources/static/img/Diagrama1.png)
![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-3/Backend/src/main/resources/static/img/Diagrama2.png)

### Class Diagram and Templates

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-3/Backend/src/main/resources/static/img/Diagrama3.png)

## Phase 4

### Development Enviroment

1. The first step is installing node.js, npm and angular cli. With all this correctly installed, we can create a new angular proyect in the IDE you are working on. 
2. The next step is creating all the configuration necessary to create each module.
3. Each part is in a folder with a component.ts where is all the logic connected with a componen.html, also a component.css with the style for this html and service.ts where you make the get, post, put or delete request to the API.
4. You can modify the html template making it more beautiful using ng-material, Bootstrap or primeng. The last step, if you want to upload to Docker.
5. ```DOCKER:``` add the node.js container to Docker-compose and in the dockerfile, add the configuration for doing ng-build.
6. Last step, there is an angular application connected with an api, and working all of this in Docker, with an springboot backend and an independent front with mustache.

### Class Diagram and Templates

![](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/Fase-4/SPA-app/src/assets/img/DiagramaFase4.png)

### Member Participation

| Name | Mail | Github user| % Participation |
|--------|--------|------------|---------|
|Javier Barrio Mart�n | j.barrio.2016@alumnos.urjc.es | (https://github.com/JaviBarrio6) | 100 % |
|Maria Gutierrez| m.gutierrezt.2016@alumnos.urjc.es | (https://github.com/Mariagt97) | 100 % |
|Alejandro Aguilar | a.aguilarf.2016@alumnos.urjc.es | (https://github.com/Aaguilarf) | 100 % |
|David Roble | d.robles.2016@alumnos.urjc.es | (https://github.com/davidrobl) | 100 % |
|Alvaro Noguerales | j.noguerales.2016@alumnos.urjc.es | (https://github.com/Anogue) | 0 % |

### Youtube Video
 
 https://youtu.be/lVchevc75ME

## Installation

If you want to execute the project you must open it with a browser.

```
Open index.HTML with a browser
```


## Executing the tests

To test the App Web you can try to interact with the elements of the APP Web. 


## Built with

* [Brackets](http://brackets.io/) - The text editor that we used
* [Trello](https://trello.com/b/7tXmEA17/daw) - To manager the task that we must do in this phase.

## Versioned

We use **HTML5** to design the format of the APP Web and **CSS3** to add styles. 

## Authors

* **Javier Barrio Mart�n** - *Programmer* - [Git Account](https://github.com/JaviBarrio6) - Mail: j.barrio.2016@alumnos.urjc.es
* **Maria Gutierrez** - *Programmer* - [Git Account](https://github.com/Mariagt97) - Mail: m.gutierrezt.2016@alumnos.urjc.es
* **Alejandro Aguilar** - *Programmer* - [Git Account](https://github.com/Aaguilarf) - Mail: a.aguilarf.2016@alumnos.urjc.es
* **David Robles** - *Programmer* - [Git Account](https://github.com/davidrobl) - Mail: d.robles.2016@alumnos.urjc.es
* **Alvaro Noguerales** - *Programmer* - [Git Account](https://github.com/Anogue) - Mail: j.noguerales.2016@alumnos.urjc.es


If you check the list with all the contributors you will check [contributors](https://github.com/CodeURJC-DAW-2019-20/webapp3/graphs/contributors).

## Licency

This project is down the licency [LICENSE.md](https://github.com/CodeURJC-DAW-2019-20/webapp3/blob/master/LICENSE) for details


