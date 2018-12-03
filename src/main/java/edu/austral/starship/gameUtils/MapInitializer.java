package edu.austral.starship.gameUtils;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.GameObject;
import edu.austral.starship.model.Player;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.view.AsteroidView;

import java.util.List;

/**
 * Created by Diego Baldassare on 2018-11-01.
 */
public class MapInitializer {

    //Hardcoded values
    private static final int MAP_WIDTH = 1680;
    private static final int MAP_HEIGHT= 1050;

    public static void checkBoundaries(List<GameObject> gameObjects) {
        for (GameObject o : gameObjects) {
            if (o instanceof Bullet) return;
            if (o.getPosition().getX() > MAP_WIDTH) o.setPosition(Vector2.vector(0, o.getPosition().getY()));
            if (o.getPosition().getY() > MAP_HEIGHT) o.setPosition(Vector2.vector(o.getPosition().getX(), 0));
            if (o.getPosition().getX() < 0) o.setPosition(Vector2.vector(MAP_WIDTH, o.getPosition().getY()));
            if (o.getPosition().getY() < 0) o.setPosition(Vector2.vector(o.getPosition().getX(), MAP_HEIGHT));
        }
    }

    /**
     * Generates n asteroids that appear from the border of the screen randomly but evenly spread.
//     * @param quantity must be multiple of 4.
     */
//    public static List<Asteroid> spawnAsteroids(List<Asteroid> existingAsteroids, int quantity)  {
//        for (int i = 0; i < quantity/4; i++) {
//            //sale de abajo para arriba
//            existingAsteroids.add(new Asteroid(5, Vector2.vector((float) Math.random() * MAP_WIDTH, MAP_HEIGHT + AsteroidView.HEIGHT + 1), Vector2.vector(0, -1).rotate((float) Math.random())));
//
//            //sale de arriba para abajo
//            existingAsteroids.add(new Asteroid(5, Vector2.vector((float) Math.random() * MAP_WIDTH,  - AsteroidView.HEIGHT - 1), Vector2.vector(0, 1).rotate((float) Math.random())));
//
//            //sale de izquierda a derecha
//            existingAsteroids.add(new Asteroid(5, Vector2.vector(- AsteroidView.WIDTH - 1, (float) Math.random() * MAP_HEIGHT), Vector2.vector(1, 0).rotate((float) Math.random())));
//
//            existingAsteroids.add(new Asteroid(5, Vector2.vector(MAP_WIDTH + AsteroidView.WIDTH + 1, (float) Math.random() * MAP_HEIGHT), Vector2.vector(-1, 0).rotate((float) Math.random())));
//        }
//        return existingAsteroids;
//    }

    public static void setInitialPositions(List<Player> players) {
        final int n = players.size();
        final int y = MAP_HEIGHT / 2;
        int x = 0;
        for (Player p : players) {
            x += MAP_WIDTH / (n + 1);
            p.getManageableObject().setPosition(Vector2.vector(x, y));
        }
//        players.get(0).getManageableObject().setPosition(Vector2.vector(1200, 500));
//        players.get(1).getManageableObject().setPosition(Vector2.vector(500, 500));
    }

    private static Vector2 calculatePosition(int i) {
        final int x = (int) Math.pow(10, i);
        final int y = 50;
        return Vector2.vector(x, y);
    }

    private static int[][] calculateMatrix(int n) {
        final int scale = (int) Math.sqrt(n) + 1;
        final int m = scale - 1;
        final int[][] result = new int[m][m];

        if ((Math.sqrt(n) - m) > 0) {
            throw new IllegalArgumentException("sqrt(n) should be an integer");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = i * j * MAP_WIDTH * MAP_HEIGHT;
            }
        }
        return result;
    }
}
