package com.example.administrator.cnmdictionary;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Word extends ActionBarActivity {
    class Myadaper extends PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=list.get(position);
            ((ViewPager)container).addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view=list.get(position);
            ((ViewPager)container).removeView(view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
private ViewPager vp;
    private View v1,v2,v3,v4,v5,v6,v7;
    private ArrayList<View> list;
    private LayoutInflater lf;
    private TextToSpeech toSpeech;
    private ListView lv1,lv2,lv3,lv4,lv5,lv6,lv7;
    private String[] str1,str2,we2,wc2,we3,we4,we5,we6,we7,wc3,wc4,wc5,wc6,wc7;
    private ArrayList<Map<String,Object>> data,data2,data3,data4,data5,data6,data7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        toSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = toSpeech.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(Word.this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        vp=(ViewPager)findViewById(R.id.vp2);
        lf=LayoutInflater.from(this);
        v1=lf.inflate(R.layout.word1, null);
        v2=lf.inflate(R.layout.word2, null);
        v3=lf.inflate(R.layout.word3, null);
        v4=lf.inflate(R.layout.word4, null);
        v5=lf.inflate(R.layout.word5, null);
        v6=lf.inflate(R.layout.word6, null);
        v7=lf.inflate(R.layout.word7, null);
        list=new ArrayList<View>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);
        list.add(v7);
        vp.setAdapter(new Myadaper());
        lv1=(ListView)v1.findViewById(R.id.lv1);
        lv2=(ListView)v2.findViewById(R.id.lv2);
        lv3=(ListView)v3.findViewById(R.id.lv3);
        lv4=(ListView)v4.findViewById(R.id.lv4);
        lv5=(ListView)v5.findViewById(R.id.lv5);
        lv6=(ListView)v6.findViewById(R.id.lv6);
        lv7=(ListView)v7.findViewById(R.id.lv7);
        str1=getResources().getStringArray(R.array.w);
        str2=getResources().getStringArray(R.array.w2);
        data=new  ArrayList<Map<String,Object>>();
        int length=str1.length;
        for(int i=0;i<length;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("word",str1[i]);
            item.put("detail",str2[i]);
            data.add(item);
        }
        we2=getResources().getStringArray(R.array.we2);
        wc2=getResources().getStringArray(R.array.wc2);
        data2=new  ArrayList<Map<String,Object>>();
        int length2=we2.length;
        for(int i=0;i<length2;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("word",we2[i]);
            item.put("detail",wc2[i]);
            data2.add(item);
        }
        we3=getResources().getStringArray(R.array.we3);
        wc3=getResources().getStringArray(R.array.wc3);
        data3=new  ArrayList<Map<String,Object>>();
        int length3=we3.length;
        for(int i=0;i<length3;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("word",we3[i]);
            item.put("detail",wc3[i]);
            data3.add(item);
        }
        we4=getResources().getStringArray(R.array.we4);
        wc4=getResources().getStringArray(R.array.wc4);
        data4=new  ArrayList<Map<String,Object>>();
        int length4=we4.length;
        for(int i=0;i<length4;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("word",we4[i]);
            item.put("detail",wc4[i]);
            data4.add(item);
        }
        we5=getResources().getStringArray(R.array.we5);
        wc5=getResources().getStringArray(R.array.wc5);
        data5=new  ArrayList<Map<String,Object>>();
        int length5=we5.length;
        for(int i=0;i<length5;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("word",we5[i]);
            item.put("detail",wc5[i]);
            data5.add(item);
        }
        we6=getResources().getStringArray(R.array.we6);
        wc6=getResources().getStringArray(R.array.wc6);
        data6=new  ArrayList<Map<String,Object>>();
        int length6=we6.length;
        for(int i=0;i<length6;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("word", we6[i]);
            item.put("detail",wc6[i]);
            data6.add(item);
        }
        we7=getResources().getStringArray(R.array.we7);
        wc7=getResources().getStringArray(R.array.wc7);
        data7=new  ArrayList<Map<String,Object>>();
        int length7=we7.length;
        for(int i=0;i<length7;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("word",we7[i]);
            item.put("detail",wc7[i]);
            data7.add(item);
        }
lv1.setAdapter(new SimpleAdapter(this,data,android.R.layout.simple_list_item_2,new String[]{"word","detail"},new int[]{android.R.id.text1,android.R.id.text2}));
   lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           TextView tv = (TextView) findViewById(android.R.id.text1);
           if (toSpeech != null && !toSpeech.isSpeaking()) {
               toSpeech.setPitch(1.0f);
               toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
           }
       }
   });
        lv2.setAdapter(new SimpleAdapter(this,data2,android.R.layout.simple_list_item_2,new String[]{"word","detail"},new int[]{android.R.id.text1,android.R.id.text2}));
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(android.R.id.text1);
                if (toSpeech != null && !toSpeech.isSpeaking()) {
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        lv3.setAdapter(new SimpleAdapter(this,data3,android.R.layout.simple_list_item_2,new String[]{"word","detail"},new int[]{android.R.id.text1,android.R.id.text2}));
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(android.R.id.text1);
                if (toSpeech != null && !toSpeech.isSpeaking()) {
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        lv4.setAdapter(new SimpleAdapter(this,data4,android.R.layout.simple_list_item_2,new String[]{"word","detail"},new int[]{android.R.id.text1,android.R.id.text2}));
        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(android.R.id.text1);
                if (toSpeech != null && !toSpeech.isSpeaking()) {
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        lv5.setAdapter(new SimpleAdapter(this,data5,android.R.layout.simple_list_item_2,new String[]{"word","detail"},new int[]{android.R.id.text1,android.R.id.text2}));
        lv5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(android.R.id.text1);
                if (toSpeech != null && !toSpeech.isSpeaking()) {
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        lv6.setAdapter(new SimpleAdapter(this,data6,android.R.layout.simple_list_item_2,new String[]{"word","detail"},new int[]{android.R.id.text1,android.R.id.text2}));
        lv6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(android.R.id.text1);
                if (toSpeech != null && !toSpeech.isSpeaking()) {
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        lv7.setAdapter(new SimpleAdapter(this,data7,android.R.layout.simple_list_item_2,new String[]{"word","detail"},new int[]{android.R.id.text1,android.R.id.text2}));
        lv7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) findViewById(android.R.id.text1);
                if (toSpeech != null && !toSpeech.isSpeaking()) {
                    toSpeech.setPitch(1.0f);
                    toSpeech.speak(tv.getText().toString(), toSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toSpeech!=null)
            toSpeech.shutdown();
    }

    @Override
    protected void onStop() {
        super.onStop();
        toSpeech.stop();
        toSpeech.shutdown();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word, menu);
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
