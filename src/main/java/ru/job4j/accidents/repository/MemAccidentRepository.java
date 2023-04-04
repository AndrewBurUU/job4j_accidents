package ru.job4j.accidents.repository;

import org.springframework.stereotype.*;
import ru.job4j.accidents.model.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

@Repository
public class MemAccidentRepository implements AccidentRepository {

    private final AtomicInteger nextId = new AtomicInteger(1);
    private final ConcurrentHashMap<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final List<AccidentType> types = new ArrayList<>();
    private final List<Rule> rules = new ArrayList<>();

    public MemAccidentRepository() {
        save(new Accident(0, "name1", "text1", "address1", new AccidentType(), new HashSet<>()));
        save(new Accident(0, "name2", "text2", "address2", new AccidentType(), new HashSet<>()));
        save(new Accident(0, "name3", "text3", "address3", new AccidentType(), new HashSet<>()));
        types.add(new AccidentType(1, "Две машины"));
        types.add(new AccidentType(2, "Машина и человек"));
        types.add(new AccidentType(3, "Машина и велосипед"));
        rules.add(new Rule(1, "Статья. 1"));
        rules.add(new Rule(2, "Статья. 2"));
        rules.add(new Rule(3, "Статья. 3"));
    }

    @Override
    public Accident save(Accident accident) {
        accident.setId(nextId.getAndIncrement());
        accidents.put(accident.getId(), accident);
        return accident;
    }

    @Override
    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    @Override
    public Collection<Accident> findAll() {
        return accidents.values();
    }

    @Override
    public Optional<Accident> findById(int id) {
        return Optional.ofNullable(accidents.get(id));
    }

    @Override
    public Collection<AccidentType> getAccidentTypes() {
        return types;
    }

    @Override
    public Collection<Rule> getRules() {
        return rules;
    }

}
