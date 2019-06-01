# spring-booted-endpoints
<h1> Monitored Endpoints Created in Spring Boot 2.0+ </h1>
<p> This Spring Boot project was coded to provide a microservice application for monitoring URL endpoints. <br />
<b> Dependencies: Web, JPA, Actuator, MySQL </b>
</p>
  <h2> REST API Operations </h2>
  <h3> <li> User CRUD Calls </li> </h3>   
 
| Method | Description | Endpoint |
| :---   |     :---:   |     ---: |
| GET | Returns all users | /api/users |
| GET | Returns a specific user of this {id} | /api/users/{id} |
| GET | Returns the first number of {n} users in a descending order | /api/users={n} |
| POST | Inserts a new user | /api/users |
| PUT | Updates a user by providing the specific {id} in the URI | /api/users/{id} |
| PUT | Updates a user by providing the specific ID in the JSON payload | /api/users |
| DELETE | Deletes a user by providing the specific {id} in the URI | /api/users/{id} |

<h3> <li> MonitoredEndpoints CRUD Calls </li> </h3>

| Method | Description | Endpoint |
| :---   |     :---:   |     ---: |
| GET | Returns all existing endpoints | /api/users/endpoints |
| GET | Returns a specific endpoint of this {id} | /api/users/endpoints/{id} |
| GET | Returns the first number of {n} users in a descending order | /api/users/endpoints={n} |
| GET | Returns all existing endpoints for a specific {userId} | /api/users/{userId}/endpoints |
| GET | Returns {n} number of endpoint for a specific {userId} | /api/users/{userId}/endpoints={n} |
| GET | Returns all the endpoints of an owner for a specified {userId} and the correctly provided {token} | /api/users/{userId}/endpoints/secure?token={token} |
| POST | Inserts a new endpoint for a specified {userId} (MANY endpoints to ONE user relation applies) | /api/users/{userId}/endpoints |
| PUT | Updates an endpoint by providing the specific {id} in the URI along with {userId} | /api/users/{userId}/endpoints/{id} |
| PUT | Updates an endpoint by providing the specific ID in the JSON payload, however, the {userId} must be specified in the URI | /api/users/{userId}/endpoints |
| DELETE | Deletes an endpoint by providing the specific {id} in the URI | /api/users/endpoints/{id} |

<h2> Things that have been done so far... </h2>
<ul>
<li> ✔ User Model, Controller, Repository Interface, and Service </li>
<li> ✔ MonitoredEndpoints Model, Controller, Repository Interface, and Service </li>
<li> ✔ MonitoringResults Model, Controller, Repository Interface, and Service </li>
<li> ✔ Create a new "restapi" MySQL Database </li>
<li> ✔ Edit application.properties and connect to MySQL DB </li>
<li> ✔ Option to list a specified number of Users and EndPoints </li>
<li> ✔ Temporary String Token Authentication for GET requests </li>
<li> ✔ Auto generated ID values in models + auto generated Timestamps in MonitoredEndpoints </li>
<li> ✔ Enable Spring Actuator on port 9001 using context path => /actuator/ </li>
</ul>
<h2> Things that still need to be done to successfully complete the given task: </h2>
<ol>
<li> Get MonitoringResults to work </li>
<li> Proper Authentication with JWT or OAuth (Current authentication is implemented using a very safe, certified, and harmless plaintext String method - i.e. not production-ready) </li>
<li> Write tests </li>
<li> Add more validations to models (unique username, email, etc. using Annotations) </li>
<li> Finish this README and its steps to run the Microservice </li>
</ol>