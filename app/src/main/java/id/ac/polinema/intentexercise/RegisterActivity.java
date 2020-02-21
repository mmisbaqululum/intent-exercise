package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import model.user;

public class RegisterActivity extends AppCompatActivity {

    public static final String USER_KEY = "user";

    private TextInputEditText nameInput;
    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;
    private TextInputEditText confirmInput;
    private TextInputEditText homepageInput;
    private TextInputEditText aboutInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameInput = findViewById(R.id.text_fullname);
        emailInput = findViewById(R.id.text_email);
        passwordInput = findViewById(R.id.text_password);
        confirmInput = findViewById(R.id.text_confirm_password);
        homepageInput = findViewById(R.id.text_homepage);
        aboutInput = findViewById(R.id.text_about);



    }

    public void handleProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confirm = confirmInput.getText().toString();
        String homepage = homepageInput.getText().toString();
        String about = aboutInput.getText().toString();

        user user1 = new user(name, email, password, confirm, homepage, about);

        intent.putExtra(USER_KEY, user1);
        startActivity(intent);
    }
}
