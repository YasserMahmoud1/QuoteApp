package com.example.assignment_1.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_1.Data.QuoteModel;
import com.example.assignment_1.R;

public class DetailsActivity extends AppCompatActivity {
    TextView quote;
    TextView movie;
    TextView year;
    TextView character;
    ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.item_details);
        Intent intent = getIntent();

        QuoteModel quoteModel = (QuoteModel) intent.getSerializableExtra("quote");

        quote = findViewById(R.id.detailsQuote);
        movie = findViewById(R.id.detailsMovie);
        year = findViewById(R.id.detailsYear);
        character = findViewById(R.id.detailsCharacter);
        imageView = findViewById(R.id.detailsImage);

        assert quoteModel != null;
        quote.setText(quoteModel.getQuote());
        movie.setText(quoteModel.getMovieName());
        year.setText(quoteModel.getMovieYear());
        character.setText(quoteModel.getCharacterName());
        imageView.setImageResource(quoteModel.getMoviePhoto());

    }
}
