package com.example.mytp1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private Button languageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        submitButton = findViewById(R.id.submitButton);
        languageButton = findViewById(R.id.languageButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }

        });


        languageButton.setOnClickListener(new View.OnClickListener() { // Set OnClickListener for language button
            @Override
            public void onClick(View view) {
                showLanguageSelector();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    private void showLanguageSelector() {
        // Create a list of languages to show in the dialog
        final String[] languages = {"English", "Français"};

        // Create a list of locale codes corresponding to the languages
        final String[] localeCodes = {"en", "fr"};

        // Create a dialog with the language options
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a language");
        builder.setItems(languages, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Set the app's locale to the selected language
                Locale locale = new Locale(localeCodes[i]);
                Resources res = getResources();
                Configuration config = new Configuration(res.getConfiguration());
                config.setLocale(locale);
                res.updateConfiguration(config, res.getDisplayMetrics());

                // Restart the activity for the changes to take effect
                recreate();

                // Update the text elements with the new language
                usernameEditText.setText(R.string.usernameEditText);
                passwordEditText.setText(R.string.passwordEditText);
                submitButton.setText(R.string.submitButton);
                languageButton.setText(R.string.languageButton);
            }
        });
        builder.show();
    }
}
