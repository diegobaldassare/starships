package edu.austral.starship.controller;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.model.Model;
import edu.austral.starship.view.View;
import processing.core.PGraphics;

import java.util.Set;

/**
 * Created by Diego Baldassare on 2018-10-29.
 */
public abstract class Controller {

    public abstract void setup(ImageLoader imageLoader);
    public abstract void update(PGraphics graphics, float timeSinceLastDraw);
}
