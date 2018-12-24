package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="notesTable")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notesid")
	String notesid;
	@Column(name="notes")
	String notes;
	@Column(name="ownedby")
	String ownedby;

	
	
	public Notes(String notesid, String notes, String ownedby) {
		super();
		this.notesid = notesid;
		this.notes = notes;
		this.ownedby = ownedby;
	}
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Notes [notesid=" + notesid + ", notes=" + notes + ", ownedby=" + ownedby + "]";
	}
	
	public String getNotesid() {
		return notesid;
	}
	public void setNotesid(String notesid) {
		this.notesid = notesid;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getOwnedby() {
		return ownedby;
	}
	public void setOwnedby(String ownedby) {
		this.ownedby = ownedby;
	}
		

}
