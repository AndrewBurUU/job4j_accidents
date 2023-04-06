package ru.job4j.accidents.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accidents.model.AccidentType;

import java.util.*;

public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {

    List<AccidentType> getAccidentTypes();
}
