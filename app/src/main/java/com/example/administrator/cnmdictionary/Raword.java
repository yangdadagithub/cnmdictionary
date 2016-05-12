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

import java.util.Locale;


public class Raword extends ActionBarActivity {
    private EditText ed1,ed2;
    private SQLiteDatabase db;
    private TextToSpeech toSpeech;
    private ListView lv;
    private MyOpenHelper rawhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raword);
        toSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = toSpeech.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(Raword.this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        rawhelper=new MyOpenHelper(this,"rawords.db",null,1);
        db=rawhelper.getReadableDatabase();
        lv=(ListView)findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView)findViewById(R.id.userName);
                if(toSpeech!=null&&!toSpeech.isSpeaking()){
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(),toSpeech.QUEUE_FLUSH,null);
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(R.id.userId);
                int id1 = Integer.parseInt(tv.getText().toString());
               /* String sql="delete from user where _id="+id1;
                db.execSQL(sql);*/
                db.delete("user", "_id=?", new String[]{id + ""});
                String sql2 = "select * from user";
                Cursor cursor = db.rawQuery(sql2, null);
                refresh(cursor);
                return true;
            }
        });
    }
    public void Look(View view){
       /* String name=ed1.getText().toString();
        Cursor cursor=db.query("user",null,"name like ?",new String[]{"%"+name+"%"},null,null,"name DESC");*/
       // Cursor cursor=db.query("user",null,null,null,null,null,null);
        String key=ed1.getText().toString();
        Cursor cursor=db.rawQuery("select * from user where word like ? or detail like ?",new String[]{"%"+key+"%","%"+key+"%"});
       // Toast.makeText(this,"looked",Toast.LENGTH_SHORT).show();
        refresh(cursor);
    }
    public void refresh(Cursor cursor){
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.searchresultitem,
                cursor,new String[]{"_id","word","detail"},
                new int[]{R.id.userId,R.id.userName,R.id.userPassword},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);
    }
    public  void insertData(SQLiteDatabase db,String word,String detail){
        /*String sql="insert into user(name,password) values(?,?)";
        db.execSQL(sql, new String[]{name, pass});*/
     /*   ContentValues values=new ContentValues();
        values.put("name", name);
        values.put("password", pass);
        db.insert("user", null, values);*/
        db.execSQL("insert into user values(null,?,?)",new String[]{word,detail});
    }
    public void Makesure(View view){
        String name=ed1.getText().toString();
        String pass=ed2.getText().toString();
        //  try {
        insertData(db,name,pass);
        //  }catch (Exception e){
        //    create(db);
        //     insert(db,name,pass);
        // }
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        ed1.setText("");
        ed2.setText("");
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
        if(rawhelper!=null)
            rawhelper.close();
        if(toSpeech!=null)
            toSpeech.shutdown();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_raword, menu);
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
