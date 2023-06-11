package objects;


import java.util.Date;
import javax.sound.midi.Soundbank;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

import java.io.InputStream;
import java.net.URL;
import java.security.PublicKey;
import java.text.SimpleDateFormat;



public class Utils {
	private static Integer sequenceIdPlayer = 0;
	private static Integer championshipIdPlayer = 0;
  	InputStream soundRed = Utils.class.getResourceAsStream("/sounds/red.mp3");
	
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
    
//    public static String soundRedButton() {
//    	ply = new Player(id, name, nickname)
//    			
//    	
//    	return dateFormat.format(date);
//    }
//   
}



 