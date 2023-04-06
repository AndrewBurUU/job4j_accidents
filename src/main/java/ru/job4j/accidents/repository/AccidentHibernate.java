package ru.job4j.accidents.repository;

import lombok.AllArgsConstructor;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.*;

import java.util.*;

@Repository
@AllArgsConstructor
public class AccidentHibernate {
    private final SessionFactory sf;

    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            for (Rule rule : accident.getRules()) {
                AccidentRules accidentRules = new AccidentRules();
                accidentRules.setAccident(accident);
                accidentRules.setRule(rule);
                session.save(accidentRules);
            }
            return accident;
        }
    }

    public void update(Accident accident) {
        try (Session session = sf.openSession()) {
            session.merge(accident);
        }
    }

    public Optional<Accident> findById(int id) {
        try (Session session = sf.openSession()) {
            Optional<Accident> accident = session
                    .createQuery("FROM Accident ac LEFT JOIN FETCH ac.rules WHERE ac.id = :fId", Accident.class)
                    .setParameter("fId", id)
                    .uniqueResultOptional();
            return accident;
        }
    }

    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }

    public List<AccidentType> getAccidentTypes() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType", AccidentType.class)
                    .list();
        }
    }

    public List<Rule> getRules() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule", Rule.class)
                    .list();
        }
    }

}
