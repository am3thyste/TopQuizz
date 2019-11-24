package am3thyste.topquizz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mButtonActivity1, mButtonActivity2, mButtonActivity3, mButtonActivity4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTextView=findViewById(R.id.game_activity_question_text);
        mButtonActivity1=findViewById(R.id.game_activity_activity1_btn);
        mButtonActivity2=findViewById(R.id.game_activity_activity2_btn);
        mButtonActivity3=findViewById(R.id.game_activity_activity3_btn);
        mButtonActivity4=findViewById(R.id.game_activity_activity4_btn);

    }
}
