# Выпускной проект Topjava

Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.

The task is:

Build a voting system for deciding where to have lunch.

2 types of users: admin and regular users
Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
Menu changes each day (admins do the updates)
Users can vote on which restaurant they want to have lunch at
Only one vote counted per user
If user votes again the same day:
If it is before 11:00 we assume that he changed his mind.
If it is after 11:00 then it is too late, vote can't be changed
Each restaurant provides a new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it.

P.S.: Make sure everything works with latest version that is on github :)

P.P.S.: Assume that your API will be used by a frontend developer to build frontend on top of that.
______________________________________
curl commands:

<h3>Restaurant</h3>

<h5>GET all restaurants:</h5>
curl -s http://localhost:8080/api/restaurants --user Admin:admin

<h5>GET restaurant:</h5>
curl -s http://localhost:8080/api/restaurants/8 --user Admin:admin

<h5>CREATE restaurant:</h5>
curl -s -X POST -d '{"name":"New_Restaurant","description":"Description for a new restaurant"}' -H 
'Content-Type:application/json;charset=UTF-8' 
http://localhost:8080/api/restaurants --user Admin:admin

<h5>UPDATE restaurant:</h5>
curl -s -X PUT -d '{"name":"Update_Restaurant","description":"Description for update restaurant"}' -H
'Content-Type:application/json;charset=UTF-8'
http://localhost:8080/api/restaurants/12 --user Admin:admin

<h5>DELETE restaurant:</h5>
curl -s -X DELETE http://localhost:8080/api/restaurants/8 --user Admin:admin


<h3>DISH</h3>

<h5>GET all dishes:</h5>
curl -s http://localhost:8080/api/dishes --user Admin:admin

<h5>GET dish:</h5>
curl -s http://localhost:8080/api/dishes/26 --user Admin:admin

<h5>GET all dishes for restaurant:</h5>
curl -s http://localhost:8080/api/dishes/restaurant/4 --user Admin:admin
curl -s http://localhost:8080/api/dishes/restaurant/4 --user User:1111

<h5>DELETE dish:</h5>
curl -s -X DELETE http://localhost:8080/api/dishes/16 --user Admin:admin

<h5>CREATE dishes:</h5>
curl -s -X POST -d '{"name":"New_dish","price":"123.44", "restaurnat": {"id": "7", "name":"BAR:DOT XX1","description":"Hotel Restaurant, Asian, Fusion"}' -H
'Content-Type:application/json;charset=UTF-8'
http://localhost:8080/api/dishes --user Admin:admin

<h5>UPDATE dishes:</h5>
curl -s -X PUT -d '{"id":"15", "name":"update_dish","price":"123.44"}' -H
'Content-Type:application/json;charset=UTF-8'
http://localhost:8080/api/dishes/15 --user Admin:admin

<h3>USER</h3>

<h5>GET account:</h5>
curl -s http://localhost:8080/api/account/ --user User:1111

<h5>GET REGISTER account:</h5>
curl -s http://localhost:8080/api/account/register 

<h5>UPDATE account:</h5>
curl -s -X PUT -d '{"id":"3", "name":"User2_update","password":"user_update"}' -H
'Content-Type:application/json;charset=UTF-8'
http://localhost:8080/api/account --user Admin:admin

<h5>DELETE account:</h5>
curl -s -X DELETE http://localhost:8080/api/account --user User:1111


