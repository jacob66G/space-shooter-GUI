package com.example.spaceshootergui2.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    public static boolean musicEnabled = true;
    public static boolean soundsEnabled = true;
    private static Clip musicClip;


    public static void setMusicEnabled(boolean enabled) {
        musicEnabled = enabled;
        if (musicClip != null) {
            if (musicEnabled) {
                musicClip.loop(Clip.LOOP_CONTINUOUSLY);
                musicClip.start();
            } else {
                musicClip.stop();
            }
        }
    }

    public static void setSoundsEnabled(boolean enabled) {
        soundsEnabled = enabled;
    }

    public static void playSound(String soundFile) {
        if (!soundsEnabled) return;
        try {

            URL soundURL = SoundPlayer.class.getResource(soundFile);
            if (soundURL == null) {
                System.err.println("Sound file not found: " + soundFile);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playSoundLoop(String soundFile) {
        if (!musicEnabled) return;
        try {

            if (musicClip != null && musicClip.isRunning()) {
                musicClip.stop();
            }

            URL soundURL = SoundPlayer.class.getResource(soundFile);
            if (soundURL == null) {
                System.err.println("Sound file not found: " + soundFile);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            musicClip = AudioSystem.getClip();
            musicClip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = Math.max(gainControl.getMinimum(), Math.min(0, -10.0f));
            gainControl.setValue(dB);

            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}