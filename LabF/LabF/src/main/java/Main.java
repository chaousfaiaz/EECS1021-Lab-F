import java.util.Timer;

/**
 * Main method, contains example code to connect with board
 */
public class Main {

    /**
     * Main method, to demonstrate interface with Arduion.
     * You will need to CUSTOMIZE THIS to include the name of
     * the port your board is connected to.
     * This code should run as in the video demo if all
     * is working correctly.
     *
     * @param args
     */
    public	static	void main(String[]	args) {

        String myPort = "/dev/cv.usbserial-0001"; // modify for your own computer & setup.

        //demonstrate the random task
        try {
            RandomTask r = new RandomTask(1000);
            Timer t = new Timer(true);
            t.scheduleAtFixedRate(r, 0, 1000);
            //run for 2 seconds
            Thread.sleep(2000);
            System.out.println(r.getGrades());
            t.cancel();
        } catch(Exception ex){
            System.out.println("sleep error.");
        }

        //start the arduino task
        try {
            ButtonTask b = new ButtonTask(myPort, 6,4);
            Timer t = new Timer(true);
            t.scheduleAtFixedRate(b, 0, 200);
            //run for 10 seconds
            Thread.sleep(10000);
            t.cancel();
            b.stopBoard();
        } catch(Exception ex){
            System.out.println("Board or sleep error.");
        }

    }


}
