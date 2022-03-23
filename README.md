# RawHttp

### There are 2 main programs in this repository:

### 1) httpc

cURL-like Java HTTP 1.0 client implementation

Running the httpc program:
    
POST a json file: 
    
    httpc.httpc post -v -h Content-Type:application/octet-stream -f <path to json file> http://httpbin.org/post
    
GET request with headers:

    httpc.httpc get -v -h Content-Type:text/html -h Accept-Language:en-US
    http://httpbin.org/get?course=networking&assignment=1
    
POST request with inline data:

    httpc.httpc post -v -h Content-Type:application/json -h Accept:application/json 
    -d {"assignment":1,"other":{"one":1,"two":2}} http://httpbin.org/post
    
POST a text file:

    httpc.httpc post -h Content-Type:application/octet-stream -f <path to text file> http://httpbin.org/post
    
Getting help:

    httpc.httpc post help
    httpc.httpc get help
    

### 2) httpfs

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
