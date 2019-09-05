package com.nea.mrbrewer;

import android.content.Context;
import android.widget.ArrayAdapter;

public class BrewersArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mBeers;
    private String[] mBrewers;

    public BrewersArrayAdapter(Context mContext, int resource, String[] mBeers, String[] mBrewers) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mBeers = mBeers;
        this.mBrewers = mBrewers;
    }

    @Override
    public Object getItem(int position) {
        String beer = mBeers[position];
        String brewer = mBrewers[position];
        return String.format("%s \nServes great: %s",beer, brewer);
    }

    @Override
    public int getCount() {
        return mBeers.length;
    }
}