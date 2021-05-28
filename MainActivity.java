package com.example.hi.bluetoothfinal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button b1;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button1);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(ed1.getText().toString().equals("sece") && ed2.getText().toString().equals("ece"))
                {
                    Toast.makeText(getApplicationContext(), "Login Successful...", Toast.LENGTH_SHORT).show();
                    ed1.setText("");
                    ed2.setText("");

                    Intent i = new Intent(getApplicationContext(), secondpage.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Login Credentials",Toast.LENGTH_SHORT).show();
                    ed1.setText("");
                    ed2.setText("");
                }
            }
        });
    }
}