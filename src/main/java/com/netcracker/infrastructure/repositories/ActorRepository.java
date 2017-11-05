package com.netcracker.infrastructure.repositories;



import com.netcracker.substance.Actor;

import java.util.ArrayList;

public interface ActorRepository {
    public void save(Actor actor);
    public ArrayList<Actor> load();
}
