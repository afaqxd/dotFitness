package com.example.dotfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout text_username_login;
    TextInputLayout text_password_login;
    TextView text_newuser_signup;
    Button btn_login;
    CheckBox checkbox;
    boolean alreadySignedIn;
    SharedPreferences sh;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_username_login = findViewById(R.id.edt_login_username);
        text_password_login = findViewById(R.id.edt_login_password);
        text_newuser_signup = findViewById(R.id.tv_desc_signup);
        btn_login = findViewById(R.id.btn_login);
        checkbox = findViewById(R.id.checkbox_remember);
        sh = getSharedPreferences("DATA",MODE_PRIVATE);
        editor = sh.edit();

        text_username_login.getEditText().setText(sh.getString("N",""));
        text_password_login.getEditText().setText(sh.getString("P",""));
        alreadySignedIn = sh.getBoolean("IsLoggedIn",false);

        LoadingDialog loadingDialog = new LoadingDialog(LoginActivity.this);

        text_newuser_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        if(alreadySignedIn){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateUsername() | !validatePassword()) {
                    return;
                } else {
                    validateUser();
                }
                loadingDialog.startDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.stopDialog();
                    }
                },3000);


            }
        });


    }

    private void validateUser() {
        String user_enteredUsername = text_username_login.getEditText().getText().toString().trim();
        String user_enteredPassword = text_password_login.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Courses");

        Query checkUser = reference.orderByChild("username").equalTo(user_enteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    text_username_login.setError(null);
                    text_username_login.setErrorEnabled(false);
                    String passwordFromDB = snapshot.child(user_enteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(user_enteredPassword)) {

                        String nameFromDB = snapshot.child(user_enteredUsername).child("name").getValue(String.class);
                        text_username_login.setError(null);
                        text_username_login.setErrorEnabled(false);


                        if(checkbox.isChecked()){
                            editor.putString("N",user_enteredUsername);
                            editor.putString("P",user_enteredPassword);
                            editor.putBoolean("IsLoggedIn",true);
                            editor.apply();
                        }


                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name1",nameFromDB);
                        startActivity(intent);

                    } else {
                        text_password_login.setError("Wrong password");
                        text_password_login.requestFocus();
                    }
                } else {
                    text_username_login.setError("No user found");
                    text_username_login.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private Boolean validateUsername() {
        String val = text_username_login.getEditText().getText().toString();


        if (val.isEmpty()) {
            text_username_login.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 11) {
            text_username_login.setError("Username too long");
            return false;
        } else {
            text_username_login.setError(null);
            text_username_login.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = text_password_login.getEditText().getText().toString();

        if (val.isEmpty()) {
            text_password_login.setError("Field cannot be empty");
            return false;
        } else {
            text_password_login.setError(null);
            text_password_login.setErrorEnabled(false);
            return true;
        }

    }


}