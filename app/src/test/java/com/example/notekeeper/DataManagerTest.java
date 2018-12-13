package com.example.notekeeper;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {

    @Test
    public void createNewNote() throws Exception{
        DataManager dataManager = DataManager.getInstance();
        final CourseInfo course = dataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";


        int noteIndex = dataManager.createNewNote();
        NoteInfo newNote = dataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);


        NoteInfo compareNote = dataManager.getNotes().get(noteIndex);
        assertSame(newNote,compareNote);
        assertEquals(compareNote.getCourse(),course);
        assertEquals(compareNote.getTitle(),noteTitle);
        assertEquals(compareNote.getText(),noteText);

    }
}