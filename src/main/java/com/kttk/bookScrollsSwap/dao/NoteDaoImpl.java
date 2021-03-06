package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Note;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class NoteDaoImpl implements BaseDaoCrud <Note, Long> {

    private final EntityManagerFactory factory;

    public NoteDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Note> findAll() {
        final EntityManager entityManager = factory.createEntityManager();
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
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Note note = entityManager.find(Note.class, id);

        transaction.commit();
        entityManager.close();

        return note;
    }

    @Override
    public Note save(Note toAdd) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(toAdd);

        transaction.commit();
        entityManager.close();

        return toAdd;
    }

    @Override
    public void deleteById(Long id) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Note note = entityManager.find(Note.class, id);
        entityManager.remove(note);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public Note update(Note updatedItem) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Note toUpdate = entityManager.find(Note.class, updatedItem.getId());
        toUpdate.setUser(updatedItem.getUser());
        toUpdate.setBookCopy(updatedItem.getBookCopy());
        toUpdate.setNotes(updatedItem.getNotes());

        transaction.commit();
        entityManager.close();

        return toUpdate;
    }
}
