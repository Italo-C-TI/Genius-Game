package objects;


import java.util.Date;
import java.text.SimpleDateFormat;



public class Utils {
	private static Integer sequenceIdPlayer = 0;
	private static Integer championshipIdPlayer = 0;
	
    public static String generatePlayerID() {
        Integer id = sequenceIdPlayer++;
        return 	id.toString();
}
    public static String generateChampionshipID() {
        Integer id = championshipIdPlayer++;
        return 	id.toString();
}
    public static String formatData(Date date) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
    	return dateFormat.format(date);
    }
}
