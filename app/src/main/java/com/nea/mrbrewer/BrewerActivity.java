package com.nea.mrbrewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BrewerActivity extends AppCompatActivity {
    @BindView(R.id.findBrewersButton)  Button mFindBrewersButton;
    @BindView(R.id.locationEditText)
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    private String[] beers = new String[]{"Tusker", "Balozi", "Pilsner", "Stout", "Porter", "Bock", "Weissbie", "Lambic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_brewer );
        ButterKnife.bind(this);

        mListView = (ListView) findViewById ( R.id.listView );
        mLocationTextView = (TextView) findViewById ( R.id.locationTextView );
        mFindBrewersButton = (Button) findViewById(R.id.findBrewersButton);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        ArrayAdapter adapter = new ArrayAdapter ( this, android.R.layout.simple_list_item_1, beers );
        mListView.setAdapter ( adapter );

        mListView.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView) view).getText ().toString ();
                Toast.makeText ( BrewerActivity.this, restaurant, Toast.LENGTH_LONG ).show ();
            }
        } );

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the Beers: " + location);
    }
}
