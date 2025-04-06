import org.firmata4j.IODevice;
import org.firmata4j.Pin; // Firmata
import org.firmata4j.firmata.FirmataDevice;

import java.io.IOException;
import java.util.TimerTask; // Timer tasks.

/**
 * Button task class, a task that is to be run by a timer.
 */
public class ButtonTask extends TimerTask {

    private IODevice myGroveBoard; //will contain reference to board
    private Pin outputPin; //output pin
    private Pin inputPin; //input pin
    private String state; //string representation of output pin state

    /**
     * ButtonTask constructor.  Initializes input and output
     * pin directly.
     *
     * @param port   the name of the port
     * @param input  a PIN that references the input pin
     * @param output a PIN that references the output pin
     */
    ButtonTask(String port, Pin input, Pin output) {
        myGroveBoard = new FirmataDevice(port);

        // try to communicate with the board
        try {
            myGroveBoard.start(); // start communication with board;
            myGroveBoard.ensureInitializationIsDone();
            System.out.println("Board started."); //hopefully we make it here.
        } catch (Exception ex) { // if not, detail the error.
            System.out.println("couldn't connect to board.");
            return; //no point continuing at this point.
        }

        this.inputPin = input;
        this.outputPin = output;
        this.state = "START";
    }

    /**
     * Overloaded ButtonTask constructor.  Initializes input and output
     * pin via integer input.
     * Initialize the state attribute to "START".
     *
     * @param port      the name of the port
     * @param inputPin  an integer indicating the ID of the input pin
     * @param outputPin an integer indicating the ID of the input pin
     */
    ButtonTask(String port, int inputPin, int outputPin) throws IOException {
        throw new UnsupportedOperationException();//REPLACE THIS
    }

    /**
     * Stop the Arduino board
     *
     * @throws IOException if no board can be accessed
     */
    public void stopBoard() throws IOException {
        myGroveBoard.stop(); // stop the board.
        System.out.println("Board stopped.");
    }

    /**
     * Getter for the state of the output pin
     *
     * @return a string that represents the state of the output pin.
     */
    public String getState() {
        return state;
    }

    /**
     * The run method for the ButtonTask.  When run the task should:
     * 1. Get the value of the INPUT PIN.  Use the
     * PIN method getValue for this purpose.
     * 2. Set the value of the OUT PIN to the SAME value
     * as the INPUT PIN.  Use the
     * PIN method setValue for this purpose.
     * 3. Write the state of the OUTPUT pin to the STATE attribute.
     * If the output pin is ON (i.e. if its value is one) the state
     * should be "ON".  If the output pin is OFF the state should be
     * "OFF"
     * Note you will need to surround read and write
     * statements to the pins with TRY and CATCH clauses.
     * DO NOT MODIFY THE FUNCTION SIGNATURE for this method.
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException();//REPLACE THIS
    }
}