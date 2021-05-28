package com.example.hi.bluetoothfinal2;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class secondpage extends Activity {

  ImageView image1,image2,image3;
    ToggleButton TB1,TB2,TB3;

  //  SeekBar SB1;
    Button B1,B2,B3,B4;

    String address=null;
    String name=null;
    BluetoothAdapter mybluetooth=null;
    BluetoothSocket btsocket=null;
    Set<BluetoothDevice> pairedDevices;
    static final UUID myUUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        try
        {
            setw();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void setw() throws IOException
    {
        bluetooth_connect_device();
        TB1= (ToggleButton) findViewById(R.id.simpleToggleButton1);
        TB2= (ToggleButton) findViewById(R.id.simpleToggleButton2);
        TB3= (ToggleButton) findViewById(R.id.simpleToggleButton3);

    image1 = (ImageView) findViewById(R.id. imageView1);
        image2 = (ImageView) findViewById(R.id. imageView2);
        image3 = (ImageView) findViewById(R.id. imageView3);
     //   SB1= (SeekBar) findViewById(R.id.seekBar1);
        B1= (Button) findViewById(R.id.offButton);
        B2= (Button) findViewById(R.id.lowButton);
        B3= (Button) findViewById(R.id.medButton);
        B4= (Button) findViewById(R.id.highButton);

 /*       TB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                led_on_off("QLP001");
            }
        });
*/        TB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

            if (checked) {
                image1.setImageDrawable(getResources().getDrawable(R.drawable.selected_image1));
                Toast.makeText(secondpage.this, "Light 1 Turning on..", Toast.LENGTH_SHORT).show();
                led_on_off("QLP001");
            } else {
                image1.setImageDrawable(getResources().getDrawable(R.drawable.unselected_image1));
                Toast.makeText(secondpage.this, "Light 1 Turning off..", Toast.LENGTH_SHORT).show();
                led_on_off("QLP002");
            }
        }
    });

  /*      TB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                led_on_off("QLP002");
            }
        });
        TB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                led_on_off("QLP003");
            }
        });      */




    /*    f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                led_on_off("s");
            }
        });   */

     /*button.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
             {
                if(event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    led_on_off("f");
                }
                if(event.getAction()==MotionEvent.ACTION_UP)
                {
                    led_on_off("b");
                }
                return true;
            }
        });*/


        TB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if (checked) {
                    image2.setImageDrawable(getResources().getDrawable(R.drawable.selected_image1));
                    Toast.makeText(secondpage.this, "Light 2 Turning on..", Toast.LENGTH_SHORT).show();
                    led_on_off("QLP003");
                } else {
                    image2.setImageDrawable(getResources().getDrawable(R.drawable.unselected_image1));
                    Toast.makeText(secondpage.this, "Light 2 Turning off..", Toast.LENGTH_SHORT).show();
                    led_on_off("QLP004");
                }
            }
        });

        TB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if (checked) {
                    image3.setImageDrawable(getResources().getDrawable(R.drawable.selected_image1));
                    Toast.makeText(secondpage.this, "Light 3 Turning on..", Toast.LENGTH_SHORT).show();
                    led_on_off("QLP005");
                } else {
                    image3.setImageDrawable(getResources().getDrawable(R.drawable.unselected_image1));
                    Toast.makeText(secondpage.this, "Light 3 Turning off..", Toast.LENGTH_SHORT).show();
                    led_on_off("QLP006");
                }
            }
        });

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(secondpage.this, "Fan Turning off..", Toast.LENGTH_SHORT).show();
                led_on_off("QFN001");
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(secondpage.this, "Fan in Low Speed..", Toast.LENGTH_SHORT).show();
                led_on_off("QFN002");
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(secondpage.this, "Fan in Medium Speed..", Toast.LENGTH_SHORT).show();
                led_on_off("QFN003");
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(secondpage.this, "Fan in High Speed..", Toast.LENGTH_SHORT).show();
                led_on_off("QFN004");
            }
        });

    }
    private void bluetooth_connect_device() throws IOException
    {
        try
        {
            mybluetooth= BluetoothAdapter.getDefaultAdapter();
            address=mybluetooth.getAddress();
            pairedDevices=mybluetooth.getBondedDevices();
            if(pairedDevices.size()>0)
            {
                for(BluetoothDevice bt: pairedDevices)
                {
                    address=bt.getAddress().toString();name=bt.getName().toString();
                    //  Toast.makeText(getApplication(),"Connected",Toast.LENGTH_SHORT).show();
                  //  Toast.makeText(getApplication(), name.concat(address), Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        mybluetooth =BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice dispositivo= mybluetooth.getRemoteDevice(address);
        btsocket=dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
        btsocket.connect();
        try
        {
        //    textView1.setText("BT Name:"+name+"\n Bt Address:"+address);
          //  Toast.makeText(getApplication(),name.concat(address),Toast.LENGTH_SHORT).show();
              Toast.makeText(getApplication(),"Connected with System",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    private void led_on_off(String l)
    {
        try
        {
            if(btsocket!=null)
            {
                btsocket.getOutputStream().write(l.toString().getBytes());
            }
        }
        catch(Exception e)
        {
            Toast.makeText(getApplication(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}