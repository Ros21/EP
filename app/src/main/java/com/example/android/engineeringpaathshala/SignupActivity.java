package com.example.android.engineeringpaathshala;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Roshan on 11/22/2016.
 */
public class SignupActivity extends AppCompatActivity implements View.OnClickListener{


    //defining view objects
    private EditText editTextName;
    private EditText editContactNumber;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;
    private ProgressDialog progressDialog;

    private DatabaseReference mDatabase;
    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
//        if (firebaseAuth.getCurrentUser() != null) {
//            startActivity(new Intent(SignupActivity.this, Welcome.class));
//            finish();
//        }

        setContentView(R.layout.activity_signup);

        //initializing firebase auth object

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        //initializing views
        editTextName = (EditText) findViewById(R.id.editNameField);
        editContactNumber = (EditText) findViewById(R.id.editContactField);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonSignup = (Button) findViewById(R.id.buttonSignup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(this);
    }

    private void registerUser(){

        //getting email and password from edit texts
        final String name = editTextName.getText().toString().trim();
        final String contactNumber = editContactNumber.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG).show();
            return;
        }

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            String user_id = firebaseAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = mDatabase.child(user_id);
                            current_user_db.child("E-mail").setValue(email);
                            current_user_db.child("Contact Number").setValue(contactNumber);
                            current_user_db.child("Name").setValue(name);

                            Toast.makeText(SignupActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        }else{
                            //display some message here
                            Toast.makeText(SignupActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View view) {
        //calling register method on click
        registerUser();
    }
}
