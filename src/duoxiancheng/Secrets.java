package duoxiancheng;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 */
public class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}
class Secret {
}
