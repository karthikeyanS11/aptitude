package com.example.adminaptitude.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.adminaptitude.ModelData.ModelClassForSet;
import com.example.adminaptitude.ModelData.ModelClassForSubCategory;
import com.example.adminaptitude.R;

import java.util.List;

public class SpinnerAdapterSet extends ArrayAdapter<ModelClassForSet>
{
    public SpinnerAdapterSet(@NonNull Context context, int resource, @NonNull List<ModelClassForSet> objects)
    {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return inatlizeView(position,convertView,parent);
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        return inatlizeView(position,convertView,parent);
    }
    private View inatlizeView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.spinner_items, parent, false);
        }
        TextView setname = (TextView) convertView.findViewById(R.id.textView);

        ModelClassForSet setitem = getItem(position);

        if (setitem != null)
        {
            setname.setText(setitem.getSetname());
        }
        return convertView;
    }
}

