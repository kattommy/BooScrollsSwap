package com.kttk.bookScrollsSwap.services;

import com.kttk.bookScrollsSwap.dao.NoteDao;
import com.kttk.bookScrollsSwap.model.Note;

import java.util.List;

/**
 * Created by Tom - 07.03.2021
 */
public class NoteServiceImpl implements NoteService{

    private final NoteDao noteDao;

    public NoteServiceImpl(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public List<Note> findAll() {
        return noteDao.findAll(Note.class);
    }

    @Override
    public Note findById(Long id) {
        return noteDao.find(Note.class, id);
    }

    @Override
    public Note save(Note object) {
        return noteDao.save(object);
    }

    @Override
    public Note update(Note object) {
        return noteDao.update(object);
    }

    @Override
    public void deleteById(Long id) {
        noteDao.deleteById(Note.class, id);
    }
}
