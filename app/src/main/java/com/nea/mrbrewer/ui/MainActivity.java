package com.nea.mrbrewer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nea.mrbrewer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findBrewersButton)
    Button mfindBrewersButton;

    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        ButterKnife.bind ( this );


        mfindBrewersButton.setOnClickListener ( new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                    Intent intent = new Intent ( MainActivity.this, BibleListActivity.class );
                    startActivity ( intent );
                }
        } );
    }

    @Override
    public void onClick(View view) {

    }
}

