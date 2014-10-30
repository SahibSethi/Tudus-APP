package com.example.tudus;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class CustomArrayAdapter extends ArrayAdapter<Tudus>	 {
	
	private Context context;
	
	public CustomArrayAdapter(Context context , int resource,List<Tudus> objects){
		super(context, resource, objects);
		this.context = context;
	}
	
	public View getView(int position , View convertView,ViewGroup parent){
		View output = convertView;
		
		if(output == null){
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			output = inflater.inflate(R.layout.custom_list_view, null);
		}
		TextView title = (TextView) output.findViewById(R.id.title);
		TextView code = (TextView) output.findViewById(R.id.code);
		TextView date = (TextView) output.findViewById(R.id.date);
		Tudus t = this.getItem(position);
		title.setText(t.Title);
		date.setText(t.Date);
		code.setText(t.Code);
		return output;
	}
}
