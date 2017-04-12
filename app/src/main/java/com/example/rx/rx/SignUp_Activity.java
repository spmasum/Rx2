package com.example.rx.rx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Masum on 10-Apr-17.
 */

public class SignUp_Activity extends AppCompatActivity{
    EditText userNameSpET;
    EditText userEmailSpET;
    EditText userPassSpET;

    SavedData login_authentication;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        userNameSpET= (EditText) findViewById(R.id.userNameSP);
        userEmailSpET= (EditText) findViewById(R.id.userEmailSP);
        userPassSpET= (EditText) findViewById(R.id.userPassSP);
        login_authentication=new SavedData(this);

    }

    public void createAccount(View view) {
        String name=userNameSpET.getText().toString();
        String email=userEmailSpET.getText().toString();
        String pass=userPassSpET.getText().toString();
        if(!name.isEmpty() && !email.isEmpty() && !pass.isEmpty()){
            login_authentication.saveData(name,email,pass);
            Toast.makeText(SignUp_Activity.this,"Thank you For Registration",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(SignUp_Activity.this,MainActivity.class);
            startActivity(intent);
        }
        else {
           if (name.isEmpty()){
               userNameSpET.setError("Name can't be empty");
           }
            if (email.isEmpty()){
               userEmailSpET.setError("Email can't be empty");
           }
           if (pass.isEmpty()){
               userPassSpET.setError("Password can't be empty");
           }
        }


    }
}
