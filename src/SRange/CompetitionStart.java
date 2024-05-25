package SRange;

import java.sql.Time;
import java.util.ArrayList;


public class CompetitionStart {
    static private ArrayList<CompetitionStart> listOfStarts = new ArrayList<CompetitionStart>();

    Time time;
    Competitions competitions;
    Person person;

    CompetitionStart(    Time time,
            Competitions competitions,
            Person person){
        this.competitions = competitions;
        this.time = time;
        this.person = person;
        listOfStarts.add(this);
    }
}
