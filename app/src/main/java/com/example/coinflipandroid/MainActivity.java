package com.example.coinflipandroid;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int headCounter = 0;
    int tailCounter = 0;
    int clickCounter = 0;
    String hc;
    String tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void flipCoins(View view){

        Button b = (Button) findViewById(R.id.button_flip);
        final ImageView leftImg = (ImageView) findViewById(R.id.left);
        final ImageView rightImg = (ImageView) findViewById(R.id.right);
        final TextView headText = (TextView) findViewById(R.id.headCounter);
        final TextView tailText = (TextView) findViewById(R.id.tailCounter);

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Random ranRight = new Random();
                Random ranLeft = new Random();
                clickCounter++;

                if (ranLeft.nextBoolean() == true){
                   headCounter++;
                   leftImg.setImageResource(R.mipmap.heads);
                   hc = Integer.toString(headCounter);
                   headText.setText(hc);
                }
                if (ranLeft.nextBoolean() == false){
                    leftImg.setImageResource(R.mipmap.tails);
                    tailCounter++;
                    tc = Integer.toString(tailCounter);
                    tailText.setText(tc);
                }
                if (ranRight.nextBoolean() == true){
                    rightImg.setImageResource(R.mipmap.heads);
                    headCounter++;
                    hc = Integer.toString(headCounter);
                    headText.setText(hc);
                }
                if (ranRight.nextBoolean() == false){
                    rightImg.setImageResource(R.mipmap.tails);
                    tailCounter++;
                    tc = Integer.toString(tailCounter);
                    tailText.setText(tc);
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
}
