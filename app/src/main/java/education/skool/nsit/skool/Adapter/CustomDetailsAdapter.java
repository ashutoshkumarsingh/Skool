package education.skool.nsit.skool.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import education.skool.nsit.skool.Activities.StudentActivity;
import education.skool.nsit.skool.Models.MenteeModel;
import education.skool.nsit.skool.R;


public class CustomDetailsAdapter extends BaseAdapter{
    Context c;
    ArrayList<MenteeModel> menteeModels;

    public CustomDetailsAdapter(Context c, ArrayList<MenteeModel> menteeModels) {
        this.c = c;
        this.menteeModels = menteeModels;
    }

    @Override
    public int getCount() {
        return menteeModels.size();
    }

    @Override
    public Object getItem(int position) {
        return menteeModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.abc_detail_layout,parent,false);
        }

        TextView nameTxt= (TextView) view.findViewById(R.id.nameTxt);
        TextView propTxt= (TextView) view.findViewById(R.id.description);
        TextView descTxt= (TextView) view.findViewById(R.id.locationTxt);
        Button button =(Button)view.findViewById(R.id.paymentbtn);

        final MenteeModel s = (MenteeModel) this.getItem(position);

        nameTxt.setText(s.getName());
        propTxt.setText(s.getLocation());
        descTxt.setText(s.getDescription());
        button.setText(s.getPayment());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = s.getName();
                String Location =s.getLocation();

                Intent intent=new Intent(c.getApplicationContext(),StudentActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("location", Location);
                c.startActivity(intent);

                Toast.makeText(c,s.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}