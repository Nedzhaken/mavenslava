package com.netcracker.infrastructure.services;

import com.netcracker.entity.Film;
import com.netcracker.infrastructure.repositories.FilmRepositoryImpl;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ProxyFilmList implements List<Film> {

    List<Film> filmList = null;
    FilmRepositoryImpl repository;

    public ProxyFilmList(FilmRepositoryImpl repository) {
        this.repository = repository;
    }

    private void initList() {
        if (filmList == null) {
            filmList = repository.loadAll();
        }
    }

    @Override
    public int size() {
        initList();
        return filmList.size();
    }

    @Override
    public boolean isEmpty() {
        initList();
        return filmList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return filmList.contains(o);
    }

    @Override
    public Iterator<Film> iterator() {
        return filmList.iterator();
    }

    @Override
    public Object[] toArray() {
        return filmList.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return filmList.toArray(a);
    }

    public boolean add(Film film) {
        return filmList.add(film);
    }

    @Override
    public boolean remove(Object o) {
        return filmList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return filmList.containsAll(c);
    }

    public boolean addAll(Collection<? extends Film> c) {
        return filmList.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Film> c) {
        return filmList.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return filmList.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return filmList.retainAll(c);
    }

    public void replaceAll(UnaryOperator<Film> operator) {
        filmList.replaceAll(operator);
    }

    public void sort(Comparator<? super Film> c) {
        filmList.sort(c);
    }

    @Override
    public void clear() {
        filmList.clear();
    }

    @Override
    public boolean equals(Object o) {
        return filmList.equals(o);
    }

    @Override
    public int hashCode() {
        return filmList.hashCode();
    }

    @Override
    public Film get(int index) {
        initList();
        return filmList.get(index);
    }

    public Film set(int index, Film element) {
        return filmList.set(index, element);
    }

    public void add(int index, Film element) {
        filmList.add(index, element);
    }

    @Override
    public Film remove(int index) {
        return filmList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return filmList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return filmList.lastIndexOf(o);
    }

    @Override
    public ListIterator<Film> listIterator() {
        return filmList.listIterator();
    }

    @Override
    public ListIterator<Film> listIterator(int index) {
        return filmList.listIterator(index);
    }

    @Override
    public List<Film> subList(int fromIndex, int toIndex) {
        return filmList.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<Film> spliterator() {
        return filmList.spliterator();
    }

    public boolean removeIf(Predicate<? super Film> filter) {
        return filmList.removeIf(filter);
    }

    @Override
    public Stream<Film> stream() {
        return filmList.stream();
    }

    @Override
    public Stream<Film> parallelStream() {
        return filmList.parallelStream();
    }

    public void forEach(Consumer<? super Film> action) {
        filmList.forEach(action);
    }

}
