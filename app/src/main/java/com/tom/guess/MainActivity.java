package com.tom.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int secret;
    private EditText edNumber;
    private TextView message;
    int counter;
    private TextView edCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "secert" + secret);
        edCounter = findViewById(R.id.counter);
        edCounter.setText(counter+"");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edNumber = findViewById(R.id.num);
        message = findViewById(R.id.message);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        reset();
        Log.d("MainActivity", "secert" + secret);
    }
    public void reset() {
        secret = new Random().nextInt(10) + 1;
        counter = 0;
        edCounter.setText(counter+"");
    }
    public void guess(View view) {
        int number = Integer.parseInt(edNumber.getText().toString());
        counter++;
        edCounter.setText(counter+"");
        if (number < secret) {
            //message.setText("Bigger");
            new AlertDialog.Builder(MainActivity.this).setTitle("Result").setMessage("Bigger").setPositiveButton("OK",null).setIcon(R.drawable.ghost).show();
        } else if (number > secret) {
            //message.setText("Smaller");
            new AlertDialog.Builder(MainActivity.this).setTitle("Result").setMessage("Smaller").setPositiveButton("OK",null).setIcon(R.drawable.ghost).show();
        } else {
            //message.setText("Bingo, the secret number is : " + secret);
            new AlertDialog.Builder(MainActivity.this).setTitle("Result").setMessage("Bingo, the secret number is : " + secret).setIcon(R.drawable.correct).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reset();
                }
            }).show();
        }
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
