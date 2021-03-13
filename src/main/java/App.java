import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        int port=Integer.parseInt(System.getenv("PORT"));
        port(port);

        get("/", (req, res) -> "Hello, World. For my computation please add /compute to your link");

        post("/compute", (req, res) -> {

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            sc1.close();
            System.out.println(inputList);


            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2= new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            sc2.close();
            int a0=inputList2.get(0);
            int a1=inputList2.get(1);
            int a2=inputList2.get(2);

           // boolean result = App.search(inputList, input2AsInt);
            int result=App.howManyNumbersOverAverage(inputList,a0,a1,a2);
            Map<String, String> map = new HashMap<String, String>();
            map.put("result","Mean is: "+(a0+a1+a2)/3 +" There are "+result+" numbers bigger than mean.");
            System.out.println(inputList2);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute",
                (rq, rs) -> {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("result", "Please enter your numbers left bar. Enter 3 numbers to right bar. It will compute mean of 3 numbers and prints" +
                            " how many number is bigger than mean");
                    return new ModelAndView(map, "compute.mustache");
                },new MustacheTemplateEngine());
    }
    public static Integer howManyNumbersOverAverage(ArrayList<Integer> list,int a1,int a2,int a3){
        int average=(a1+a2+a3)/3;
        int don=0;
        if(list==null)
            return null;
        for(int a:list){
            if(a>average)
                don++;
        }
        return don;
    }
}