package duoxiancheng;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 */
public class ThreeStooges {

    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

    public String getStoogeNames() {
        List<String> stooges = new Vector<>();
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
        return stooges.toString();
    }
}
