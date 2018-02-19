package com.deepspring12.dict.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entry {
	
	@Id
	private String word;
	@Column(nullable = true, updatable = true)
	private String wordtype;
	@Column(nullable = false, updatable = false)
	private String definition;
	
	public Entry() {}
		
	public Entry(String word, String wordType, String definition) {
		this.word = word;
		this.wordtype = wordType;
		this.definition = definition;
	}

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getWordType() {
		return wordtype;
	}
	public void setWordType(String wordType) {
		this.wordtype = wordType;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	

}
