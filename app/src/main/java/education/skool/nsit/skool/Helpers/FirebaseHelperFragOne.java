package education.skool.nsit.skool.Helpers;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import education.skool.nsit.skool.Models.MenteeModelFragOne;

public class FirebaseHelperFragOne {

    DatabaseReference db;
    Boolean saved;
    ArrayList<MenteeModelFragOne> menteeModelFragOnes =new ArrayList<>();

    public FirebaseHelperFragOne(DatabaseReference db) {
        this.db = db;
    }
    public Boolean save(MenteeModelFragOne menteeModelFragOne)
    {
        if(menteeModelFragOne ==null)
        {
            saved=false;
        }else
        {

            try
            {
                db.child("MenteesUnPaid").push().setValue(menteeModelFragOne);
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
        menteeModelFragOnes.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            MenteeModelFragOne menteeModelFragOne =ds.getValue(MenteeModelFragOne.class);
            menteeModelFragOnes.add(menteeModelFragOne);
        }
    }

    public ArrayList<MenteeModelFragOne> retrieve()
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


        return menteeModelFragOnes;
    }


}