package com.kyrylo.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private final ClassicalMusic classicalMusic;
    private final RockMusic rockMusic;
    private final RapMusic rapMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic, RapMusic rapMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.rapMusic = rapMusic;
    }

    public void playMusic(MusicGenre genre) {
        Random random = new Random();

        int randomNumber = random.nextInt(3);

        switch (genre) {
            case ROCK:
                System.out.println(genre.name() + " playlist: " + rockMusic.getSongs().get(randomNumber));
                break;
            case CLASSICAL:
                System.out.println(genre.name() + " playlist: " + classicalMusic.getSongs().get(randomNumber));
                break;
            case RAP:
                System.out.println(genre.name() + " playlist: " + rapMusic.getSongs().get(randomNumber));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + genre);
        }
    }
}
