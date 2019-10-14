package com.example.adminaptitude.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.adminaptitude.ModelData.ModelClassForSubCategory;
import com.example.adminaptitude.ModelData.ModelcalssForCategory;
import com.example.adminaptitude.R;

import java.util.List;

public class SpinnerAdapterSubCategory extends ArrayAdapter<ModelClassForSubCategory>
{
    public SpinnerAdapterSubCategory(@NonNull Context context, int resource, @NonNull List<ModelClassForSubCategory> objects)
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
        TextView subcategoryname = (TextView) convertView.findViewById(R.id.textView);

        ModelClassForSubCategory subcategoryitem = getItem(position);

        if (subcategoryitem != null)
        {
            subcategoryname.setText(subcategoryitem.getSubcategoryname());
        }
        return convertView;
    }
}

