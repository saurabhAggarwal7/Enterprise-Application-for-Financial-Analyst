package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
	@Autowired
	private NotesRepository notesRepository;

	public List getAllNotes() {

		List reservations = new ArrayList<>();
		notesRepository.findAll().forEach(reservations::add);

		return reservations;
	}

	public Notes getNotes(String id) {
		return notesRepository.findById(id).orElse(null);

	}

	public Notes addNotes(Notes notes) {
	return notesRepository.save(notes);
	}

	public void updateNotes(Long id, Notes notes) {
		notesRepository.save(notes);
	}

	public void deleteNotes(String id) {
		notesRepository.deleteById(id);
		;
	}

}
