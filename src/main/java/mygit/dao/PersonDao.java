package mygit.dao;

import mygit.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person newPerson);

    default int insertPerson(Person person){
        UUID id  = UUID.randomUUID();
        return insertPerson(id, person);
    }


}
