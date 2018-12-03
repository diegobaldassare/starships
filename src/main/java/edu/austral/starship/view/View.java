package edu.austral.starship.view;

import edu.austral.starship.base.framework.ImageLoader;
import processing.core.PGraphics;

/**
 * Created by Diego Baldassare on 2018-10-29.
 */
public abstract class View {

    public abstract void setup(ImageLoader imageLoader);
    public abstract void draw(PGraphics graphics);
}
