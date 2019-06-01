# spring-booted-endpoints
<h1> Monitored Endpoints Created in Spring Boot 2.0+ </h1>
<p> This Spring Boot project was coded to provide a microservice application for monitoring URL endpoints. </p>
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
