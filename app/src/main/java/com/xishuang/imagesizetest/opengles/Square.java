package com.xishuang.imagesizetest.opengles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Author:xishuang
 * Date:2018/1/2
 * Des:四边形
 */
public class Square {
    /**
     * 每个顶点的维度数量
     */
    static final int COORDS_PER_VERTEX = 3;

    /**
     * 顶点坐标，逆时针，z方向都为0
     */
    static float[] squreCoords = {
            -0.5f, 0.5f, 0.0f,   // top left
            -0.5f, -0.5f, 0.0f,   // bottom left
            0.5f, -0.5f, 0.0f,   // bottom right
            0.5f, 0.5f, 0.0f  // top right
    };
    private final FloatBuffer vertexBuffer;
    private final ShortBuffer drawOrderBuffer;

    private short drawOrder[] = {0, 1, 2, 0, 2, 3}; // 顶点的绘制顺序

    public Square() {
        //1、初始化顶点坐标的字节流
        ByteBuffer bb = ByteBuffer.allocateDirect(
                // float有4个字节
                squreCoords.length * 4);
        //使用与设备相关的字节序
        bb.order(ByteOrder.nativeOrder());
        //创建字节流
        vertexBuffer = bb.asFloatBuffer();
        //顶点坐标数据添加进字节流中
        vertexBuffer.put(squreCoords);
        //设置开始读取位置
        vertexBuffer.position(0);

        //2、初始化顶点绘制顺序的字节流
        ByteBuffer drawBb = ByteBuffer.allocateDirect(drawOrder.length * 2);
        drawBb.order(ByteOrder.nativeOrder());
        drawOrderBuffer = drawBb.asShortBuffer();
        drawOrderBuffer.put(drawOrder);
        drawOrderBuffer.position(0);
    }
}
