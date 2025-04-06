import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;

import java.io.IOException;

/**
 * ExampleArduinoCode class.  Class to demonstrate Arduino interface.
 */
public class ExampleArduinoCode {

    /**
     * Main method, with some demonstration code related to the Arduino
     * @throws IOException in the case that board communications don't work.
     */
    public static void main(String[] args) throws IOException {

        String myPort = "/dev/cu.SLAB_USBtoUART"; // modify for your own computer & setup.
        IODevice myGroveBoard = new FirmataDevice(myPort); // using the name of a port

        // try to communicate with the board
        try {
            myGroveBoard.start(); // start communication with board;
            myGroveBoard.ensureInitializationIsDone();
            System.out.println("Board started."); //hopefully we make it here.
        } catch (Exception ex) { // if not, detail the error.
            System.out.println("couldn't connect to board.");
            return; //no point continuing at this point.
        }

        // assuming we have initialized the board ...
        Pin myLED = myGroveBoard.getPin(4);
        myLED.setMode(Pin.Mode.OUTPUT); // set pin 4 to be OUTPUT
        myLED.setValue(1); // turn pin on.

        // Pause for two seconds.
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            System.out.println("sleep error.");
        }

        myLED.setValue(0); // turn pin off.
        myGroveBoard.stop(); // stop the board.
        System.out.println("Board stopped.");

    }
}