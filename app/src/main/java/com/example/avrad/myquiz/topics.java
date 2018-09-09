package com.example.avrad.myquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class topics extends AppCompatActivity implements View.OnClickListener{

    Button history,politics,science,highscore,logout;
    TextView tv;
    String s = "abc";
    String isloggedin="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topics);

        history=(Button)findViewById(R.id.history);
        history.setOnClickListener(this);

        politics=(Button)findViewById(R.id.politics);
        politics.setOnClickListener(this);

        science=(Button)findViewById(R.id.science);
        science.setOnClickListener(this);

        highscore=(Button)findViewById(R.id.highscore);
        highscore.setOnClickListener(this);

        logout =(Button)findViewById(R.id.logout);
        logout.setOnClickListener(this);

        tv =(TextView)findViewById(R.id.tv);

        s="";
        try
        {
            Bundle bundle=getIntent().getExtras();
            if(bundle.containsKey("SCORE")){
            s=bundle.getString("SCORE");}
        }
        catch(Exception e)
        {
            s="abc";
        }
        tv.setText(s);
        if(s.length()>0)
        {
            SharedPreferences obj= PreferenceManager.getDefaultSharedPreferences(this);
            int highscorescience = obj.getInt("highscorescience",0);
            int highscorehistory = obj.getInt("highscorehistory",0);
            int highscorepolitics = obj.getInt("highscorepolitics",0);

            int score = (int)s.charAt(s.length()-3);
            if(score>highscorescience && s.indexOf("Science")>0) {
                SharedPreferences.Editor edit = obj.edit();
                edit.putInt("highscorescience",score);
                edit.commit();
            }
            else if(score>highscorehistory && s.indexOf("History")>0)
            {
                SharedPreferences.Editor edit = obj.edit();
                edit.putInt("highscorehistory",score);
                edit.commit();
            }
            else if(score>highscorepolitics && s.indexOf("Politics")>0)
            {
                SharedPreferences.Editor edit = obj.edit();
                edit.putInt("highscorepolitics",score);
                edit.commit();
            }
        }
    }
    @Override
    public void onClick(View v) {
        if(v.equals(history))
        {
           Intent obj = new Intent(this,MainActivity.class);
           this.startActivity(obj);
           finish();
        }
        if(v.equals(politics))
        {
            Intent obj = new Intent(this,Politics.class);
            this.startActivity(obj);
            finish();
        }
        if(v.equals(science))
        {
            Intent obj = new Intent(this,Science.class);
            this.startActivity(obj);
            finish();
        }
        if(v.equals(highscore))
        {
            SharedPreferences obj= PreferenceManager.getDefaultSharedPreferences(this);
            int highscorescience = obj.getInt("highscorescience",'0');
            int highscorehistory =obj.getInt("highscorehistory",'0');
            int highscorepolitics =obj.getInt("highscorepolitics",'0');
            tv.setText("Science highscore is "+(highscorescience-48)+"\nHistory highscore is "+(highscorehistory-48)+"\nPolitics highscore is "+(highscorepolitics-48));
        }
        if(v.equals(logout))
        {
            isloggedin="0";
            send(isloggedin);
        }
    }
    public void send(String s)
    {
        /*Bundle b = new Bundle();*/
        Intent obj=new Intent(this,loginpage.class);
        obj.putExtra("ISLOGGEDIN",s);
        /*obj.putExtras(b);*/
        this.startActivity(obj);
        finish();
    }
}
