package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import id.ac.polinema.intentexercise.model.user;

public class ProfileActivity extends AppCompatActivity {

    public static final String USER_KEY = "user";

    private TextView label_about;
    private TextView label_fullname;
    private TextView label_email;
    private TextView label_homepage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        label_about = findViewById(R.id.text_fullname);
        label_fullname = findViewById(R.id.text_email);
        label_email = findViewById(R.id.text_password);
        label_homepage = findViewById(R.id.text_confirm_password);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            user user1 = getIntent().getParcelableExtra(USER_KEY);
            label_about.setText(user1.getAbout());
            label_fullname.setText(user1.getName());
            label_email.setText(user1.getEmail());
            label_homepage.setText(user1.getHomepage());


        }


    }



}
