package edu.austral.starship.model;

import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.utils.Map;
import edu.austral.starship.model.state.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a single match.
 *
 * Created by Diego Baldassare on 25/10/2018.
 */
public class Game extends Model {

    private boolean ended;
    private boolean paused;
    private Level level;
    private final List<Player> players = new ArrayList<>();
//    private final List<GameObject> gameObjects = new ArrayList<>();
    private final List<Starship> starships = new ArrayList<>();
    private final List<Asteroid> asteroids = new ArrayList<>();
    private final List<Bullet> bullets = new ArrayList<>();

    @Override
    public void setup() {
        Map.setInitialPositions(players);

        for (Player player : players) {
            starships.add((Starship) player.getManageableObject());    // cambiar
        }
    }

    @Override
    public void update(float timeSinceLastDraw) {
        if (paused) return;
        if (asteroids.isEmpty()) level.next();
        if (starships.isEmpty()) end();

        // Remove reference from dead entities.
        // Garbage Collector will be in charge of deleting it.
        starships.removeIf(o -> o.getLife() <= 0);
        asteroids.removeIf(o -> o.getLife() <= 0);
        bullets.removeIf(o -> o.getLife() <= 0);

        final List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(starships);
        gameObjects.addAll(asteroids);
        gameObjects.addAll(bullets);

        gameObjects.forEach(o -> o.update(timeSinceLastDraw));
        Map.checkBoundaries(gameObjects);
    }

    public boolean isEnded() {
        return ended;
    }

    public void end() {
        ended = true;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused() {
        this.paused = !paused;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Player> getPlayers() {
        return players;
    }

//    public List<GameObject> getGameObjects() {
//        return gameObjects;
//    }


    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public List<Starship> getStarships() {
        return starships;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }
}
