package com.c1811291_assignment1.loginpanel;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    Button LoginButton;
    EditText editTextEmail;
    EditText passCheck;
    TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        passCheck = findViewById(R.id.editTextPassword);
        LoginButton = findViewById(R.id.LoginButton);
        errorText = findViewById(R.id.errorText1);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmailAdress(editTextEmail);
                passCheck();
            }
        });
    }
    public void passCheck()
    {
        if(passCheck.getText().toString().trim().equals("") )
        {
            errorText = (TextView) findViewById(R.id.errorText1);
            errorText.setText("Password area is not empty!");
        }

    }
        private boolean validateEmailAdress (EditText editTextEmail) {
            String emailInput = editTextEmail.getText().toString();

            if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                Toast.makeText(this, "it's true Email Format!", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                errorText.setText("it's wrong Email Format!");
                return false;
            }
        }


    public void signup (View view){
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(intent);
        }
    }
