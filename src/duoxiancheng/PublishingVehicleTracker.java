package duoxiancheng;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 */
public class PublishingVehicleTracker {
    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        //locations是线程安全的；
        this.locations = new ConcurrentHashMap<String, SafePoint>(locations);

        //返回指定映射的不可修改视图，如果对map进行put，就会抛出异常；
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;//返回不可变map;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        locations.get(id).set(x, y);
    }
}
