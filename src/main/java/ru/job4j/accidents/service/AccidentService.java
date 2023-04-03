package ru.job4j.accidents.service;

import ru.job4j.accidents.model.*;

import java.util.*;

public interface AccidentService {
    Accident save(Accident accident);

    Collection<Accident> findAll();
}
