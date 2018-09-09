package com.example.avrad.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Science extends AppCompatActivity implements View.OnClickListener{

    RadioButton one1,one2,one3,one4,two1,two2,two3,two4,three1,three2,three3,three4,four1,four2,four3,four4,five1,five2,five3,five4;
    Button submit;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.science);

        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);

        one1 =(RadioButton)findViewById(R.id.one1);
        one2 =(RadioButton)findViewById(R.id.one2);
        one3 =(RadioButton)findViewById(R.id.one3);
        one4 =(RadioButton)findViewById(R.id.one4);

        two1 =(RadioButton)findViewById(R.id.two1);
        two2 =(RadioButton)findViewById(R.id.two2);
        two3 =(RadioButton)findViewById(R.id.two3);
        two4 =(RadioButton)findViewById(R.id.two4);

        three1 =(RadioButton)findViewById(R.id.three1);
        three2 =(RadioButton)findViewById(R.id.three2);
        three3 =(RadioButton)findViewById(R.id.three3);
        three4 =(RadioButton)findViewById(R.id.three4);

        four1 =(RadioButton)findViewById(R.id.four1);
        four2 =(RadioButton)findViewById(R.id.four2);
        four3 =(RadioButton)findViewById(R.id.four3);
        four4 =(RadioButton)findViewById(R.id.four4);

        five1 =(RadioButton)findViewById(R.id.five1);
        five2 =(RadioButton)findViewById(R.id.five2);
        five3 =(RadioButton)findViewById(R.id.five3);
        five4 =(RadioButton)findViewById(R.id.five4);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(submit))
        {
           score = calcscore();
           send("Your score in Science is "+score+"/5");
           score=0;
        }
    }
    public void send(String s)
    {
        Bundle b = new Bundle();
        Intent obj=new Intent(this,topics.class);
        b.putString("SCORE", s);
        obj.putExtras(b);
        this.startActivity(obj);
        finish();

    }
    public int calcscore()
    {
        if(one2.isChecked())
            score++;
        if(two4.isChecked())
            score++;
        if(three1.isChecked())
            score++;
        if(four3.isChecked())
            score++;
        if(five3.isChecked())
            score++;

        return score;
    }
}
