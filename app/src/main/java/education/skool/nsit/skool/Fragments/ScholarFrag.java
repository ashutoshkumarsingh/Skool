package education.skool.nsit.skool.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import education.skool.nsit.skool.Adapter.CustomDetailsAdapter;
import education.skool.nsit.skool.Helpers.FirebaseHelper;
import education.skool.nsit.skool.Models.MenteeModel;
import education.skool.nsit.skool.R;


public class ScholarFrag extends Fragment {

    DatabaseReference db;
    FirebaseHelper helper;
    CustomDetailsAdapter adapter;
    ListView lv;
    EditText nameEditTxt, propTxt, descTxt ,paymentTxt;
    FloatingActionButton add;


    public ScholarFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragtwo, container, false);

        lv =(ListView) view.findViewById(R.id.listView_fragtwo);
        add=(FloatingActionButton) view.findViewById(R.id.add);
        lv.setAdapter(adapter);

        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);

        //ADAPTER
        adapter = new CustomDetailsAdapter(getActivity(), helper.retrieve());
        lv.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });


        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void displayInputDialog() {
        Dialog d = new Dialog(getActivity());
        d.setTitle("Add Scholar Details");
        d.setContentView(R.layout.abc_dialog);

        nameEditTxt = (EditText) d.findViewById(R.id.nameEditText);
        propTxt = (EditText) d.findViewById(R.id.locationEditext);
        descTxt = (EditText) d.findViewById(R.id.descEditText);
        paymentTxt=(EditText)d.findViewById(R.id.paymentEditText);
        Button saveBtn = (Button) d.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditTxt.getText().toString();
                String location = propTxt.getText().toString();
                String desc = descTxt.getText().toString();
                String paymentString = descTxt.getText().toString();

                MenteeModel s = new MenteeModel();
                s.setName(name);
                s.setLocation(location);
                s.setDescription(desc);
                s.setPayment(paymentString);


                if (name != null && name.length() > 0) {
                    if (helper.save(s)) {
                        nameEditTxt.setText("");
                        propTxt.setText("");
                        descTxt.setText("");
                        paymentTxt.setText("");


                        adapter = new CustomDetailsAdapter(getActivity(), helper.retrieve());
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
