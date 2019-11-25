package am3thyste.topquizz.model;

import java.util.List;

/**
 * Created by Léa on 25/11/2019.
 */
public class Question {
    public String mQuestion;
    public List<String> mChoice;
    private int mAnswerIndex;

    public Question(String question, List<String> choice, int answerIndex) {
        mQuestion = question;
        mChoice = choice;
        mAnswerIndex = answerIndex;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoice() {
        return mChoice;
    }

    public void setChoice(List<String> choice) {
        mChoice = choice;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        mAnswerIndex = answerIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mChoice=" + mChoice +
                ", mAnswerIndex=" + mAnswerIndex +
                '}';
    }
}
