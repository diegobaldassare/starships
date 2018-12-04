package edu.austral.starship.model;

import edu.austral.starship.model.strategy.LevelThree;
import edu.austral.starship.utils.MapInitializer;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.model.repository.BulletsRepository;
import edu.austral.starship.model.strategy.Level;
import edu.austral.starship.model.strategy.LevelOne;

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
    private final List<GameObject> gameObjects = new ArrayList<>();
    private final List<Asteroid> asteroids = new ArrayList<>();
    private final List<Asteroid> newAsteroids = new ArrayList<>();
    private final List<Bullet> newBullets = new ArrayList<>();
    private static Game instance = null;

    public Game() {
        this.instance = this;
        this.paused = false;
        this.level = new LevelOne(this);
        asteroids.addAll(newAsteroids);
        newAsteroids.clear();
    }

    public static Game getInstance() {
        return instance;
    }

    @Override
    public void setup() {
        MapInitializer.setInitialPositions(players);
        for (Player player : players) {
            gameObjects.add(player.getManageableObject());
        }
        gameObjects.addAll(asteroids);

    }

    @Override
    public void update(float timeSinceLastDraw) {
        if (paused) return;
        if (asteroids.isEmpty()) {
            level.next();
            asteroids.addAll(newAsteroids);
            gameObjects.addAll(newAsteroids);
        }
//        if (starships.isEmpty()) end();

        newBullets.addAll(BulletsRepository.getInstance().read());
        gameObjects.addAll(newBullets);

        gameObjects.removeIf(o -> o.getLife() <= 0);
        asteroids.removeIf(o -> o.getLife() <= 0);
        for (GameObject o : gameObjects) {
            o.update(timeSinceLastDraw);
        }

        MapInitializer.checkBoundaries(gameObjects);
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

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public List<Starship> getStarships() {
        final List<Starship> result = new ArrayList<>();
        for (Player p : players) {
            result.add((Starship) p.getManageableObject());
        }
        return result;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public List<Asteroid> getNewAsteroids() {
        return newAsteroids;
    }

    public List<Bullet> getNewBullets() {
        return newBullets;
    }
}
