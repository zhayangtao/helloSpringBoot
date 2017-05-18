package com.groovy.example

/**
 * Created by shliangyan on 2017/5/12.
 */
interface ReadingListRepository {
    List<Book> findByReader(String reader)
    void save(Book book)
}