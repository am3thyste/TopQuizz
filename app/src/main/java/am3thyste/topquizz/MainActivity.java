package am3thyste.topquizz;

/**
 * Created by <Léa> on <java.util.Calendar.getInstance()>.
 */

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
        private TextView mGreetingText;
        private EditText mNameInput;
        private Button  mPlayButton;

       @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = findViewById(R.id.main_activity_greeting_txt);
        mNameInput=findViewById(R.id.main_activity_name_input);
        mPlayButton=findViewById(R.id.main_activity_play_btn);

        mPlayButton.setEnabled(false);
        mNameInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                        mPlayButton.setEnabled(s.toString().length()!=0);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        //user clicked LET'S PLAY button
                        Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(gameActivityIntent);
                }
        });


        }
        }
