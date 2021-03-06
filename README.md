# RawHttpServer

### 1) Building the project

    mvn clean compile assembly:single

### 2) httpfs

Remote filesystem program built on top of a raw http server

Running the httpfs program:

    java -jar target/httpfs-1.0-jar-with-dependencies.jar -v
    
Specifying root directory (default is current working directory) & port on which the program will run:

    java -jar target/httpfs-1.0-jar-with-dependencies.jar -p 16000 -d <path>

Getting help:

    java -jar target/httpfs-1.0-jar-with-dependencies.jar help
    
Use cUrl to query the remote filesystem (start httpfs before querying):

GET a list of files stored in the data directory:

       curl -X GET -v http://localhost:8080
       
GET the contents of a file stored in the remote filesystem:

        curl -X GET -v http://localhost:8080/jsonFile.json

POST request to create or overwrite the contents of a file:

        curl -X POST http://localhost:8080/jsonFile.json --header "Content-Type: application/json" --data '{"key":"value", "array": ["one", "two", "three"]}'
