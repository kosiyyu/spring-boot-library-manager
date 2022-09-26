package com.proj.library.service;

import java.util.Comparator;

import com.proj.library.model.Book;

public class BookAlphabeticalComparator implements Comparator<Book>{
	
	//alphabetical order by name
	
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
