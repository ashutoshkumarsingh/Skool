package education.skool.nsit.skool;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved;
    ArrayList<MenteeModel> menteeModels =new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
    public Boolean save(MenteeModel menteeModel)
    {
        if(menteeModel ==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Mentees").push().setValue(menteeModel);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        menteeModels.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            MenteeModel menteeModel =ds.getValue(MenteeModel.class);
            menteeModels.add(menteeModel);
        }
    }

    public ArrayList<MenteeModel> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return menteeModels;
    }


}