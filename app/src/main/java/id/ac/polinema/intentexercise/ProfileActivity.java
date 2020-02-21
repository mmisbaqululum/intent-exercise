package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import model.user;

public class ProfileActivity extends AppCompatActivity {

    public static final String USER_KEY = "user";

    private TextView nameText;
    private TextView emailText;
    private TextView passwordText;
    private TextView confirmText;
    private TextView homepageText;
    private TextView aboutText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameText = findViewById(R.id.text_fullname);
        emailText = findViewById(R.id.text_email);
        passwordText = findViewById(R.id.text_password);
        confirmText = findViewById(R.id.text_confirm_password);
        homepageText = findViewById(R.id.text_homepage);
        aboutText = findViewById(R.id.text_about);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            user data = getIntent().getParcelableExtra(USER_KEY);
            nameText.setText(data.getName());
            emailText.setText(data.getEmail());
            passwordText.setText(data.getPassword());
            confirmText.setText(data.getConfirm());
            homepageText.setText(data.getHomepage());
            aboutText.setText(data.getAbout());

        }


    }



}
