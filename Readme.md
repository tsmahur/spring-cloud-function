# spring-cloud-function
This ms demonstrate the use of spring cloud functions.

##
### Dependency
    h2,jpa,spring-cloud-starter-function-web

### application.properties
    spring.h2.console.enabled=true
	spring.h2.console.path=/h2-console
	spring.datasource.url = jdbc:h2:mem:studentDB

    spring.cloud.function.definition -> define default defination
    spring.cloud.function.scan.packages ->to scan if function are in classes other that main class

### main application class
    All Beans of endpoint of function are defined here.

### EndPoints - H2 Database Console
	Open in Browser http://localhost:8080/h2-console/
	Connection String to DB : jdbc:h2:mem:studentDB (find temporary url from console if not defined in properties)


### EndPoints - API
    POST http://localhost:8080/saveStudent
    {
    "name":"test1",
    "age":25
    }

    GET http://localhost:8080/getAllStudent
    GET http://localhost:8080
	
	POST http://localhost:8080/deleteStudentById
	1

	POST http://localhost:8080/getStudentById
    1

    POST http://localhost:8080/getStudentAvgAge
    [
    {
        "id": 2,
        "name": "test2",
        "age": 25
    },
    {
        "id": 3,
        "name": "test1",
        "age": 27
    }
    ]
    
    GET http://localhost:8080/getAllStudent,getStudentAvgAge
	
### curl
    curl localhost:8080/getAllStudent
    curl -H "Content-Type: text/plain" localhost:8080/getStudentById -d 1
    curl -H "Content-Type: application/json" localhost:8080/saveStudent -d "{\"name\":\"test_curl\",\"age\":25}"
