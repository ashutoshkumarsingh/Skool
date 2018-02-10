package education.skool.nsit.skool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


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
        TextView propTxt= (TextView) view.findViewById(R.id.propellantTxt);
        TextView descTxt= (TextView) view.findViewById(R.id.descTxt);

        final MenteeModel s = (MenteeModel) this.getItem(position);

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