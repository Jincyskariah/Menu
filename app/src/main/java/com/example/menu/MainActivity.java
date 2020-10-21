package com.example.menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hello;
    Button button;
    EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello=findViewById(R.id.txt);
        button=findViewById(R.id.btn);
        data=findViewById(R.id.txtdata);
        registerForContextMenu(button);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(),0,"call");
        menu.add(0,v.getId(),0,"sms");
        menu.add(0,v.getId(),0,"share");
        menu.add(0,v.getId(),0,"browser");
        menu.add(0,v.getId(),0,"map");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("call"))
        {
            String inputcut=data.getText().toString();
            Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+inputcut));
            startActivity(intent);
        }
        else if(item.getTitle().equals("sms"))
        {
            String input=data.getText().toString();
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.putExtra("sms_body", "default content");
            sendIntent.setType("vnd.android-dir/mms-sms");
            startActivity(sendIntent);


        }
        else if(item.getTitle().equals("share"))
        {

            String inputshare=data.getText().toString();
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:"+inputshare));
          startActivity(intent);
        }
        else if(item.getTitle().equals("browser"))
        {
            String inputbrowser=data.getText().toString();
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http:/www.google.com"));
            startActivity(intent);
        }
        else if(item.getTitle().equals("map"))
        {
            String inputdata=data.getText().toString();
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:20.5937,78.9629"));
            startActivity(intent);
        }


        return super.onContextItemSelected(item);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.txtcut)
        {
            Toast.makeText(this, "cut", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.txtcopy)
        {
            Toast.makeText(this, "copy", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.txtdel)
        {
            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
