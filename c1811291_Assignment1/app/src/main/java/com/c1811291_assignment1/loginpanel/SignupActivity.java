package com.c1811291_assignment1.loginpanel;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {

    Button SignupButton;
    EditText editTextEmail;
    EditText passCheck;
    TextView errorText;
    EditText nameCheck;
    EditText PhoneCheck;
    boolean namebol,passbol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextEmail = findViewById(R.id.editTextEmail);
        passCheck = findViewById(R.id.editTextPassword);
        SignupButton = findViewById(R.id.signupButton);
        errorText = findViewById(R.id.errorText2);
        nameCheck = findViewById(R.id.editTextName);
        PhoneCheck = findViewById(R.id.editTextMobile);

        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullcheck();
            }
        });
    }

    public void check() {

            if(namebol==false && passbol ==false)
            {
                errorText.setText("Name or Password is not Empty!");
            }

        validateMobile(PhoneCheck);
        validateEmailAdress(editTextEmail);

    }
    public void fullcheck()
    {
        if (nameCheck.getText().toString().trim().equals("") && PhoneCheck.getText().toString().trim().equals("") && editTextEmail.getText().toString().trim().equals("") && passCheck.getText().toString().trim().equals("")) {
        errorText.setText("Please fill all area!");
        }
        else
        {
            check();
        }
    }
    public void nameCheck(boolean pass) {
        if (nameCheck.getText().toString().trim().equals("")) {
            errorText = (TextView) findViewById(R.id.errorText2);
            errorText.setText("Name/Surname area is not empty!");
            pass = false;
        }
    }

    public void passCheck(boolean name) {
        if (passCheck.getText().toString().trim().equals("")) {
            errorText = (TextView) findViewById(R.id.errorText1);
            errorText.setText("Password area is not empty!");
            name = false;
        }
    }

    public boolean validateEmailAdress(EditText editTextEmail) {
        String emailInput = editTextEmail.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;
        } else {
            errorText.setText("it's wrong Email Format!");
            return false;
        }
    }

    public boolean validateMobile(EditText editTextMobil) {
        String mobilInput = editTextMobil.getText().toString();

        if (!mobilInput.isEmpty() && Patterns.PHONE.matcher(mobilInput).matches()) {
            return true;
        } else {
            errorText.setText("it's wrong MobilPhone Format!");
            return false;
        }
    }

    public void signin (View view){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
