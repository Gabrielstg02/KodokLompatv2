package br.ol.frogger.entity;

import br.ol.frogger.FroggerEntity;
import br.ol.frogger.FroggerScene;
import static br.ol.frogger.FroggerScene.SceneState.*;


public class Initializer extends FroggerEntity {

    public Initializer(FroggerScene scene) {
        super(scene);
    }

    @Override
    public void init() {
        setCollidible(false);
        setVisible(true);
    }

    @Override
    public void updateInitializing() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    if (System.currentTimeMillis() - waitTime < 3000) {
                        break yield;
                    }
                    scene.changeState(OL_PRESENTS);
                    break yield;
            }
        }
    }

}
