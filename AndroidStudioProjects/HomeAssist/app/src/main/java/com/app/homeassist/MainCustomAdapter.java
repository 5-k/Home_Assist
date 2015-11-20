package com.app.homeassist;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.homeassist.services.MobileRepair;

/**
 * Created by prateek on 16/11/15.
 */
public class MainCustomAdapter extends BaseAdapter  {

    String result[];
    Context context;
    int [] imageid;
    public static LayoutInflater inflater = null;

    public MainCustomAdapter(MainActivity mainActivity,  String [] servicenameList, int[] servivenameImages){
        result = servicenameList;
        context = mainActivity;
        imageid = servivenameImages;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.maincustomadapter,null);

        holder.tv = (TextView)rowView.findViewById(R.id.maincustomadaptertext);
        holder.img = (ImageView)rowView.findViewById(R.id.maincustomadapterimage);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageid[position]);

        return rowView;
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    public class Holder{
        TextView tv;
        ImageView img;
    }


}
