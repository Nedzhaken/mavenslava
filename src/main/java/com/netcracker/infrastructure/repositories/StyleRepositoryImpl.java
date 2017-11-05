package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.Style;

import java.util.ArrayList;

public class StyleRepositoryImpl implements StyleRepository {
    private ArrayList<Style> styles=new ArrayList<Style>();

    @Override
    public void save(Style style) {
        styles.add(style);
        System.out.println("Save successfully="+style.getName());
    }

    @Override
    public ArrayList<Style> load() {
        if (styles.size()==0) {
            System.out.println("Не один стиль не был введен");
           return null;
        }
       else {
            for(int i=0;i<styles.size();i++){
                System.out.println("Name style = "+ styles.get(i).getName()+" Style id = "+styles.get(i).getStyleid());
            }
            return styles;
        }

    }
}
