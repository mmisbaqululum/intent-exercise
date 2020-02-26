package id.ac.polinema.intentexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import id.ac.polinema.intentexercise.model.user;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    public static final String FULL_KEY = "fullname";
    public static final String EMAIL_KEY = "email";
    public static final String HOMEPAGE_KEY = "homepage";
    public static final String ABOUT_KEY = "about";
    public static final String IMAGE_KEY = "image";

    private ImageView avatarImage;
    private EditText FullText;
    private EditText EmailText;
    private EditText PasswordText;
    private EditText ConfirmText;
    private EditText HomepageText;
    private EditText AboutText;

    private Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        avatarImage = findViewById(R.id.image_profile);
        FullText = findViewById(R.id.text_fullname);
        EmailText = findViewById(R.id.text_email);
        PasswordText = findViewById(R.id.text_password);
        ConfirmText = findViewById(R.id.text_confirm_password);
        HomepageText = findViewById(R.id.text_homepage);
        AboutText = findViewById(R.id.text_about);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    avatarImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void handleImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public void submitData(View view) {
        String fullName = FullText.getText().toString().trim();
        String email = EmailText.getText().toString().trim();
        String homepage = HomepageText.getText().toString();
        String password = PasswordText.getText().toString();
        String confPass = ConfirmText.getText().toString();
        String about = AboutText.getText().toString();


        //TODO : MUST BE ABLE TO SHOW ALL ERROR
        int countError = 5;
        Intent intent = new Intent(this, ProfileActivity.class);
        if(checkFullname(fullName)){
            intent.putExtra(FULL_KEY, fullName);
            countError--;
        }
        if(checkEmail(email)){
            intent.putExtra(EMAIL_KEY, email);
            countError--;
        }
        if(checkPassword(password, confPass)){
            countError--;
        }
        if(checkHomepage(homepage)){
            intent.putExtra(HOMEPAGE_KEY, homepage);
            countError--;
        }
        if(checkAbout(about)){
            intent.putExtra(ABOUT_KEY, about);
            countError--;
        }
        if(countError == 0){
            if(imageUri != null){
                intent.putExtra(IMAGE_KEY, imageUri.toString());
                try{
                    startActivity(intent);
                }catch(Exception ex){
                    intent.putExtra(IMAGE_KEY, "");
                    Toast.makeText(this, "Your image are too big", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }else{
                Toast.makeText(this, "Please add your image", Toast.LENGTH_SHORT).show();
                handleImage(view);
            }
        }
    }

    private boolean checkAbout(String about) {
        if(about.isEmpty()){
            AboutText.setError("About masih kosong");
            return false;
        }else{
            return true;
        }
    }

    private boolean checkPassword(String password, String confPass) {
        if(password.isEmpty() && confPass.isEmpty()){
            PasswordText.setError("Password masih kosong");
            ConfirmText.setError("Confirmation masih kosong");
            return false;
        } else if(password.isEmpty()){
            PasswordText.setError("Password masih kosong");
            return false;
        }else if(confPass.isEmpty()){
            ConfirmText.setError("Confirmation masih kosong");
            return false;
        }else if(password.equals(confPass)) {
            return true;
        }else{
            PasswordText.setError("Password doesn't match");
            ConfirmText.setError("Password doesn't match");
            return false;
        }
    }

    private boolean checkFullname(String fullname){
        if(fullname.isEmpty()){
            FullText.setError("Masukkan fullname Anda");
            return false;
        }else{
            return true;
        }
    }

    private boolean checkEmail(String email){
        if(email.isEmpty()){
            EmailText.setError("Masukkan Email Anda!");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            EmailText.setError("Cek Email Anda!");
            return false;
        }else{
            return true;
        }
    }

    private boolean checkHomepage(String homepage){
        if(homepage.isEmpty()){
            HomepageText.setError("Masukkan Homepage yang Anda inginkan!");
            return false;
        }else if(!Patterns.WEB_URL.matcher(homepage).matches()){
            HomepageText.setError("Cek homepage Anda!");
            return false;
        }else{
            return true;
        }
    }
}