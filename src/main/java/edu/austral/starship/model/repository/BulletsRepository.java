package edu.austral.starship.model.repository;

import edu.austral.starship.controller.ShooterController;
import edu.austral.starship.model.builder.bullets.Bullet;

/**
 * Created by Diego Baldassare on 2018-11-15.
 */
public class BulletsRepository extends Repository<Long, Bullet> {

    /**
     * Está bien aplicado el singleton pattern?
     *
     * - Cómo "obligo" a las subclases de Repository
     * para que no tengan mas de una instancia?
     * Porque si hago privado el constructor de repository,
     * no puedo tener sublases.
     */
    private static final Repository<Long, Bullet> INSTANCE = new BulletsRepository();
    private ShooterController shooterController;

    private BulletsRepository() {}

//    private static class SingletonHolder {
//        private static final BulletsRepository INSTANCE = new BulletsRepository();
//    }
//
//    public static BulletsRepository getInstance() {
//        return SingletonHolder.INSTANCE;
//    }

    private static volatile BulletsRepository instance;

    public static BulletsRepository getInstance() {
        if (instance == null) {
            synchronized (BulletsRepository.class) {
                if (instance == null) {
                    instance = new BulletsRepository();
                }
            }
        }
        return instance;
    }


    public void create(Bullet entity) {
        shooterController.createBullet(entity);
    }

    public void addObserver(ShooterController shooterController) {
        this.shooterController = shooterController;
    }

//    public static Repository<Long, Bullet> getInstance() {
//        return INSTANCE;
//    }
}
