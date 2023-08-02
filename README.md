# Homework Java with Spring Boot

This project is a Spring Boot application that implements several APIs and a Java service as part of a homework assignment.

## Table of Contents

1. [Installation](#installation)
2. [Usage](#usage)
3. [APIs](#apis)
   - [Hello API](#hello-api)
   - [Permutation Check API](#permutation-check-api)
4. [Java Service](#java-service)
5. [Testing](#testing)
6. [Optional](#optional)

## Installation

This project is based on Spring Boot. You can create a Spring Boot project from [Spring Initializr](https://start.spring.io/). Choose the options according to your needs. Run the `DemoApplication` class to start the server.

## Usage

This project contains two APIs and one Java service as well as unit tests for the Permutation Check API and for the Java service.

## APIs

### Hello API

This API returns a simple greeting message when accessed via a GET request.

Example:

curl --location --request GET 'localhost:8080/hello'

Response:

Hello

### Permutation Check API

This API checks if two arrays are permutations of each other. It reads the two lists only once and does not use any "sort" methods. it uses HashMap data structure to solve this problem.

```java
Example1:

curl --location --request POST 'localhost:8080/ispermuted'
--header 'Content-Type: application/json'
--data-raw '{
"list1" : [
"a" ,
"b" ,
"c"
],
"list2" : [
"b" ,
"c" ,
"a"
]
} '

Response: true

Example 2:

curl --location --request POST 'localhost:8080/ispermuted' \
--header 'Content-Type: application/json' \
--data-raw '{
"list1" : [
"a" ,
"b" ,
"c"
],
"list2" : [
"b" ,
"c" ,
"a",
"a"
]
} '

Response: false
```

## Java Service

The Java service in this project is `printX(int diagonal)`. It prints an "X" shape with a specified diagonal length.

Example:

```java
printX(5)


Output:

X   X
 X X
  X
 X X
X   X
```

## Testing

Unit tests are included for the API and the Java service.
mockMvc is used for the API tests and Jnit5 for the Java service.

## Optional

Basic authentication is added to the Permutation Check API for additional security.
