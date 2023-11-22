package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        if (daftar_nama.isEmpty()) {
            daftar_nama.add("data masih kosong");
        }

        // Repeat the names up to 20 times with even sequence numbers
        ArrayList<String> repeatedNamesWithEvenSequence = new ArrayList<>();
        int startingEvenNumber = 2; // Start with the first even number

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < daftar_nama.size(); j++) {
                int evenNumber = startingEvenNumber + (i * 2); // Calculate even number
                repeatedNamesWithEvenSequence.add(evenNumber + ". " + daftar_nama.get(j));
            }
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repeatedNamesWithEvenSequence);

        lvNama.setAdapter(ad_nama);
    }
}