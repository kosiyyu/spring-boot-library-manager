package com.proj.library.service;

import java.util.Comparator;

import com.proj.library.model.Author;

public class AuthorAlphabeticalComparator implements Comparator<Author>{

	//alphabetical order by last name
	
	@Override
	public int compare(Author o1, Author o2) {
		return o1.getLastName().compareToIgnoreCase(o2.getLastName());
	}
	
}
