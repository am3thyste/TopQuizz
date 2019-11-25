package am3thyste.topquizz.model;

/**
 * Created by Léa on 25/11/2019.
 */

public class User {
    private String mFirstname;

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String firstname) {
        mFirstname = firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstname='" + mFirstname + '\'' +
                '}';
    }


}
