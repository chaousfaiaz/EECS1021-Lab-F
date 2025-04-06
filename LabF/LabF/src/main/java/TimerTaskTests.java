import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Timer;

import static org.junit.jupiter.api.Assertions.*;

class TimerTaskTests {

    @Test
    void randomTest() throws InterruptedException {
        RandomTask b = new RandomTask(1000);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(b, 0, 100);
        Thread.sleep(200);
        t.cancel();
        System.out.println(b.getGrades());
        int As = Collections.frequency(b.getGrades(), "A");
        int Bs = Collections.frequency(b.getGrades(), "B");
        int Cs = Collections.frequency(b.getGrades(), "C");
        assertFalse(b.getGrades().isEmpty(), "ArrayList is empty!");
        assertEquals(As,Bs,100);
        assertEquals(As,Cs,100);
        assertEquals(Bs,Cs,100);
    }

    @Test
    void buttonConstructorTest() throws InterruptedException, IOException {
        String port = "/dev/cv.usbserial-0001"; // modify for your own computer & setup.
        ButtonTask b = new ButtonTask(port, 6,4);
        b.stopBoard();
        assertEquals("START", b.getState() );
    }

    @Test
    void buttonRunTest() throws InterruptedException, IOException {
        String port = "/dev/cv.usbserial-0001"; // modify for your own computer & setup.
        ButtonTask b = new ButtonTask(port, 6,4);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(b, 0, 100);
        Thread.sleep(200);
        t.cancel();
        b.stopBoard();
        String state = b.getState();
        assertNotNull(state, "State of button is NULL!");
        assertTrue(state.equals("ON")|state.equals("OFF"), "State should be ON or OFF!");
    }



}
