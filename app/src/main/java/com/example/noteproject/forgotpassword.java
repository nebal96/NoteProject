package com.example.noteproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class forgotpassword extends AppCompatActivity {
    EditText forgotEmail ;
    ImageView back;
    Button forgotbtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        forgotEmail = findViewById(R.id.forgotet);
        back = findViewById(R.id.back);
        forgotbtn = findViewById(R.id.forgotbtn);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        forgotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotpassword.this.doforgotpassword(forgotEmail.getText().toString());
            }
        });



    }
    
    
    private void doforgotpassword(String email) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(forgotpassword.this, checkemail.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(forgotpassword.this, "Password Reset failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
