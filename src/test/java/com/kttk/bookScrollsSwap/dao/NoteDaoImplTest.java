package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Note;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoteDaoImplTest {

    NoteDaoImpl noteDao;

    Note note;

    @BeforeEach
    void setUp() {
        noteDao = new NoteDaoImpl(SessionConnector
                .getInstance()
                .createH2Factory());
        note = new Note();
        note.setNotes("notes");
    }

    @Test
    void findAll() {
        Note note1 = new Note();

        noteDao.save(note);
        noteDao.save(note1);

        final List<Note> noteList = noteDao.findAll();

        assertEquals(2, noteList.size());
    }

    @Test
    void findById() {
        noteDao.save(note);

        final Note byId = noteDao.findById(1L);

        assertNotNull(byId);
        assertEquals(1,byId.getId());
    }

    @Test
    void save() {
        final Note savedNote = noteDao.save(note);

        assertNotNull(savedNote);
        assertEquals("notes",savedNote.getNotes());
    }

    @Test
    void deleteById() {
        final Note save = noteDao.save(note);

        noteDao.deleteById(save.getId());
        final Note findById = noteDao.findById(save.getId());

        assertNull(findById);
    }

    @Test
    void update() {
        noteDao.save(note);
        note.setId(1L);
        note.setNotes("Updated note");

        final Note updated = noteDao.update(note);

        assertEquals("Updated note",updated.getNotes());
    }
}