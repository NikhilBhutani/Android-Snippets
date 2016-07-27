package com.github.nikhilbhutani.usingsugerorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Saving the data
      book = new Book("Lean Startup", "2nd edition");
        book.save();
        Log.i("Main Activity - " , "Saved " + book.title + ", "+book.edition);

        //Loading the data
        book = Book.findById(Book.class, 1);
        Log.i("Main Activity - " , "Loading " + book.title + ", "+book.edition);

        //Updating
        book = Book.findById(Book.class, 1);
        book.title = "Hard things about hard things";
        book.edition = "1st edition";
        Log.i("Main Activity - " , "Updating " + book.title + ", "+book.edition);

        //Deleting
        book = Book.findById(Book.class, 1);
        book.delete();
        Log.i("Main Activity - " , "Deleted "  +book.edition);


    }
}
