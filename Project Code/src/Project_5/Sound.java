import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The Sound class is responsible for playing sound effects in the Brick Breaker game.
 */
public class Sound {
    private Clip clip;

    /**
     * Constructs a new Sound object with the specified sound file.
     *
     * @param soundFile the path to the sound file
     */
    public Sound(String soundFile) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Sound.class.getResource(soundFile));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Plays the sound.
     */
    public void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
}