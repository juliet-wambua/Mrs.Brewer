package com.nea.mrbrewer.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

public class BrewersArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mBooks;
    private String[] mVerses;

    public BrewersArrayAdapter(Context mContext, int resource, String[] mBooks, String[] mVerses) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mBooks = mBooks;
        this.mVerses = mVerses;
    }

    @Override
    public Object getItem(int position) {
        String beer = mBooks[position];
        String brewer = mVerses[position];
        return String.format("%s \nServes great: %s",beer, brewer);
    }

    @Override
    public int getCount() {
        return mBooks.length;
    }
}