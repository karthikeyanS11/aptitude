package com.example.adminaptitude.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminaptitude.R;

public class GridAdapter extends BaseAdapter
{
    Context context;
    String cards[];
    int images[];
    LayoutInflater inflter;

    public GridAdapter(Context applicationContext, String[] cards,int[] image)
    {
        this.context = applicationContext;
        this.cards = cards;
        this.images =image;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.cardgridview, null);

        TextView card = (TextView) view.findViewById(R.id.card);
        ImageView image = (ImageView) view.findViewById(R.id.images);

        card.setText(cards[i]);
        image.setImageResource(images [i]);
        return view;
    }
}

