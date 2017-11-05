package com.netcracker.infrastructure.repositories;

import com.netcracker.substance.Actor;

import java.util.ArrayList;

public class ActorRepositiryImpl implements ActorRepository {
    private ArrayList<Actor> actors=new ArrayList<Actor>();

    @Override
    public void save(Actor actor) {
        actors.add(actor);
        System.out.println("Save successfully = "+actor.getActor_id()+" "+actor.getFirstname()+" "+actor.getLastname()+" "+actor.getBirthdate());
    }

    @Override
    public ArrayList<Actor> load() {
        if (actors.size()==0) {
            System.out.println("Не один стиль не был введен");
            return null;
        }
        else {
            for(int index=0;index<actors.size();index++){
                System.out.println(actors.get(index).getActor_id()+" "+actors.get(index).getFirstname()+" "+actors.get(index).getLastname()+" "+actors.get(index).getBirthdate());
            }
            return actors;
        }

    }
}
