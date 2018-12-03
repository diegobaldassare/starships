package edu.austral.starship.model;

/**
 * Created by Diego Baldassare on 2018-11-14.
 */
public interface Criteria<T> {

    boolean apply(T t);
}
