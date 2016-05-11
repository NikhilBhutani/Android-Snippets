package github.nikhilbhutani.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("C");
        arrayList.add("C++");
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("Php");
        arrayList.add("Perl");
        arrayList.add("Scala");
        arrayList.add("Clojure");
        arrayList.add("COBOL");
        arrayList.add("Ladder");
        arrayList.add("Machine Code");

        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);

        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);



    }
}
