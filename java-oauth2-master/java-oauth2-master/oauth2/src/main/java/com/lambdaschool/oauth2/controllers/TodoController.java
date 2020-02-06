package com.lambdaschool.oauth2.controllers;


import com.lambdaschool.oauth2.models.Todo;
import com.lambdaschool.oauth2.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController
{
    @Autowired
    private TodoService todoService;

    //http://localhost:2019/todos/todoid/{todoid}
    @PutMapping(value = "/todoid/{todoid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody
                                                Todo todo,
                                        @PathVariable long todoid)
    {
        todoService.updateTodo(todo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // GET -- http://localhost:2019/todos/todos
    @GetMapping(value = "/todos",
                produces = {"application/json"})
    public ResponseEntity<?> getAllTodos()
    {
        return new ResponseEntity<>(todoService.findAllTodos(), HttpStatus.OK);
    }
}
