package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    List<String> books;
    PrintStream printStream;
    DateTimeFormatter dateTimeFormatter;
    DateTime time;
    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void setUp() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        time = new DateTime();
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {


        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();
        verify(printStream, never()).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        String titleOne = "Book Title";
        String titleTwo = "Second Book Title";
        books.add(titleOne);
        books.add(titleTwo);

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        verify(printStream).println("Book Title");
        verify(printStream).println("Second Book Title");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */


    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class

        library.welcome(time);

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {


        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println(contains(""));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println(contains("2013-04-08 16:33:17"));
    }
}
