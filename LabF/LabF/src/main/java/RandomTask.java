import java.util.ArrayList; // ArrayLists
import java.util.TimerTask; // Timer tasks.

/**
 * RandomTask class, a task that is to be run by a timer.
 */
public class RandomTask extends TimerTask {
    private ArrayList<String> grades; //to store grades

    /**
     * RandomTask constructor.  This should initialize
     * the attribute grades to be an ArrayList<String>
     * with the dimension 'size'.  Initialize every
     * element in the ArrayList to hold the value "A".
     * You will need to use a for loop to initialize
     * all the values.
     *
     * @param size
     */
    RandomTask(int size) {
        throw new UnsupportedOperationException();//REPLACE THIS
    }

    /**
     * Getter for the grades attribute
     *
     * @return an ArrayList of grades
     */
    public ArrayList<String> getGrades() {
        return this.grades;
    }

    /**
     * The run method.
     * This method should loop through every value in
     * grades and generate a random number
     * at each iteration. It should then modify each
     * of the values in grades such that:
     * There is a 1/6 chance that the value assigned is an A.
     * There is a 1/6 chance that the value assigned is an B.
     * There is a 1/6 chance that the value assigned is an C.
     * There is a 1/6 chance that the value assigned is an D.
     * There is a 1/6 chance that the value assigned is an E.
     * There is a 1/6 chance that the value assigned is an F.
     *
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException();//REPLACE THIS
    }
}