package com.groovy.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by shliangyan on 2017/5/12.
 */
@Controller
@RequestMapping("/")
class ReadingListController {
    String reader = "Jov"
    @Autowired
    ReadingListRepository readingListRepository

    @RequestMapping(method = RequestMethod.GET)
    def readersBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader)

        if (readingList) {
            model.addAttribute("books", readingList)
        }
        "readingList"
    }

    @RequestMapping(method = RequestMethod.POST)
    def addToReadingList(Book book) {
        book.setReader(reader)
        readingListRepository.save(book)
        "redirect:/"
    }
}
