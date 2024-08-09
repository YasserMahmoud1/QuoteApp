package com.example.assignment_1.UI;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_1.Data.QuoteModel;
import com.example.assignment_1.Data.QuoteRepo;
import com.example.assignment_1.R;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    List<QuoteModel> quotesList = QuoteRepo.getQuotes();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        listView = findViewById(R.id.homeListView);
        MyAdapter aa = new MyAdapter(this,R.layout.home_item,R.id.textItem, quotesList);
        listView.setAdapter(aa);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected item
            QuoteModel selectedQuote = quotesList.get(position);

            // Do something with the selected item, e.g., start a new activity and pass the quote
            Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
            intent.putExtra("quote", selectedQuote); // Assuming QuoteModel implements Serializable or Parcelable
            startActivity(intent);
        });

    }

}
