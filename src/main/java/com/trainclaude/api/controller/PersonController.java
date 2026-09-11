package com.trainclaude.api.controller;

import com.trainclaude.api.model.Person;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/api/person")
    public Person getPerson(@RequestParam String name, @RequestParam Long id) {
        return new Person(id, name);
    }

    @PostMapping("/api/person")
    public Person createPerson(@Valid @RequestBody Person person) {
        return person;
    }
}
