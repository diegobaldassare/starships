package edu.austral.starship.console.view;

import edu.austral.starship.model.Starship;

/**
 * Created by Diego Baldassare on 2018-12-03.
 */
public class StarshipConsoleView {

//    public static void setup(Starship starship) {
//
//    }

    public void draw(Starship starship) {
        System.out.println();
        System.out.println("starship.getColor() = " + starship.getColor());
        System.out.println("starship.getLife() = " + starship.getLife());
        System.out.println("starship.getPosition() = " + starship.getPosition());
    }
}
