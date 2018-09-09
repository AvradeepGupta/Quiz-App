package com.example.avrad.myquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginpage extends AppCompatActivity implements View.OnClickListener{

    Button login,signup;
    EditText name,password;
    int isloggedin;
    String s1,s2,s;

   /* public SQLiteDatabase db;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login =(Button)findViewById(R.id.login);
        login.setOnClickListener(this);

        signup =(Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);

        name =(EditText)findViewById(R.id.name);

        password =(EditText)findViewById(R.id.password);

        /*db = (new DbHelper(this)).getWritableDatabase();*/

        Bundle bundle=getIntent().getExtras();
        /*if(getIntent().getExtras() != null){
            Toast.makeText(getApplicationContext(), "Not null", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();*/
        if(bundle.containsKey("ISLOGGEDIN")) {
            s=bundle.getString("ISLOGGEDIN");
            int i= Integer.parseInt(s);
            SharedPreferences obj= PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor edit = obj.edit();
            edit.putInt("isloggedin",i);
            edit.commit();
        }

        SharedPreferences obj= PreferenceManager.getDefaultSharedPreferences(this);
        isloggedin = obj.getInt("isloggedin",0);

        if(isloggedin == 1)
        {
            Intent mainpage = new Intent(this,topics.class);
            this.startActivity(mainpage);
            finish();
        }
    }
    @Override
    public void onClick(View v) {
        if(v.equals(login))
        {
            s1 = name.getText().toString();
            s2 = password.getText().toString();

                isloggedin = 1;
                SharedPreferences obj = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor edit = obj.edit();
                edit.putInt("isloggedin", isloggedin);
                edit.commit();
                Intent mainpage = new Intent(this, topics.class);
                this.startActivity(mainpage);
                finish();
        }
        if(v.equals(signup))
        {
            s1 = name.getText().toString();
            s2 = password.getText().toString();
            /*db.execSQL("INSERT INTO security ( name , password ) VALUES ( '"+s1+"', "+s2+") ");*/
            Toast.makeText(this,"Thank you for signing up !!",Toast.LENGTH_SHORT).show();
            isloggedin = 1;
            SharedPreferences obj = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor edit = obj.edit();
            edit.putInt("isloggedin", isloggedin);
            edit.commit();
            Intent mainpage = new Intent(this, topics.class);
            this.startActivity(mainpage);
            finish();
        }
    }

    /*public boolean exists(String name ,String password)
    {
        String sname = "";
        String spass = "";
        Cursor cur = db.rawQuery("SELECT * FROM security ",null);
        cur.moveToFirst();
        while (cur.isAfterLast() == false) {

            sname = cur.getString(0);
            spass = cur.getString(1);

            if(sname.equals(name) && spass.equals(password))
                return true;

            cur.moveToNext();
        }
        return false;
    }*/
}
