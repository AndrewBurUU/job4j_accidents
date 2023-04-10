package ru.job4j.accidents.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accidents.model.Accident;

import java.util.*;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Query("from Model")
    List<Accident> findAll();

}
