package org.anr.model;

import org.anr.model.Main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Music {

    private String track; // адресс файла
    private Clip m = null;
    // Иннициализация логера
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    // конструктор
    public Music(String track) {
        this.track = track;
    }

    public void sound() {

        File dirT = new File(this.track);
        InputStream inputStream = getClass().getResourceAsStream(this.track);

        try {
            inputStream = AudioSystem.getAudioInputStream(dirT);
            logger.info("Звук клавиши.");
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        try {
            m = AudioSystem.getClip();
            m.open((AudioInputStream) inputStream);
            m.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP)
                {
                    event.getLine().close();
                }
            });
            m.setFramePosition(0);
            m.start();
            inputStream.close();
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}