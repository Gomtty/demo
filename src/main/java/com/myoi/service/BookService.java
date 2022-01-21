package com.myoi.service;

import com.myoi.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author myoi
 * @date 2021/9/9 - 10:05
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
    public void save() {
        bookDao.saveBook();
    }
}
