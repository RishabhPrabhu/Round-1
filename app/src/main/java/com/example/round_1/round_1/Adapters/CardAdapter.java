package com.example.round_1.round_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.round_1.round_1.Data.CardData;
import com.example.round_1.round_1.R;

import java.util.ArrayList;

/**
 * Created by f1 on 04-07-2016.
 */
public class CardAdapter extends ArrayAdapter<CardData> {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<CardData> list;
    int resource;


    public CardAdapter(Context context,int resource, ArrayList<CardData> list) {
        super(context, resource, list);
        mContext = context;
        this.list = list;
        this.resource=resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return list.size();
    }

    public class ViewHolder {
        private TextView open_status, level, type, distance;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(resource, null);
            holder = new ViewHolder();
            holder.open_status = (TextView) convertView.findViewById(R.id.open_status);
            holder.level = (TextView) convertView.findViewById(R.id.level_status);
            holder.type = (TextView) convertView.findViewById(R.id.type_status);
            holder.distance = (TextView) convertView.findViewById(R.id.distance_status);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.open_status.setText(list.get(position).getOpen_status());
        holder.level.setText(list.get(position).getLevel());
        holder.type.setText(list.get(position).getType());
        holder.distance.setText(list.get(position).getDistance());
        return convertView;
    }
}
