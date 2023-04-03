package ru.job4j.accidents.repository;

import ru.job4j.accidents.model.*;

import java.util.*;

public interface AccidentRepository {

    Accident save(Accident accident);

    Collection<Accident> findAll();

    Optional<Accident> findById(int id);
}
