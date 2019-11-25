package am3thyste.topquizz.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Léa on 25/11/2019.
 */
public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

        //Shuffle (mélanger) the question list:
        Collections.shuffle(mQuestionList);

        mNextQuestionIndex = 0;
    }

    public Question getQuestion(){
        //ensure we loop over the questions
        //if we arrived at the end of the list, we force the index to be 0, so that we show questions from beginning
        if (mNextQuestionIndex ==mQuestionList.size()){
            mNextQuestionIndex=0;
        }

        //please note the post-incrementation
        return mQuestionList.get(mNextQuestionIndex++);
    }

}
