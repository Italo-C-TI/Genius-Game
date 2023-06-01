package objects;
import java.rmi.server.ObjID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Utils {
    public static String generateStringID() {
        ObjID uid = new ObjID();
        return uid.toString();
}
    public static String formatData(Date date) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
    	return dateFormat.format(date);
    }
}
