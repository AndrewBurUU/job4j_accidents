package ru.job4j.accidents.service;

import lombok.*;
import org.springframework.stereotype.*;
import ru.job4j.accidents.model.*;
import ru.job4j.accidents.repository.*;

import java.util.*;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemAccidentService implements AccidentService {

    private AccidentRepository accidentRepository = new MemAccidentRepository();

    @Override
    public Accident save(Accident accident) {
        return accidentRepository.save(accident);
    }

    @Override
    public Collection<Accident> findAll() {
        return accidentRepository.findAll();
    }

    @Override
    public Optional<Accident> findById(int id) {
        return accidentRepository.findById(id);
    }
}
