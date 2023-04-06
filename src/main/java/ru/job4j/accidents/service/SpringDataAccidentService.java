package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.repository.AccidentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SpringDataAccidentService {
    private final AccidentRepository accidentRepository;

    public void create(Accident accident) {
        accidentRepository.save(accident);
    }

    public List<Accident> getAll() {
        return (List<Accident>) accidentRepository.findAll();
    }
}
