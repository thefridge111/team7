package com.nuteam7.www.vicidapp;

import android.app.LauncherActivity;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.support.v4.content.CursorLoader;
import android.widget.TextView;

public class EncyclopediaLanding extends AppCompatActivity {

    EditText modelInput; //xml input
    TextView outputText; //xml output
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia_landing);
        modelInput = (EditText) findViewById(R.id.Input);
        outputText = (TextView) findViewById(R.id.Text);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_encyclopedia_landing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 /*   //This may need to get moved to ListViewLoader
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.brand_sort:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.model_sort:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.year_sort:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

} */

    //Add a model to the database
    public void addButtonClicked(View view){
        Model model = new Model(modelInput.getText().toString());
        dbHandler.addModel(model);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        String inputText = modelInput.getText().toString();
        dbHandler.deleteModel(inputText);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        outputText.setText(dbString);
        modelInput.setText("");
    }

}

