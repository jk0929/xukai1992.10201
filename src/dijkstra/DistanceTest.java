package dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2018/4/9.
 * 测试Dijkstra算法结果
 */
public class DistanceTest {
    public static void main(String[] args) {
        Map<Integer, Map<Integer,Integer>> stepLength = new HashMap<>();
        Map<Integer,Integer> step1 = new HashMap<>();
        stepLength.put(1, step1);
        step1.put(6, 14);
        step1.put(3, 9);
        step1.put(2, 7);

        Map<Integer,Integer> step2 = new HashMap<>();
        stepLength.put(2, step2);
        step2.put(1, 7);
        step2.put(3, 10);
        step2.put(4, 15);

        Map<Integer,Integer> step3 = new HashMap<>();
        stepLength.put(3, step3);
        step3.put(1, 9);
        step3.put(2, 10);
        step3.put(4, 11);
        step3.put(6, 2);

        Map<Integer,Integer> step4 = new HashMap<>();
        stepLength.put(4, step4);
        step4.put(2, 15);
        step4.put(5, 5);
        step4.put(3, 11);

        Map<Integer,Integer> step5 = new HashMap<>();
        stepLength.put(5, step5);
        step5.put(6, 9);
        step5.put(4, 5);

        Map<Integer,Integer> step6 = new HashMap<>();
        stepLength.put(6, step6);
        step6.put(1, 14);
        step6.put(5, 9);
        step6.put(3, 2);

        Distance distance = new DistanceDijkstraImpl();
        MinStep step = distance.getMinStep(1, 5, stepLength);
        System.out.println(step);
        List<Integer> stepList = step.getStep();
        Integer[] array = new Integer[stepList.size()];
        stepList.toArray(array);
        for (int i=array.length-1;i>=0;i--){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
