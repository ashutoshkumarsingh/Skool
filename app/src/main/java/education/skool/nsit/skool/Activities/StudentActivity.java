package education.skool.nsit.skool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import education.skool.nsit.skool.R;

public class StudentActivity extends AppCompatActivity {


    String name,location;
    TextView selectedName,selectedLocation;
    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        selectedName=(TextView)findViewById(R.id.selected_name);
        selectedLocation=(TextView)findViewById(R.id.selected_location);
        b1=(Button)findViewById(R.id.module_bt1);
        b2=(Button)findViewById(R.id.module_bt2);
        b3=(Button)findViewById(R.id.module_bt3);
        b4=(Button)findViewById(R.id.module_bt4);
        b5=(Button)findViewById(R.id.module_bt5);
        b6=(Button)findViewById(R.id.module_bt6);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        location = intent.getStringExtra("location");

        selectedName.setText(name);
        selectedLocation.setText(location);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String moduleName= b1.getText().toString();

                Intent intent=new Intent(StudentActivity.this,SelectedModuleActivity.class);
                intent.putExtra("moduleName",moduleName);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String moduleName= b2.getText().toString();

                Intent intent=new Intent(StudentActivity.this,SelectedModuleActivity.class);
                intent.putExtra("moduleName",moduleName);
                startActivity(intent);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String moduleName= b3.getText().toString();

                Intent intent=new Intent(StudentActivity.this,SelectedModuleActivity.class);
                intent.putExtra("moduleName",moduleName);
                startActivity(intent);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String moduleName= b4.getText().toString();

                Intent intent=new Intent(StudentActivity.this,SelectedModuleActivity.class);
                intent.putExtra("moduleName",moduleName);
                startActivity(intent);

            }
        }); b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String moduleName= b5.getText().toString();

                Intent intent=new Intent(StudentActivity.this,SelectedModuleActivity.class);
                intent.putExtra("moduleName",moduleName);
                startActivity(intent);

            }
        }); b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String moduleName= b6.getText().toString();

                Intent intent=new Intent(StudentActivity.this,SelectedModuleActivity.class);
                intent.putExtra("moduleName",moduleName);
                startActivity(intent);

            }
        });



    }
}
