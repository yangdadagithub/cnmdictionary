package com.example.administrator.cnmdictionary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.apache.http.client.HttpClient;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public  void fordicfunc(View view){
    Intent intent=new Intent(this,Dictionary.class);
    startActivity(intent);
}
    public  void forusefulword(View view){
        Intent intent=new Intent(this,Word.class);
        startActivity(intent);
    }
    public  void forusefulsentance(View view){
        Intent intent=new Intent(this,Sentence.class);
        startActivity(intent);
    }
    public  void forrawword(View view){
        Intent intent=new Intent(this,Raword.class);
        startActivity(intent);
    }
    public  void fortest(View view){
        Intent intent=new Intent(this,Rawtest.class);
        startActivity(intent);
    }
    public  void about(View view){
        Intent intent=new Intent(this,About.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
