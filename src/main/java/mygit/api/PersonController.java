package mygit.api;

import mygit.model.Person;
import mygit.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/person")
@RestController
public class PersonController {

    private  final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return  personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.selectPersonById(id).orElse(null);
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonnById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void  updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}
