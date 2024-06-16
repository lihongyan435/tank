package com.mashibing.tank;

import java.awt.*;

/**
 * 功能:
 * 作者：黄焖鸡
 * 日期：2024-06-13 21:06
 */
public class Bullet {
    private static final int SPEED = 10;
    private static int WIDTH = 30, HEIGHT = 30;
    private int x, y;
    private Dir dir;
    TankFrame tf = null;
    private boolean live = true;
    public Bullet(int x, int y, Dir dir, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if(x < 0 || y < 0 || x > TankFrame.GAME_HEIGHT || y > TankFrame.GAME_HEIGHT) live = false;

    }
}
