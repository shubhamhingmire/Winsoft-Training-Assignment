POST a new TODO: POST http://localhost:8080/todos with JSON body like { "title": "Buy groceries", "completed": false }
GET all TODOs: GET http://localhost:8080/todos
GET a TODO by ID: GET http://localhost:8080/todos/{id}
PUT update a TODO: PUT http://localhost:8080/todos/{id} with JSON body like { "title": "Buy groceries", "completed": true }
DELETE a TODO: DELETE http://localhost:8080/todos/{id}

http://localhost:8080/h2-console


data
{
    "title": "Walk the dog",
    "completed": true
}
