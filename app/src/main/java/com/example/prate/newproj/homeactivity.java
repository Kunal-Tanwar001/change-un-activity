package com.example.prate.newproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class homeactivity extends AppCompatActivity {
TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        Intent id=getIntent();
        t1=findViewById(R.id.tx1);
        t2=findViewById(R.id.tx2);
        t3=findViewById(R.id.tx3);
        t4=findViewById(R.id.tx4);
        String name1= id.getStringExtra("myname");
        t1.setText("Name = "+ name1);
        int age1=id.getIntExtra("myage",0);
        t2.setText("Age ="+age1);
        String sex1=id.getStringExtra("sex" );
        t3.setText("Sex ="+sex1);
        String email1=id.getStringExtra("myemail");
        t4.setText("Email ="+email1);

    }
}
