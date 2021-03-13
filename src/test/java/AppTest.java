import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest {
    @Test void testFound(){
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(-1);
        a1.add(0);
        a1.add(-2);
        assertTrue(App.howManyNumbersOverAverage(a1,0,0,0)==0);

    }
    @Test void testFound2(){
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(500);
        a1.add(500);
        a1.add(500);
        a1.add(-500);
        a1.add(200);
        assertTrue(App.howManyNumbersOverAverage(a1,150,200,250)==3);

    }
    @Test void testFound3(){
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(0);
        a1.add(0);
        a1.add(0);
        for(int i=-100;i<=100;i++){
            for(int j=-100;j<=100;j++){
                for (int k=-100;k<=100;k++){
                    assertTrue(App.howManyNumbersOverAverage(a1,i,j,k)>=0);
                }
            }
        }
    }
    @Test void testNull(){
        ArrayList<Integer> a1=null;
        assertNull(App.howManyNumbersOverAverage(a1,0,0,0));

    }
    @Test void testNotFound(){
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(0);
        a1.add(0);
        a1.add(0);
        for(int i=-100;i<=100;i++){
            for(int j=-100;j<=100;j++){
                for (int k=-100;k<=100;k++){
                    assertFalse(App.howManyNumbersOverAverage(a1,i,j,k)>3);
                }
            }
        }
    }
}
