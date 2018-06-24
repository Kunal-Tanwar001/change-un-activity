package com.example.prate.newproj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText name,age,email;
Button b1;
RadioButton r1;
RadioGroup radio;
SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int radioid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         b1=findViewById(R.id.button);
         email=findViewById(R.id.email);
         age=findViewById(R.id.age);
         name=findViewById(R.id.name);
         b1.setOnClickListener(this);
         radio=findViewById(R.id.radiogroup);
         sharedPreferences=getSharedPreferences("xyname",MODE_PRIVATE);
         String nameprev=sharedPreferences.getString("xyname",null);
         String emailprev=sharedPreferences.getString("xyemail",null);
         int ageprev=sharedPreferences.getInt("xyage",0);
        int sexprev=sharedPreferences.getInt("xyz",0);

         if(emailprev!=null){
             email.setText(emailprev);
         }
         if(ageprev!=0){
             age.setText(ageprev+"");
         }
         if(nameprev!=null){
             name.setText(nameprev);
         }
         if(sexprev!=0){
            if(sexprev==radioid){
                r1.setChecked(true);

            }


         }

        }


    @Override
    public void onClick(View v) {
        String nameEnter,emailEnter;
        int ageEnter;
        nameEnter=name.getText().toString();
        emailEnter=email.getText().toString();
        ageEnter=Integer.parseInt(age.getText().toString());
        Intent intent =new Intent(this,homeactivity.class);
        intent.putExtra("myname",nameEnter);
        intent.putExtra("myemail",emailEnter);
        intent.putExtra("myage",ageEnter);
       String l= lol();
       intent.putExtra("sex",l);
      editor=sharedPreferences.edit();
       editor.putString("xyname",nameEnter);
       editor.putString("xyemail",emailEnter);
         editor.putInt("xysex",radioid);
       editor.putInt("xyage",ageEnter);
       editor.commit();

       startActivity(intent);

    }
    public String lol(){
        radioid=radio.getCheckedRadioButtonId();

        r1=findViewById(radioid);


        return (String) r1.getText();
    }
}
