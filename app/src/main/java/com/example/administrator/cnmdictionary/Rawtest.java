package com.example.administrator.cnmdictionary;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Rawtest extends ActionBarActivity {
private TextView tv,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tva;
    private RadioGroup rg,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rga;
    private RadioButton rb1,rb2,rb3,rb4;
    private RadioButton rb21,rb22,rb23,rb24;
    private RadioButton rb31,rb32,rb33,rb34;
    private RadioButton rb41,rb42,rb43,rb44;
    private RadioButton rb51,rb52,rb53,rb54;
    private RadioButton rb61,rb62,rb63,rb64;
    private RadioButton rb71,rb72,rb73,rb74;
    private RadioButton rb81,rb82,rb83,rb84;
    private RadioButton rb91,rb92,rb93,rb94;
    private RadioButton rba1,rba2,rba3,rba4;
    private int count=0;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rawtest);
        tv=(TextView)findViewById(R.id.q1);
        tv2=(TextView)findViewById(R.id.q2);
        tv3=(TextView)findViewById(R.id.q3);
        tv4=(TextView)findViewById(R.id.q4);
        tv5=(TextView)findViewById(R.id.q5);
        tv6=(TextView)findViewById(R.id.q6);
        tv7=(TextView)findViewById(R.id.q7);
        tv8=(TextView)findViewById(R.id.q8);
        tv9=(TextView)findViewById(R.id.q9);
        tva=(TextView)findViewById(R.id.qa);
        rg=(RadioGroup)findViewById(R.id.rg);
        rg2=(RadioGroup)findViewById(R.id.rg2);
        rg3=(RadioGroup)findViewById(R.id.rg3);
        rg4=(RadioGroup)findViewById(R.id.rg4);
        rg5=(RadioGroup)findViewById(R.id.rg5);
        rg6=(RadioGroup)findViewById(R.id.rg6);
        rg7=(RadioGroup)findViewById(R.id.rg7);
        rg8=(RadioGroup)findViewById(R.id.rg8);
        rg9=(RadioGroup)findViewById(R.id.rg9);
        rga=(RadioGroup)findViewById(R.id.rga);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        rb3=(RadioButton)findViewById(R.id.rb3);
        rb4=(RadioButton)findViewById(R.id.rb4);
        rb21=(RadioButton)findViewById(R.id.rb21);
        rb22=(RadioButton)findViewById(R.id.rb22);
        rb23=(RadioButton)findViewById(R.id.rb23);
        rb24=(RadioButton)findViewById(R.id.rb24);
        rb31=(RadioButton)findViewById(R.id.rb31);
        rb32=(RadioButton)findViewById(R.id.rb32);
        rb33=(RadioButton)findViewById(R.id.rb33);
        rb34=(RadioButton)findViewById(R.id.rb34);
        rb41=(RadioButton)findViewById(R.id.rb41);
        rb42=(RadioButton)findViewById(R.id.rb42);
        rb43=(RadioButton)findViewById(R.id.rb43);
        rb44=(RadioButton)findViewById(R.id.rb44);
        rb51=(RadioButton)findViewById(R.id.rb51);
        rb52=(RadioButton)findViewById(R.id.rb52);
        rb53=(RadioButton)findViewById(R.id.rb53);
        rb54=(RadioButton)findViewById(R.id.rb54);
        rb61=(RadioButton)findViewById(R.id.rb61);
        rb62=(RadioButton)findViewById(R.id.rb62);
        rb63=(RadioButton)findViewById(R.id.rb63);
        rb64=(RadioButton)findViewById(R.id.rb64);
        rb71=(RadioButton)findViewById(R.id.rb71);
        rb72=(RadioButton)findViewById(R.id.rb72);
        rb73=(RadioButton)findViewById(R.id.rb73);
        rb74=(RadioButton)findViewById(R.id.rb74);
        rb81=(RadioButton)findViewById(R.id.rb81);
        rb82=(RadioButton)findViewById(R.id.rb82);
        rb83=(RadioButton)findViewById(R.id.rb83);
        rb84=(RadioButton)findViewById(R.id.rb84);
        rb91=(RadioButton)findViewById(R.id.rb91);
        rb92=(RadioButton)findViewById(R.id.rb92);
        rb93=(RadioButton)findViewById(R.id.rb93);
        rb94=(RadioButton)findViewById(R.id.rb94);
        rba1=(RadioButton)findViewById(R.id.rba1);
        rba2=(RadioButton)findViewById(R.id.rba2);
        rba3=(RadioButton)findViewById(R.id.rba3);
        rba4=(RadioButton)findViewById(R.id.rba4);
        result=(TextView)findViewById(R.id.result);
       result();


    }
    public void result(){
        lister(rg,tv);
        lister(rg2,tv2);
        lister(rg3,tv3);
        lister(rg4,tv4);
        lister(rg5,tv5);
        lister(rg6,tv6);
        lister(rg7, tv7);
        lister(rg8,tv8);
        lister(rg9,tv9);
        lister(rga,tva);
    }
    public void lister(RadioGroup rg, final TextView textview){
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id=group.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton)Rawtest.this.findViewById(id);
                String qs=textview.getText().toString();
                String[] s1=getResources().getStringArray(R.array.w);
                String[] s2=getResources().getStringArray(R.array.w2);
                int index=0;
                for(int i=0;i<s2.length;i++){
                    if(s2[i].equals(rb.getText().toString()))
                        index=i;
                }
                if(s1[index].equals(qs))
                    count+=1;
               // Toast.makeText(Rawtest.this,count+" is right",Toast.LENGTH_SHORT).show();
            }
        });
    }
public void refreshtest(View view){
    settest(tv,rb1,rb2,rb3,rb4,R.array.w,R.array.w2);
    settest(tv2, rb21, rb22, rb23, rb24, R.array.w, R.array.w2);
    settest(tv3, rb31, rb32, rb33, rb34, R.array.w, R.array.w2);
    settest(tv4, rb41, rb42, rb43, rb44, R.array.w, R.array.w2);
    settest(tv5, rb51, rb52, rb53, rb54, R.array.w, R.array.w2);
    settest(tv6,rb61,rb62,rb63,rb64,R.array.w,R.array.w2);
    settest(tv7,rb71,rb72,rb73,rb74,R.array.w,R.array.w2);
    settest(tv8,rb81,rb82,rb83,rb84,R.array.w,R.array.w2);
    settest(tv9,rb91,rb92,rb93,rb94,R.array.w,R.array.w2);
    settest(tva,rba1,rba2,rba3,rba4,R.array.w,R.array.w2);
    result.setText("上一次共作对"+count+"题");
    count=0;
}
    public void settest(TextView tv,RadioButton rb1,RadioButton rb2,RadioButton rb3,RadioButton rb4,int e,int c){
        String[] s1=getResources().getStringArray(e);
        String[] s2=getResources().getStringArray(c);
        int length=s1.length;
        int index=(int)(Math.random()*length);
        String sw=s1[index];
        String sw2=s2[index];
        tv.setText(sw);
        int rbindex=(int)(Math.random()*3);
        String[] otherrb1=getResources().getStringArray(R.array.w2);
        String[] otherrb2=getResources().getStringArray(R.array.wc2);
        String[] otherrb3=getResources().getStringArray(R.array.wc3);
        int otherlength1=otherrb1.length-1;
        int otherindex1=((int)(Math.random()*otherlength1))==index?(int)(Math.random()*otherlength1)+1:(int)(Math.random()*otherlength1);
        int otherlength2=otherrb2.length-1;
        int otherindex2=((int)(Math.random()*otherlength2))==index?(int)(Math.random()*otherlength2)+1:(int)(Math.random()*otherlength2);
        int otherlength3=otherrb3.length-1;
        int otherindex3=((int)(Math.random()*otherlength3))==index?(int)(Math.random()*otherlength3)+1:(int)(Math.random()*otherlength3);
        String os1=otherrb1[otherindex1];
        String os2=otherrb2[otherindex2];
        String os3=otherrb3[otherindex3];
        switch (rbindex){
            case 0:rb1.setText(sw2);
                rb2.setText(os1);
                rb3.setText(os2);
                rb4.setText(os3);
                break;
            case 1:rb1.setText(os1);
                rb2.setText(sw2);
                rb3.setText(os2);
                rb4.setText(os3);
                break;
            case 2:rb1.setText(os1);
                rb2.setText(os2);
                rb3.setText(sw2);
                rb4.setText(os3);
                break;
            case 3:rb1.setText(os1);
                rb2.setText(os2);
                rb3.setText(os3);
                rb4.setText(sw2);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rawtest, menu);
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
