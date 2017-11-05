package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.Style;

import java.util.ArrayList;

public class FilmRepositoryImpl implements StyleRepository {
    public Style style;

    @Override
    public void save(Style object) {
        style=object;
        System.out.print(style);
    }

    @Override
    public ArrayList<Style> load() {
        if (style==null)
            return null;
        else return null;
    }
}
