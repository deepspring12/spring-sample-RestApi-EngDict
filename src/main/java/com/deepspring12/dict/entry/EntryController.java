package com.deepspring12.dict.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("english-dictionary/entries")
public class EntryController {
	
	@Autowired
	private EntryService entryService = new EntryService();
	
	@RequestMapping("/{word}")
	public ResponseEntity<Entry> getEntry(@PathVariable("word")String word) {
		Entry result = entryService.getEntry(word);
		if (result==null)//word does not exist
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(result);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{word}")
	public Entry addEntry(@RequestBody Entry wordEntry, @PathVariable("word")String word) {
		return entryService.addEntry(wordEntry);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{word}")
	public ResponseEntity<Entry> updateEntry(@RequestBody Entry wordEntry, @PathVariable("word")String word) {
		boolean success = entryService.updateEntry(wordEntry);
		if (!success) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/{word}")
	public ResponseEntity<Entry> removeEntry(@PathVariable("word") String word) {
		boolean success = entryService.remove(word);
		if (!success) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	

}
