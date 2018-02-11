package education.skool.nsit.skool.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import education.skool.nsit.skool.Models.MenteeModelFragOne;
import education.skool.nsit.skool.R;


public class CustomAdapterFragOne extends BaseAdapter{
    Context c;
    ArrayList<MenteeModelFragOne> menteeModelFragOnes;

    public CustomAdapterFragOne(Context c, ArrayList<MenteeModelFragOne> menteeModelFragOnes) {
        this.c = c;
        this.menteeModelFragOnes = menteeModelFragOnes;
    }

    @Override
    public int getCount() {
        return menteeModelFragOnes.size();
    }

    @Override
    public Object getItem(int position) {
        return menteeModelFragOnes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.abc_detail_layout_fragone,parent,false);
        }

        TextView nameTxt= (TextView) view.findViewById(R.id.nameTxtFragOne);
        TextView propTxt= (TextView) view.findViewById(R.id.descriptionFragOne);
        TextView descTxt= (TextView) view.findViewById(R.id.locationTxtFragOne);

        final MenteeModelFragOne s = (MenteeModelFragOne) this.getItem(position);

        nameTxt.setText(s.getName());
        propTxt.setText(s.getLocation());
        descTxt.setText(s.getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,s.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}