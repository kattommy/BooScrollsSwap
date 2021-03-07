package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.BookCopy;
import com.kttk.bookScrollsSwap.model.Note;
import com.kttk.bookScrollsSwap.model.User;

import java.util.List;

public interface INoteDao extends BaseDaoCrud <Note, Long>{

    List<Note> findByUser(User user);

   List<Note> findByBookCopy(BookCopy bookCopy);

}
