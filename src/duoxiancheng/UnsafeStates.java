package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 *
 * 如果按照上述的方式来发布status，就会出现问题，因为任何调用者都能修改这个数组都内容。
 */
public class UnsafeStates {
    private String[] states = new String[]{
            "AK", "AL"
    };

    public String[] getStates() {
        return states;
    }
}
