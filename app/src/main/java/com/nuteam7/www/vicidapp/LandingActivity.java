package com.nuteam7.www.vicidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landing, menu);
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

    public void goToUpload(View view) {
        Intent i=new Intent(LandingActivity.this, UploadLanding.class);
        startActivity(i);
    }

    public void goToVote(View view) {
        Intent i=new Intent(LandingActivity.this, VoteLanding.class);
        startActivity(i);
    }

    public void goToEncyclopedia(View view) {
        Intent i=new Intent(LandingActivity.this, EncyclopediaLanding.class);
        startActivity(i);
    }

    public void goToSignIn(View view) {
        Intent i=new Intent(LandingActivity.this, MainActivity.class);
        startActivity(i);
    }
}
