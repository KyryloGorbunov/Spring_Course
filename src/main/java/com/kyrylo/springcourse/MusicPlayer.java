package com.kyrylo.springcourse;

import com.kyrylo.springcourse.genres.ClassicalMusic;
import com.kyrylo.springcourse.genres.MusicGenre;
import com.kyrylo.springcourse.genres.RapMusic;
import com.kyrylo.springcourse.genres.RockMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    private final ClassicalMusic classicalMusic;
    private final RockMusic rockMusic;
    private final RapMusic rapMusic;

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic, RapMusic rapMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.rapMusic = rapMusic;
    }

    public List<Music> musicList() {
        return Arrays.asList(classicalMusic, rapMusic, rapMusic);
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
