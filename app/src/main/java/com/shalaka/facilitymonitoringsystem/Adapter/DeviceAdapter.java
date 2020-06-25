package com.shalaka.facilitymonitoringsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.shalaka.facilitymonitoringsystem.R;

public class DeviceAdapter extends BaseAdapter {
    Context context;

    // the thumbnails for each device
    // they can be modified individually, rn they are all the same
    public Integer [] thumbImages = {
            R.drawable.iot_icon,
            R.drawable.iot_icon,
            R.drawable.iot_icon,
            R.drawable.iot_icon,
            R.drawable.iot_icon,
            R.drawable.iot_icon,
            R.drawable.iot_icon,
            R.drawable.iot_icon,
            R.drawable.iot_icon
    };

    //constructor
    public DeviceAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return thumbImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // display thumbnails
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.imageView.setImageResource(thumbImages[position]);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
    }
}
