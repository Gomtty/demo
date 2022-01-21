package com.myoi.exer;

/**
 * @author myoi
 * @date 2021/12/4 - 12:06
 */
public class TriAngle {
    private int height;
    private int width;

    public TriAngle() {}

    public TriAngle(int height, int width) {
        this.height=height;
        this.width=width;
    }

    public void setHeight(int height) {
        this.height=height;
    }

    public void setWidth(int width) {
        this.width=width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int cal() {
        return height*width/2;
    }
}
