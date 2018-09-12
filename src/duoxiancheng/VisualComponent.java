package duoxiancheng;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 */
public class VisualComponent {

    private final List<KeyListener> keyListeners
            = new CopyOnWriteArrayList<KeyListener>();
            //用于管理监听器列表，每个链表都是线程安全的;
            //CopyOnWriteArrayList是线程安全的list;

    private final List<MouseListener> mouseListeners
            = new CopyOnWriteArrayList<MouseListener>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }
}
