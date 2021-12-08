package com.infinityandroid.chatapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.infinityandroid.chatapp.databinding.ActivityForgotPasswordBinding;


import java.util.regex.Pattern;

public class ForgotPassword extends AppCompatActivity {

    private ActivityForgotPasswordBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners() {
        firebaseAuth = FirebaseAuth.getInstance();

        binding.textSignIn.setOnClickListener(v -> onBackPressed());
        binding.buttonForgotPass.setOnClickListener(v -> {
            loading(true);

            if(isValidEmailId(binding.inputEmail.getText().toString())) {
                firebaseAuth.sendPasswordResetEmail(binding.inputEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Check Your Email To Reset Your Password!", Toast.LENGTH_LONG).show();
                        }else {
                            loading(false);
                            Toast.makeText(getApplicationContext(), "Account Does Not Exist!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
            else {
                loading(false);
                Toast.makeText(getApplicationContext(), "Enter XU Email", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidEmailId(String email){
        return Pattern.compile("[0-9]+@my.xu.edu.ph").matcher(email).matches();
    }

    private void loading(Boolean isLoading) {
        if(isLoading) {
            binding.buttonForgotPass.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }else {
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonForgotPass.setVisibility(View.VISIBLE);
        }
    }
}

