package suono;

import java.io.*;

import javax.sound.sampled.*;

public class Play {
	private File fp;
	private Clip clip;
	private AudioInputStream sound;
	public final double CONTINUO = 100.00;
	
	public Play(String song) {
		try {
			fp = new File(song);
			clip = AudioSystem.getClip();
			sound = AudioSystem.getAudioInputStream(fp);
			clip.open(sound);
		}
		catch(Exception e) {
			return;
		}
	}
	
	public void startSuono() {
		clip.start();
	}
	
	public void closeSuono() {
		clip.close();
	}
	
	public void setLoop(int time) {
		clip.loop(time);
	}
	
	public void setLoop(double CONTINUO) {
		if (CONTINUO == this.CONTINUO) {
			clip.loop(clip.LOOP_CONTINUOUSLY);
		}
		else {
			return;
		}
	}
	
	public FloatControl setVolume() {
		FloatControl controllo = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		return controllo;
	}

}
