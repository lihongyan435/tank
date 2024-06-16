package com.mashibing.tank;

/**
 * 功能:
 * 作者：黄焖鸡
 * 日期：2024-06-13 16:14
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        // 初始化敌方坦克
        for(int i = 0; i < 5; i++){
            tf.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, tf));
        }
        while(true){
            Thread.sleep(50);
            tf.repaint(); // repaint首先会调用update，再调用paint
        }
    }
}
