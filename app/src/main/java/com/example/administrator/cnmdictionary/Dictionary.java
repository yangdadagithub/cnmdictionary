package com.example.administrator.cnmdictionary;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;


public class Dictionary extends ActionBarActivity {
    private EditText input;
    private SQLiteDatabase db;
    private ListView lv;
   // private  String dbName="user.db";
    private MyOpenHelper helper;
    private TextToSpeech toSpeech;




    public void initdb(){
        try {
            InputStream inputStream=getResources().openRawResource(R.raw.word);
            InputStreamReader reader=new InputStreamReader(inputStream,"gbk");
            BufferedReader breader=new BufferedReader(reader);
            String str;
            while((str=breader.readLine())!=null){
                int whitespace=str.indexOf(' ');
                String eng=str.substring(0,whitespace);
                String chin=str.substring(whitespace+1);
                insert(db,eng,chin);
            }
            inputStream.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        input=(EditText)findViewById(R.id.input);
        helper=new MyOpenHelper(this,"wordsbank.db",null,1);
        db=helper.getReadableDatabase();
        lv=(ListView)findViewById(R.id.listview);
        SharedPreferences sharedPreferences=getSharedPreferences("save",0);
        boolean isFirstFirst=sharedPreferences.getBoolean("isIn",false);
        toSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = toSpeech.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(Dictionary.this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(R.id.userName);
                if (toSpeech != null && !toSpeech.isSpeaking()) {
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        if(!isFirstFirst)
            initdb();
    }
    public void myQuery(View view){
       /* String name=input.getText().toString();
        Cursor cursor=db.query("user", new String[]{"name"}, "name like ?",
                new String[]{"%" + name + "%"}, null, null, "name DESC");
        refresh(cursor);
       /* Cursor cursor=db.query("words",new String[]{"_id","English","Chinese"},null,null,null,null,null);
        refresh(cursor);*/
        String key=input.getText().toString();
        Cursor cursor=db.rawQuery("select * from user where word like ? or detail like ?",new String[]{"%"+key+"%","%"+key+"%"});
        refresh(cursor);
        input.setText("");
    }
    public  void refresh(Cursor cursor){
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.searchresultitem,cursor,
                new String[]{"_id","word","detail"},new int[]{R.id.userId,R.id.userName,R.id.userPassword},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);
    }
    public  void insert(SQLiteDatabase db,String word,String detail){
       /* ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("password",pass);
        db.insert("user", null, values);*/
        db.execSQL("insert into user values(null,?,?)",new String[]{word,detail});
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("save",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("isIn",true);
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        toSpeech.stop();
        toSpeech.shutdown();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(helper!=null)
            helper.close();
        if(toSpeech!=null)
        toSpeech.shutdown();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dictionary, menu);
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
