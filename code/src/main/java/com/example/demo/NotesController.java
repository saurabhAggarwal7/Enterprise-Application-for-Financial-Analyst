package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@RequestMapping(value = "/Getnotes", method = RequestMethod.GET)
	public List getAllNotess() {
		return notesService.getAllNotes();
	}

	@RequestMapping(value = "/Getnotes/{id}", method = RequestMethod.GET)
	public Notes getNotes(@PathVariable String id) {
		return notesService.getNotes(id);
	}

	@RequestMapping(value = "/Postnotes", method = RequestMethod.POST)
	public void addNotes(@RequestBody Notes notes) {
		System.out.println("----------------"+notes.getNotes());
		notesService.addNotes(notes);

	}

	@RequestMapping(value = "/Putnotes/{id}", method = RequestMethod.PUT)
	public void updateNotes(@RequestBody Notes notes, @PathVariable Long id) {
		notesService.updateNotes(id, notes);
	}

	@RequestMapping(value = "/Deletenotes/{id}", method = RequestMethod.DELETE)
	public void deleteNotes(@PathVariable String id) {
		notesService.deleteNotes(id);
	}

	
	
}
