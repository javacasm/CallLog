package com.foc.pmdm.u5.calllog;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            Uri llamadas = Uri.parse("content://call_log/calls/");
            Cursor c = getContentResolver().query(llamadas, new String[]{CallLog.Calls.NUMBER, CallLog.Calls.DATE}, null, null, null);
            //Cursor c=getContentResolver().query(llamadas, null, null, null, null);


            ListView lv=(ListView)findViewById(R.id.listView);
            lv.setAdapter(new miAdaptador(this,c));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
