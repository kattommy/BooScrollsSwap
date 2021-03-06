package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Note;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class NoteDao implements BaseDaoCrud <Note, Long> {

    @Override
    public List<Note> findAll() {
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Note> getAllUsersQuery = entityManager.createQuery("from Note", Note.class);
        List<Note> notes = getAllUsersQuery.getResultList();

        transaction.commit();
        entityManager.close();


        return notes;
    }

    @Override
    public Note findById(Long id) {
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Note note = entityManager.find(Note.class, id);

        transaction.commit();
        entityManager.close();

        return note;
    }

    @Override
    public Note add(Note toAdd) {
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(toAdd);

        transaction.commit();
        entityManager.close();

        return toAdd;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Note note = entityManager.find(Note.class, id);
        entityManager.remove(note);

        transaction.commit();
        entityManager.close();
    }
}
