package com.nea.mrbrewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BrewerActivity extends AppCompatActivity {
    public static final String TAG = BrewerActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] beers = new String[]{"Tusker", "Balozi", "Pilsner", "Stout", "Porter", "Bock", "Weissbie", "Lambic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_brewer );
        ButterKnife.bind(this);

        mListView = (ListView) findViewById ( R.id.listView );
        mLocationTextView = (TextView) findViewById ( R.id.locationTextView );
        getBeer(beers);

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
        String beer = intent.getStringExtra("beers");
        mLocationTextView.setText("Here are all the Beers: " + beers);
    }
    private void getBeer(String[] beers) {
        final BrewerService brewerService = new BrewerService ();
        brewerService.findBrewers ( beers, new Callback () {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace ();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
