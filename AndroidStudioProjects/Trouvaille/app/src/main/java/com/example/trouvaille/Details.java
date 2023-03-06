package com.example.trouvaille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.trouvaille.ui.cities.CitiesFragment;
import com.example.trouvaille.ui.province.ProvinceFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Details extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    TextView titleTextView;
    TextView provinceDescTextView;
    TextView capitalTextView;
    TextView otherTextView;
    String province;
    int imageResourse;
    String provincedesc;
    String capital;
    String other;

    FloatingActionButton addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView=findViewById(R.id.image);
        titleTextView=findViewById(R.id.titleTextView);
        provinceDescTextView =findViewById(R.id.provinceDesctextView);
        capitalTextView = findViewById(R.id.capitalTextView);
        otherTextView = findViewById(R.id.otherTextView);

        province=getIntent().getStringExtra("titleTextView");
        imageResourse=getIntent().getIntExtra("image",0);
        provincedesc = getIntent().getStringExtra("provinceDescTextView");
        capital = getIntent().getStringExtra("capitalTextView");
        other = getIntent().getStringExtra("otherTextView");

        titleTextView.setText(province);
        imageView.setImageResource(imageResourse);
        provinceDescTextView.setText(provincedesc);
        capitalTextView.setText(capital);
        otherTextView.setText(other);

        addbtn=(FloatingActionButton) findViewById(R.id.notepadbutton);
        addbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Details.this, NoteActivity.class);
        startActivity(intent);
    }
}
