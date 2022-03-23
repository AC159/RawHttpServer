# RawHttpServer

### 1) httpfs

Remote filesystem program built on top of a raw http server

Running the httpfs program:

    httpfs.httpfs -v
    
Specifying root directory (default is current working directory) & port on which the program will run:

    httpfs.httpf -p 16000 -d <path>

Getting help:

    httpfs.httpfs help
    
Use cUrl to query the remote filesystem (start httpfs before querying):

GET a list of files stored in the data directory:

       curl -X GET -v http://localhost:8080
       
GET the contents of a file stored in the remote filesystem:

        curl -X GET -v http://localhost:8080/jsonFile.json

POST request to create or overwrite the contents of a file:

        curl -X POST http://localhost:8080/jsonFile.json --header "Content-Type: application/json" --data '{"key":"value", "array": ["one", "two", "three"]}'
