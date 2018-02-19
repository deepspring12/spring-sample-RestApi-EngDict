package com.deepspring12.dict.entry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
	
	@Autowired
	private EntryRepository entryRepository;

	public Entry getEntry(String word) {
		return entryRepository.findOne(word);
	}

	public Entry addEntry(Entry wordEntry) {
		return entryRepository.save(wordEntry);
	}

	public Boolean updateEntry(Entry wordEntry) {
		Entry result = entryRepository.findOne(wordEntry.getWord());
		if (result==null)
			return false;
		entryRepository.save(wordEntry);
		return true;
		
	}

	public Boolean remove(String word) {
		Entry result = entryRepository.findOne(word);
		if (result==null)
			return false;
		entryRepository.delete(word);
		return true;
		
	}

	
}
