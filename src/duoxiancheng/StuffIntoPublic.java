package duoxiancheng;

import javax.xml.ws.Holder;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 */
public class StuffIntoPublic {
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
