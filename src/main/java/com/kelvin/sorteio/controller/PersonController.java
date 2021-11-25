package com.kelvin.sorteio.controller;

import com.kelvin.sorteio.model.Person;
import com.kelvin.sorteio.model.PersonDTO;
import com.kelvin.sorteio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sorteio-amigo-secreto-garcia")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/person-view/{identifier}")
    public String viewPerson(Model model, @PathVariable String identifier){
        Optional<Person> personById = repository.findById(identifier);
        personById
                .ifPresentOrElse(person -> model.addAttribute("person", "Você tirou: " + person.getSortedPersonName()),
                        () -> model.addAttribute("person", "Houve um erro"));
        return "person-view";
    }
}
