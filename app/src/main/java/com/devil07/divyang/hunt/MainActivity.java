package com.devil07.divyang.hunt;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView questions;
    EditText answers;
    Button  next;
    int i;
    int ans;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inivariables();
        checkIvalue();
        setquestion();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i <= 5 && checkanswer()) {

                    i++;
                    setI(i);
                    if (i == 6) {
                        Toast.makeText(getApplicationContext(), "winner", Toast.LENGTH_SHORT).show();
                    } else {

                        setquestion();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "wrong code", Toast.LENGTH_SHORT).show();
                }


            }
        });

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
    void inivariables()
    {
        questions=(TextView)findViewById(R.id.questions);
        answers=(EditText)findViewById(R.id.answers);
        next=(Button)findViewById(R.id.next);
        i=0;
        sharedPreferences=getSharedPreferences("ques",MODE_PRIVATE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    void setquestion()
    {
        switch (i)
        {
            case 0:
            {

                questions.setText("Q1: what is your name");
                ans = 1234;
                break;
            }
            case 1:
            {

                questions.setText("Q2: broooooo");
                ans = 14;
                break;
            }
            case 2:
            {

                questions.setText("Q3: coolzzzzzzzz");
                ans = 234;
                break;
            }
            case 3:
            {

                questions.setText("Q4: zzzzzzzzzzze");
                ans = 123;
                break;
            }
            case 4:
            {

                questions.setText("Q5: devillllllll");
                ans = 134;
                break;
            }
            case 5:
            {

                questions.setText("Q6: super");
                ans = 124;
                break;
            }


        }



    }
    boolean checkanswer()
    {
        String k;
        int m;
        k=answers.getText().toString();
        if(k.equals(""))
        {
            m = 0;
        }
        else
        {

            m = Integer.parseInt(k);
        }

        if(ans==m)
        {
         return true;
        }
        else
        {
            return false;
        }
    }
    void checkIvalue()
    {
        int w;
        w=sharedPreferences.getInt("i",99);
        if(w==99)
        {
            i=0;

        }
        else if (w==6)
        {
            Toast.makeText(getApplicationContext(),"winner",Toast.LENGTH_SHORT).show();
            //finish

        }
        else
        {
            i = w;
        }

    }
    void setI(int m)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("i",m);
        editor.commit();
    }


}
