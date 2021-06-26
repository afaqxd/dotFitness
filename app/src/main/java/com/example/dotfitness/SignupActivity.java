package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    TextInputLayout text_name;
    TextInputLayout text_username;
    TextInputLayout text_email;
    TextInputLayout text_password;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    TextView text_olduser_login;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        text_name = findViewById(R.id.edt_signup_name);
        text_email = findViewById(R.id.edt_signup_email);
        text_username = findViewById(R.id.edt_signup_username);
        text_password = findViewById(R.id.edt_signup_password);

        text_olduser_login = findViewById(R.id.tv_desc_login);
        btn_signup = findViewById(R.id.btn_signup_signup);

        text_olduser_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateName() | !validateUsername() | !validateEmail() | !validatePassword()) {
                    return;
                }

                String name = text_name.getEditText().getText().toString();
                String username = text_username.getEditText().getText().toString();
                String email = text_email.getEditText().getText().toString();
                String password = text_password.getEditText().getText().toString();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Courses");

                UserHelperClass helperClass = new UserHelperClass(name, username, email, password);

                reference.child(username).setValue(helperClass);

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }


    private Boolean validateName() {
        String val = text_name.getEditText().getText().toString();
        if (val.isEmpty()) {
            text_name.setError("Field cannot be empty");
            return false;
        } else {
            text_name.setError(null);
            text_username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = text_username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{2,20}\\z";


        if (val.isEmpty()) {
            text_username.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 11) {
            text_username.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            text_username.setError("No white spaces allowed");
            return false;
        } else {
            text_username.setError(null);
            text_username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = text_email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            text_email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            text_email.setError("Invalid email address");
            return false;
        } else {
            text_email.setError(null);
            text_email.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = text_password.getEditText().getText().toString();

        if (val.isEmpty()) {
            text_password.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 7 ) {
            text_password.setError("Password too long");
            return false;
        }else {
            text_password.setError(null);
            text_password.setErrorEnabled(false);
            return true;
        }
    }


}