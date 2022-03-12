package com.c1811291_assignment1.loginpanel;
import android.content.Intent;
import android.os.Bundle;
import com.c1811291_assignment1.loginpanel.R;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void signin (View view){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}