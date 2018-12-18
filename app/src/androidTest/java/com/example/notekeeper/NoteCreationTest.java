package com.example.notekeeper;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    static DataManager sDataManager;
    @BeforeClass
    public static void classSetUp() throws Exception{
        sDataManager = DataManager.getInstance();
    }
    @Rule
    public ActivityTestRule<NoteListActivity> mNoteListActivityActivityTestRule =
            new ActivityTestRule<>
            (NoteListActivity.class);

    @Test
    public void createNewNote(){
        final CourseInfo course = sDataManager.getCourse("java_lang");
        final String noteTitle = "Test not title";
        final String noteText = "This is the body of our test note";
//        ViewInteraction fabNewNote = onView(withId(R.id.fab));
//        fabNewNote.perform(click());
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.spinner_courses)).perform(click());

        onData(allOf(is(instanceOf(CourseInfo.class)), equalTo(course))).perform(click());

        onView(withId(R.id.text_note_title)).perform(typeText(noteTitle));
        onView(withId(R.id.text_note_text)).perform(typeText(noteText),closeSoftKeyboard());

        pressBack();
    }
}