package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URI;

import id.ac.polinema.intentexercise.R;

public class ProfileActivity extends AppCompatActivity {

    public static final String FULL_KEY = "fullname";
    public static final String EMAIL_KEY = "email";
    public static final String HOMEPAGE_KEY = "homepage";
    public static final String ABOUT_KEY = "about";
    public static final String IMAGE_KEY = "image";

    private TextView aboutme;
    private TextView fullname;
    private TextView email;
    private TextView homepage;
    private ImageView avatar;
    private Uri uri;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        aboutme = findViewById(R.id.label_about);
        fullname = findViewById(R.id.label_fullname);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);
        avatar = findViewById(R.id.image_profile);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            aboutme.setText(extras.getString(ABOUT_KEY));
            email.setText(extras.getString(EMAIL_KEY));
            homepage.setText(extras.getString(HOMEPAGE_KEY));
            url = extras.getString(HOMEPAGE_KEY);
            fullname.setText(extras.getString(FULL_KEY));
            uri = Uri.parse(extras.getString(IMAGE_KEY));
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            avatar.setImageBitmap(bitmap);
        }
    }
}