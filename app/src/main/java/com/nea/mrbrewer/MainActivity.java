package com.nea.mrbrewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        Button mFindBreweriesButton = (Button) findViewById ( R.id.findRestaurantsButton );
        mFindBreweriesButton
                .setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
                    }
                });
    }
}