package br.ol.frogger.entity;


import br.ol.frogger.FroggerEntity;
import br.ol.frogger.FroggerScene;
import br.ol.frogger.FroggerScene.SceneState;
import static br.ol.frogger.FroggerScene.SceneState.*;
import br.ol.ge.core.Keyboard;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Title extends FroggerEntity {
    
    private final String textPushSpace = "TEKAN SPASI UNTUK MEMULAI";
    private final String textOriginalBy = "ORIGINAL GAME BY";
    private final String textCredit = "DIBUAT OLEH KELOMPOK BIAWAK";
    private boolean textPushSpaceVisible;

    public Title(FroggerScene scene) {
        super(scene);
    }

    @Override
    public void init() {
        setCollidible(false);
        loadImage("title.png");
    }
    
    @Override
    public void updateTitle() {
        textPushSpaceVisible = ((int) (System.nanoTime() * 0.000000005) % 3) < 2;
        if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
            scene.startGame();
        }
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        if (textPushSpaceVisible) {
            scene.drawText(g, textPushSpace, 13, 120, Color.WHITE);
        }
        scene.drawText(g, textCredit, 4, 184, Color.WHITE);
        scene.drawText(g, textOriginalBy, 44, 208, Color.WHITE);
    }
    
    @Override
    public void sceneStateChanged(SceneState newState) {
        setVisible(newState == TITLE);
    }
        
}
