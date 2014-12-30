package com.example.dell.checkwifisignal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
//    public int numberOfLevel = 5;
//    WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//    public int currentSignal = wifiManager.getConnectionInfo().getRssi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int numberOfLevel = 5;
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        int currentSignal = wifiManager.getConnectionInfo().getRssi();
        String currentSSID = wifiManager.getConnectionInfo().getSSID();

        TextView signal = (TextView) findViewById(R.id.txtSignal);
        TextView ssid = (TextView) findViewById(R.id.txtSSID);

        String strSignal = String.valueOf(currentSignal);
        String strSSID = String.valueOf(currentSSID);

        signal.setText(strSignal);
        ssid.setText(strSSID);
    }

    public void onClick_Refresh(View view){
        Button button = (Button) findViewById(R.id.btnRefresh);
        button.setClickable(false);
        button.setText("Refreshing..");

        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        int currentSignal = wifiManager.getConnectionInfo().getRssi();
        String currentSSID = wifiManager.getConnectionInfo().getSSID();

        //float fltcurrSignal = (float) currentSignal;
        TextView signal = (TextView) findViewById(R.id.txtSignal);
        TextView ssid  = (TextView) findViewById(R.id.txtSSID);


        String strSignal = String.valueOf(currentSignal);
        String strSSID = String.valueOf(currentSSID);

        signal.setText(strSignal);
        ssid.setText(strSSID);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if(currentSignal < -50){
            linearLayout.setBackgroundColor(Color.parseColor("#FF0000"));
            Toast.makeText(getApplicationContext(),"-50 true", Toast.LENGTH_LONG).show();
            vibrator.vibrate(3000);
            button.setClickable(true);
            button.setText("Refresh");
        } else {
            linearLayout.setBackgroundColor(Color.parseColor("#FFFF00"));
            Toast.makeText(getApplicationContext(),"-50 false", Toast.LENGTH_LONG).show();
            vibrator.vibrate(500);
            button.setClickable(true);
            button.setText("Refresh");
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
