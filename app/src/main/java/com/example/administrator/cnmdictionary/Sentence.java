package com.example.administrator.cnmdictionary;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

import java.util.ArrayList;


public class Sentence extends ActionBarActivity {
    class MyAdaper extends PagerAdapter{
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

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=list.get(position);
            ((ViewPager)container).addView(view);
            return view;
        }
    }
private ViewPager vp;
    private View v1,v2,v3,v4,v5,v6,v7;
    private ArrayList<View> list;
    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence);
        vp=(ViewPager)findViewById(R.id.vp);
        inflater=LayoutInflater.from(this);
        v1=inflater.inflate(R.layout.sentance1, null);
        v2=inflater.inflate(R.layout.sentance2,null);
        v3=inflater.inflate(R.layout.sentance3,null);
        v4=inflater.inflate(R.layout.sentance4,null);
        v5=inflater.inflate(R.layout.sentance5,null);
        v6=inflater.inflate(R.layout.sentance6,null);
        v7=inflater.inflate(R.layout.sentance7,null);
        list=new ArrayList<View>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);
        list.add(v7);
        vp.setAdapter(new MyAdaper());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sentence, menu);
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
