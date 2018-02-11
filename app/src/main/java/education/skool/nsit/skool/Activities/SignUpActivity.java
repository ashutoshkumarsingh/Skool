package education.skool.nsit.skool.Activities;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import education.skool.nsit.skool.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    private static EditText fullName, emailId, mobileNumber,password;
    private static TextView login;
    private static ImageView imageView;
    private static Button signUpButton,image_button;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    DatabaseReference rootRef;
    ProgressDialog progressDialog ;

    // Creating StorageReference and DatabaseReference object.
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        fullName = findViewById(R.id.fullName);
        emailId = findViewById(R.id.userEmailId);
        mobileNumber = findViewById(R.id.mobileNumber);
        password = findViewById(R.id.password);
        signUpButton = findViewById(R.id.signUpBtn);
        login = findViewById(R.id.already_user);


        progressDialog=new ProgressDialog(SignUpActivity.this);
        rootRef = FirebaseDatabase.getInstance().getReference("users");

        //database reference pointing to demo node
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        login.setTextColor(getResources().getColorStateList(R.color.textview_selector));

        setListeners();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

    }
    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();

        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        // Returning the file Extension.
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }
    private void setListeners() {
        signUpButton.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBtn:
                // Call checkValidation method
                // Get all edittext texts
                String getFullName = fullName.getText().toString().trim();
                String getEmailId = emailId.getText().toString().trim();
                String getMobileNumber = mobileNumber.getText().toString().trim();
                String getPassword = password.getText().toString().trim();

                // Pattern match for email id
       /* Pattern p = Pattern.compile(Utils.regEx);
        Matcher m = p.matcher(getEmailId);
*/
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                // Check if all strings are null or not
                if (getFullName.equals("") || getFullName.length() == 0
                        || getEmailId.equals("") || getEmailId.length() == 0
                        || getMobileNumber.equals("") || getMobileNumber.length() == 0
                        || getPassword.equals("") || getPassword.length() == 0)

                Toast.makeText(getApplicationContext(),"All fields are required.",Toast.LENGTH_SHORT).show();
                    // Check if email id valid or not
              else  if (!getEmailId.matches(emailPattern))
                    Toast.makeText(getApplicationContext(),"Email Invalid",Toast.LENGTH_SHORT).show();

                else if (getPassword.length() < 6) {
                    Toast.makeText(getApplicationContext(),"Password too short",Toast.LENGTH_SHORT).show();
                }

                else {
                    progressBar.setVisibility(View.VISIBLE);

                    //create user
                auth.createUserWithEmailAndPassword(getEmailId, getPassword).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Toast.makeText(getApplicationContext(),"Authentication done",Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(),"Authentication failed.",Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        } else {
                            startActivity(new Intent(SignUpActivity.this, DetailsActivity.class));
                            finish();
                        }

                    }
                });

//                Configure configure=new Configure(getFullName,getEmailId,getMobileNumber);
//                rootRef.setValue(configure);
            }

                break;

            case R.id.already_user:
                Intent login=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(login);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}

