package com.mitocode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.person;
import com.mitocode.PersonRepository;


@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	
	@GetMapping("/person")
	public List<person> allPerson(){
		return repository.findAll();
	}
	
	@GetMapping("/person/{nombre}")
	public List<person> findByName(@PathVariable("nombre") String nombre) {
		return repository.findByName(nombre);
	}
	
	@PostMapping("/person")
	public person createPerson(@RequestBody person person) {
		return repository.save(person);
	}
	
	@PutMapping("/person/{id}")
	public person updatePerson(@PathVariable int id ,@RequestBody person person) {
		return repository.save(person);
	}
	
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
