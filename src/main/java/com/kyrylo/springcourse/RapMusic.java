package com.kyrylo.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RapMusic implements Music {

    private List<String> songs = new ArrayList<>();

    {
        songs.add("Return Of Da Livin' Dead - The D.O.C.");
        songs.add("New Jack Hustler (Nino's Theme) - Ice-T");
        songs.add("Comin' Thru Your Neighborhood - Rhyme Poetic Mafia");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
