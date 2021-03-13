import java.util.ArrayList;
public class App {
    public static void main(String[] args) {

    }
    public static boolean search(ArrayList<Integer> list,int a){
        if(list==null)
            return false;
        for(int temp:list)
            if(temp==a) {
                return true;
            }
        return false;
    }
}
