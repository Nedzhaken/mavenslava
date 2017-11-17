package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.Style;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> {

    protected Class<? extends T> repositoryType;

    private SessionFactory sessionFactory;

    private List<T> list=new ArrayList<T>();

    public GenericRepository() {
    }

    public GenericRepository(Class<? extends T> repositoryType, SessionFactory sessionFactory) {
        this.repositoryType = repositoryType;
        this.sessionFactory = sessionFactory;
    }

    public void save(T object) {
        list.add(object);
        System.out.println("Save successfully = "+object);
    }

    public List<T> load() {
        if (list.size()==0) {
            System.out.println("Не один стиль не был введен");
            return null;
        }
        else {
            for(int i=0;i<list.size();i++){
                System.out.println("Load successfully = "+ list.get(i));
            }
            return list;
        }

    }
}
