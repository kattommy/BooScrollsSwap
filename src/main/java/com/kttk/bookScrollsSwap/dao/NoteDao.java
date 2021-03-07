package com.kttk.bookScrollsSwap.dao;
import com.kttk.bookScrollsSwap.model.BookCopy;
import com.kttk.bookScrollsSwap.model.Note;
import com.kttk.bookScrollsSwap.model.User;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class NoteDao implements INoteDao {

    private EntityManager entityManager;

    public NoteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Note> findAll() {
        return GeneralDao.findAll(Note.class);
    }
    

    @Override
    public Note findById(Long id) {
       return GeneralDao.find(Note.class, id);
    }

    @Override
    public Note save(Note toAdd) {
       return GeneralDao.save(toAdd);
    }


    @Override
    public void deleteById(Long id) {
        GeneralDao.deleteById(Note.class, id);
    }

    @Override
    public Note update(Note updatedItem) {
       return GeneralDao.update(updatedItem);
    }

    @Override
    public List<Note> findByUser(User user) {

        TypedQuery<Note> getAllNotes = entityManager.createQuery("select n from Note n " +
                "inner join fetch n.user_id u where u = " + user.getId(), Note.class);

        return getAllNotes.getResultList();
    }

    @Override
    public List<Note> findByBookCopy(BookCopy bookCopy) {
        TypedQuery<Note> getAllNotes = entityManager.createQuery("select n from Note n " +
                "inner join fetch n.bookCopy_id u where u = " + bookCopy.getId(), Note.class);

        return getAllNotes.getResultList();
    }
}
