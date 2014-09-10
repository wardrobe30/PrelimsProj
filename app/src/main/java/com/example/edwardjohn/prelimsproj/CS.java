package com.example.edwardjohn.prelimsproj;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CS extends Fragment implements AdapterView.OnItemClickListener{

    public CS(){
    }
    String[] names;
    String[] divisions;
    int[] images={R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,
            R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,
            R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,
            R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,R.drawable.pic3,};
    ListView l;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Resources res = getResources();
        names=res.getStringArray(R.array.name2);
        divisions=res.getStringArray(R.array.division2);
        View v = inflater.inflate(R.layout.activity_cs, container, false);
        l= (ListView) v.findViewById(R.id.listView2);

        MyAdapter2 adapter2= new MyAdapter2(getActivity(), names, images, divisions);
        l.setAdapter(adapter2);
        //l.setOnItemClickListener(this);
        return v;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        TextView temp= (TextView) view;
        Toast.makeText(getActivity(), temp.getText() + " " + i, Toast.LENGTH_SHORT).show();
    }
}

class MyAdapter2 extends ArrayAdapter<String>
{   Context context;
    int [] images;
    String [] namesArray;
    String [] departmentArray;
    MyAdapter2(Context c,String[] name1, int image[], String [] dept)
    {
        super(c,R.layout.custom_row,R.id.textView2,name1);
        this.context=c;
        this.images=image;
        this.namesArray=name1;
        this.departmentArray=dept;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater)
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_row, parent, false);
        }
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView myNames = (TextView) row.findViewById(R.id.textView2);
        TextView myDepartment = (TextView) row.findViewById(R.id.textView3);
        myImage.setImageResource(images[position]);
        myNames.setText(namesArray[position]);
        myDepartment.setText(departmentArray[position]);
        return row;
    }
}

