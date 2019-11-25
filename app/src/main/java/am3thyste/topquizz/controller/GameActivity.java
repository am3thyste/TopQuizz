package am3thyste.topquizz.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

import am3thyste.topquizz.R;
import am3thyste.topquizz.model.Question;
import am3thyste.topquizz.model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mQuestionTextView;
    private Button mButtonAnswer1, mButtonAnswer2, mButtonAnswer3, mButtonAnswer4;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionTextView = findViewById(R.id.game_activity_question_text);
        mButtonAnswer1 = findViewById(R.id.game_activity_activity1_btn);
        mButtonAnswer2 = findViewById(R.id.game_activity_activity2_btn);
        mButtonAnswer3 = findViewById(R.id.game_activity_activity3_btn);
        mButtonAnswer4 = findViewById(R.id.game_activity_activity4_btn);

        //use the tag property, to name the buttons:
        mButtonAnswer1.setTag(0);
        mButtonAnswer1.setTag(1);
        mButtonAnswer1.setTag(2);
        mButtonAnswer1.setTag(3);

        mButtonAnswer1.setOnClickListener(this);
        mButtonAnswer2.setOnClickListener(this);
        mButtonAnswer3.setOnClickListener(this);
        mButtonAnswer4.setOnClickListener(this);


        mQuestionBank=this.generateQuestions();
        mCurrentQuestion=mQuestionBank.getQuestion();

    }

    private void displayQuestion(final Question question){
        mQuestionTextView.setText(question.getQuestion());
        mButtonAnswer1.setText(question.getChoice().get(0));
        mButtonAnswer2.setText(question.getChoice().get(1));
        mButtonAnswer3.setText(question.getChoice().get(2));
        mButtonAnswer4.setText(question.getChoice().get(3));
    }

    @Override
    public void onClick(View view) {
        int responseIndex = (int) view.getTag();

        //test if the answer is the correct one, or not:
        if(responseIndex == mCurrentQuestion.getAnswerIndex()){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
        }
    }

    private QuestionBank generateQuestions () {
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3));
    }
}