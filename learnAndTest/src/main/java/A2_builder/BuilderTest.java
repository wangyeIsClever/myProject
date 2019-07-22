package A2_builder;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BuilderTest {

    public static void main(String[] args) {
       /* CarBuilder carBuilder = new CarBuilderImpl();
        Car car = carBuilder.buildCar();*/


        String s1 = "lalal";
        String s2 = "lalal";
        List<String> list = new ArrayList<String>(40000000);

        for(long i = 1000000000000000000L;i < (1000000000000000000L+40000000L); i++ ){
            String str = String.valueOf(i);

            list.add(new String(str.getBytes(StandardCharsets.UTF_8)));
            if((i - 40000000L)%10000000L == 0){
                System.out.println(new String(str.getBytes(StandardCharsets.UTF_8)));
            }

        }
        System.out.println(list.size());
        System.out.println(s1 == s2);
    }
}
