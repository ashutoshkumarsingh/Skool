package education.skool.nsit.skool.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import education.skool.nsit.skool.Adapter.CheckboxAdapter;
import education.skool.nsit.skool.Models.CheckboxModel;
import education.skool.nsit.skool.R;

public class SelectedModuleActivity extends AppCompatActivity {

    ListView listView;
    CheckboxModel[] checkboxModels;
    String moduleName;
    CheckboxAdapter adapter;
    Button submitTestScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        listView =(ListView)findViewById(R.id.listView_module);
        submitTestScore =(Button)findViewById(R.id.testScore);

        Intent intent = getIntent();
        moduleName = intent.getStringExtra("moduleName");
        Toast.makeText(SelectedModuleActivity.this,moduleName,Toast.LENGTH_SHORT).show();


        checkboxModels = new CheckboxModel[5];

        if (moduleName.equals("Module1"))

        {

            checkboxModels[0] = new CheckboxModel("1Simple A-Z", 0);
            checkboxModels[1] = new CheckboxModel("Simple Counting", 1);
            checkboxModels[2] = new CheckboxModel("Basic English", 0);
            checkboxModels[3] = new CheckboxModel("Basic Hindi", 1);
            checkboxModels[4] = new CheckboxModel("Table 1-10", 0);

            adapter = new CheckboxAdapter(this, checkboxModels);
            listView.setAdapter(adapter);

        }

       else if (moduleName.equals("Module2"))

        {
            checkboxModels = new CheckboxModel[5];
            checkboxModels[0] = new CheckboxModel("word meaning", 0);
            checkboxModels[1] = new CheckboxModel("Vowels and aphlabets", 1);
            checkboxModels[2] = new CheckboxModel("back counting 100-1", 0);
            checkboxModels[3] = new CheckboxModel("Addition subtraction", 1);
            checkboxModels[4] = new CheckboxModel("Table 1-20", 0);

             adapter = new CheckboxAdapter(this, checkboxModels);
            listView.setAdapter(adapter);

        }

       else if (moduleName.equals("Module3"))

        {
            checkboxModels = new CheckboxModel[5];
            checkboxModels[0] = new CheckboxModel("Sentence Phrasing", 0);
            checkboxModels[1] = new CheckboxModel("Hindi grammar", 1);
            checkboxModels[2] = new CheckboxModel("Hindi/english poem", 0);
            checkboxModels[3] = new CheckboxModel("Basic Hindi", 1);
            checkboxModels[4] = new CheckboxModel("Addition/subtraction with carry", 0);

             adapter = new CheckboxAdapter(this, checkboxModels);
            listView.setAdapter(adapter);

        }

      else   if (moduleName.equals("Module4"))

        {
            checkboxModels = new CheckboxModel[5];
            checkboxModels[0] = new CheckboxModel("Reading pragraph", 0);
            checkboxModels[1] = new CheckboxModel("Dictations hindi/english", 1);
            checkboxModels[2] = new CheckboxModel("english grammar", 0);
            checkboxModels[3] = new CheckboxModel("multiplication/division", 1);
            checkboxModels[4] = new CheckboxModel("multiplication/division with carry", 0);

             adapter = new CheckboxAdapter(this, checkboxModels);
            listView.setAdapter(adapter);

        }

        if (moduleName.equals("Module5"))

        {
            checkboxModels = new CheckboxModel[5];
            checkboxModels[0] = new CheckboxModel("Dectating pragraph", 0);
            checkboxModels[1] = new CheckboxModel("hindi grammar", 1);
            checkboxModels[2] = new CheckboxModel("English grammar", 0);
            checkboxModels[3] = new CheckboxModel("Number System", 1);
            checkboxModels[4] = new CheckboxModel("Table 1-20", 0);

              adapter = new CheckboxAdapter(this, checkboxModels);
            listView.setAdapter(adapter);

        }

       else if (moduleName.equals("Module6"))

        {
            checkboxModels = new CheckboxModel[5];
            checkboxModels[0] = new CheckboxModel("Hindi grammar", 0);
            checkboxModels[1] = new CheckboxModel("English grammar", 1);
            checkboxModels[2] = new CheckboxModel("multiplication/division", 0);
            checkboxModels[3] = new CheckboxModel("addition/subtraction", 1);
            checkboxModels[4] = new CheckboxModel("Table 1-20", 0);

            adapter = new CheckboxAdapter(this, checkboxModels);
            listView.setAdapter(adapter);

        }


        submitTestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText editText =new EditText(SelectedModuleActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(SelectedModuleActivity.this)
                        .setTitle(moduleName)
                        .setMessage("Add the Score of: "+ moduleName)
                        .setView(editText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String task=String.valueOf(editText.getText());


                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .create();
                dialog.show();
            }
        });

    }
}
