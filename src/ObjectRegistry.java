import java.util.HashMap;
import java.util.Map;

public class ObjectRegistry {
    public static Map<String,Object> objects = new HashMap<>();

    public static void put(String name, Object obj){
        objects.put(name, obj);
    }

    public static Object get(String name){
        if (name.length() == 0){
            return null;
        }
        return objects.get(name);
    }
}
