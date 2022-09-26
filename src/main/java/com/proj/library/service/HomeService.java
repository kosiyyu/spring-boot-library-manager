package com.proj.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.library.model.Author;

@Service
public class HomeService {
	
	public String displayAuthors(List<Author> authorList) {
		String str = "";
		if(authorList.size() > 0) {
			for(Author author : authorList) {
				str += author.getFirstName() + " " + author.getLastName() + ", ";
			}
			str = str.substring(0, str.length() - 2);
			if(str.substring(str.length() - 1, str.length()).equals(" "))
			{
				str = str.substring(0, str.length() - 2);
			}
			if(str.length() > 33) {
				str = str.substring(0, 33);
				str += "...";
			}
			return str;
		}
		return "-";
	}
		
}
