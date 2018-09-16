package com.ravirathee.a106_extraSEND_VIEW_DIAL_Intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ravirathee.a106_extratextintent.R;

import static android.content.Intent.ACTION_SEND;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button_send_url;
    Button button_send_text;
    Button button_send_number;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_send_url = findViewById(R.id.button_send_url);
        button_send_url.setOnClickListener(this);

        button_send_text = findViewById(R.id.button_send_text);
        button_send_text.setOnClickListener(this);

        button_send_number = findViewById(R.id.button_send_number);
        button_send_number.setOnClickListener(this);

        et = findViewById(R.id.et);


    }


    @Override
    public void onClick(View v) {

        Toast.makeText(this,"onClick",Toast.LENGTH_LONG).show();

        if(v.getId()==R.id.button_send_url){
//      To send url
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            Uri data = Uri.parse("http://google.com");
            i.setData(data);
            startActivity(i);
        }else if(v.getId()==R.id.button_send_text){
            //  To send text
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT , et.getText().toString() );
                startActivity(i);
        }else if(v.getId()==R.id.button_send_number){
            //To send number
            Uri number = Uri.parse("tel:"+Uri.encode("*124#"));
            Intent i = new Intent(Intent.ACTION_DIAL, number);
            i.putExtra(Intent.EXTRA_TEXT , et.getText().toString() );
            startActivity(i);
        }
          //To send
//        Intent intent = new Intent();
////        intent.setAction(Intent.ACTION_VIEW);
////        Uri imgUri = Uri.parse("file://sdcard/Download");
////        intent.setDataAndType(imgUri, "image/*");
////        startActivity(intent);

    }
}
