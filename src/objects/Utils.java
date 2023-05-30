package objects;
import java.rmi.server.ObjID;

public class Utils {
    public static String generateStringID() {
        ObjID uid = new ObjID();
        return uid.toString();
}
}
