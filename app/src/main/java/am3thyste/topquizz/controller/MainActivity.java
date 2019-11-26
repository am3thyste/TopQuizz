package am3thyste.topquizz.controller;

/**
 * Created by <Léa> on <java.util.Calendar.getInstance()>.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import am3thyste.topquizz.R;
import am3thyste.topquizz.model.User;


public class MainActivity extends AppCompatActivity {
        private TextView mGreetingText;
        private EditText mNameInput;
        private Button mPlayButton;
        private User mUser;
        public static final int GAME_ACTIVITY_REQUEST_CODE = 0;
        private SharedPreferences mPreferences;
        public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
        public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
                        //fetch the score from the Intent
                        int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
                        mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

                        greetUser();

                }
        }

        private void greetUser() {
                String firstname = mPreferences.getString(PREF_KEY_FIRSTNAME, null);

                if (null != firstname) {
                        int score = mPreferences.getInt(PREF_KEY_SCORE, 0);

                        String fulltext = "Welcome back, " + firstname
                                + "!\nYour last score was " + score
                                + ", will you do better this time?";
                        mGreetingText.setText(fulltext);
                        mNameInput.setText(firstname);
                        mNameInput.setSelection(firstname.length());
                        mPlayButton.setEnabled(true);
                }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                System.out.println("MainActivity::onCreate()");

                mGreetingText = findViewById(R.id.main_activity_greeting_txt);
                mNameInput = findViewById(R.id.main_activity_name_input);
                mPlayButton = findViewById(R.id.main_activity_play_btn);

                mUser = new User();

                mPreferences = getPreferences(MODE_PRIVATE);

                mPlayButton.setEnabled(false);
                mNameInput.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                                mPlayButton.setEnabled(s.toString().length() != 0);
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                });

                mPlayButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                String firstname = mNameInput.getText().toString();
                                mUser.setFirstname(firstname);
                                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstname()).apply();
                                //user clicked LET'S PLAY button

                                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
                        }
                });


        }

        @Override
        protected void onStart() {
                super.onStart();
                System.out.println("MainActivity::onStart()");
        }

        @Override
        protected void onResume() {
                super.onResume();
                System.out.println("MainActivity::onResume()");

        }

        @Override
        protected void onStop() {
                super.onStop();
                System.out.println("MainActivity::onStop()");

        }

        @Override
        protected void onPause() {
                super.onPause();
                System.out.println("MainActivity::onPause()");

        }

        @Override
        protected void onDestroy() {
                super.onDestroy();
                System.out.println("MainActivity::onDestroy()");

        }
}

