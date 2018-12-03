package edu.austral.starship.model.visitor;

/**
 * Created by Diego Baldassare on 2018-11-06.
 */
public interface Visitable {

    void accept(Harmful visitor);
    void accept(Helpful visitor);
}
