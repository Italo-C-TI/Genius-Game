package utils;


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.sound.sampled.AudioSystem;

import javazoom.jl.player.Player;

import java.io.FileInputStream;
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
    
	public ArrayList<Integer> generateRandomPattern(Integer currentRound, Integer dificultyGame) {
		ArrayList<Integer> pattern = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < currentRound + dificultyGame; i++) {
			pattern.add(random.nextInt(4));
		}

		return pattern;
	}
	
	public boolean checkClickedColor(int clickedColor, ArrayList<Integer> pattern, int currentIndex) {
	    return clickedColor == pattern.get(currentIndex);
	}
	
    public void soundButton(String soundName) {
        new Thread(() -> {
    	try {			
			FileInputStream inputStream = new FileInputStream("sounds//" + soundName + ".mp3");
			Player soundButtonPlayer = new Player(inputStream);	
			soundButtonPlayer.play();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        }).start();
    }
    
    public void loadSounds() {
        try {
            AudioSystem.getAudioInputStream(new FileInputStream("sounds//yellow.mp3"));
            AudioSystem.getAudioInputStream(new FileInputStream("sounds//red.mp3"));
            AudioSystem.getAudioInputStream(new FileInputStream("sounds//blue.mp3"));
            AudioSystem.getAudioInputStream(new FileInputStream("sounds//green.mp3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}




 