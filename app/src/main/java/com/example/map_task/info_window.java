package com.example.map_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class info_window implements GoogleMap.InfoWindowAdapter {
    Context c;
    Marker marker;
    View v;

    public info_window(Context c) {
        this.c = c;
        v= LayoutInflater.from(c).inflate(R.layout.info_window,null);

    }

    public void renderwindowtext(Marker m,View view){
   //String title =m.getTitle();
        TextView v1 =view.findViewById(R.id.one);
        v1.setText("hello world");

    }



    @Override
    public View getInfoWindow(Marker marker) {
        renderwindowtext(marker,v);

        return v;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderwindowtext(marker,v);
        return v;
    }
}
