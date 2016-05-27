package Main.other;

import java.util.HashMap;
import java.util.Map;

public class SafePatchyContainer {
    private Map<Class<?>, Object> map = new HashMap<>();
    public <T> void put(Class<T> type, T instance){
        if (type == null) throw new NullPointerException("Type is null");
        map.put(type, type.cast(instance));
    }
    public <T> T get(Class<T> type){
        return type.cast(map.get(type));
    }
}
