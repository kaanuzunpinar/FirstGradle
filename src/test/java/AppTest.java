import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest {
    @Test void testFound(){
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(3);
        a1.add(4);
        a1.add(5);
        assertTrue(App.search(a1,3));
    }
}
