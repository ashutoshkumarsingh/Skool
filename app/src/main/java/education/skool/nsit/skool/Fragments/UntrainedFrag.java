package education.skool.nsit.skool.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import education.skool.nsit.skool.Adapter.CustomAdapterFragOne;
import education.skool.nsit.skool.Helpers.FirebaseHelperFragOne;
import education.skool.nsit.skool.Models.MenteeModelFragOne;
import education.skool.nsit.skool.R;


public class UntrainedFrag extends Fragment {

    DatabaseReference db;
    FirebaseHelperFragOne helper;
    CustomAdapterFragOne adapter;
    ListView lv;
    EditText nameEditTxt, propTxt, descTxt;
    FloatingActionButton add;

    public UntrainedFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_fragone, container, false);

        lv =(ListView) view.findViewById(R.id.listView_fragone);
        add=(FloatingActionButton) view.findViewById(R.id.add_fragOne);
        lv.setAdapter(adapter);

        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelperFragOne(db);

        adapter = new CustomAdapterFragOne(getActivity(), helper.retrieve());
        lv.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });

        return view;

    }


    private void displayInputDialog() {
        Dialog d = new Dialog(getActivity());
        d.setTitle("Add Scholar Details");
        d.setContentView(R.layout.abc_dialog_fragone);

        nameEditTxt = (EditText) d.findViewById(R.id.nameEditTextFragOne);
        propTxt = (EditText) d.findViewById(R.id.locationEditextFragOne);
        descTxt = (EditText) d.findViewById(R.id.descEditTextFragOne);
        Button saveBtn = (Button) d.findViewById(R.id.saveBtnFragOne);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditTxt.getText().toString();
                String location = propTxt.getText().toString();
                String desc = descTxt.getText().toString();


                MenteeModelFragOne s = new MenteeModelFragOne();
                s.setName(name);
                s.setLocation(location);
                s.setDescription(desc);



                if (name != null && name.length() > 0) {
                    if (helper.save(s)) {
                        nameEditTxt.setText("");
                        propTxt.setText("");
                        descTxt.setText("");

                        adapter = new CustomAdapterFragOne(getActivity(), helper.retrieve());
                        lv.setAdapter(adapter);


                    }
                } else {

                    Toast.makeText(getActivity(), "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        d.show();
    }
}
