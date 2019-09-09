package com.nea.mrbrewer.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nea.mrbrewer.Constants;
import com.nea.mrbrewer.R;
import com.nea.mrbrewer.models.Bible;
import com.nea.mrbrewer.models.Verse;
import com.nea.mrbrewer.service.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BibleListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.bible_list_item);
        final ListView listView = findViewById(R.id.listView);
        Retrofit retrofit = new Retrofit.Builder( )
                .baseUrl( Constants.TOKEN_BASE_URL)
                .addConverterFactory( GsonConverterFactory.create( ))
                .build( );
        API api = retrofit.create(API.class);
        Call<Bible> call = api.getBible();
        call.enqueue(new Callback<Bible> ( ) {
            @Override
            public void onResponse(Call<Bible> call, Response<Bible> response) {
                List<Verse> bible = response.body().getVerses ();
                String[] bibleList = new String[bible.size()];
                for (int i = 0; i < bible.size( ); i++) {
                    bibleList[i] = bible.get(i).getBookId ();
                }
                listView.setAdapter(
                        new ArrayAdapter<String> (
                                BibleListActivity.this,
                                android.R.layout.simple_list_item_1,
                                bibleList
                        )
                );
            }



            @Override
            public void onFailure(Call<Bible> call, Throwable t) {
                Toast.makeText(getApplicationContext( ), t.getMessage( ), Toast.LENGTH_SHORT).show( );
            }
        });
    }
}
