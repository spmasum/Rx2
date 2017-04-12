package com.example.rx.rx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //its all for login layout
    private EditText emailEt;
    private EditText passwordEt;



    private SavedData savedData;//share preference class
    private LinearLayout layoutLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAll();//initializing all variable
    }

    private void initializeAll() {
        // for log in layout
        emailEt = (EditText) findViewById(R.id.emailEt);
        passwordEt = (EditText) findViewById(R.id.passwordEt);




        savedData = new SavedData(this);


    }


    public void buttonOnclick(View view) {

        if (view.getId() == R.id.loginBtn){

            String email = emailEt.getText().toString();
            String password = passwordEt.getText().toString();

            //if password or email is empty then this method will be called

            if (email.isEmpty() || password.isEmpty()){
                if (email.isEmpty()){
                    emailEt.setError("Email can,t be empty");
                }
                if (password.isEmpty()){
                    passwordEt.setError("Password can,t be empty");
                }

                return;
            }

            //when email is pass is not empty then this line will be execute
            if (email.equals(savedData.getEmail()) && password.equals(savedData.getPassword())){
                //if email and password is correct then it will be execute
                startActivity(new Intent(MainActivity.this,Doctors.class));
            }else {
                Toast.makeText(MainActivity.this,"Wrong user email or password",Toast.LENGTH_LONG).show();
            }

        }else if (view.getId() == R.id.signupBtn) {
                startActivity(new Intent(MainActivity.this,SignUp_Activity.class));
        }
    }



}
