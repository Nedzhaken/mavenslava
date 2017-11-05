package com.netcracker.infrastructure.repositories;


import com.netcracker.substance.Style;

import java.util.ArrayList;

public interface StyleRepository {

    public void save(Style style);
    public ArrayList<Style> load();
}
