package com.xishuang.imagesizetest.opengles;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Author:xishuang
 * Date:2018/1/2
 * Des:三角形
 */
public class Triangle {

    private final String vertexShaderCode =
            //这个矩阵变量乘以对应顶点坐标进行坐标转换
            "uniform mat4 uMVPMatrix;" +
            "attribute vec4 vPosition;" +
            "void main() {" +
            //矩阵必须包括一个可修改的gl_Position，注意uMVPMatrix要在*号的最前面，矩阵乘法知识
            "  gl_Position = uMVPMatrix * vPosition;" +
            "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
            "uniform vec4 vColor;" +
            "void main() {" +
            "  gl_FragColor = vColor;" +
            "}";

    /**
     * 每个顶点的维度数量
     */
    static final int COORDS_PER_VERTEX = 3;

    /**
     * 顶点坐标，逆时针，z方向都为0
     */
    static float[] triangleCoords = {
            0.0f, 0.622008459f, 0.0f,   // top
            -0.5f, -0.311004243f, 0.0f, // bottom left
            0.5f, -0.311004243f, 0.0f   // bottom right
    };

    /**
     * 设置颜色值，RGBA
     */
    static float[] color = {0.63671875f, 0.76953125f, 0.22265625f, 1.0f};
    private final FloatBuffer vertexBuffer;
    private final int mProgram;

    private int mPositionHandle;
    private int mColorHandler;
    private int mMVPMatrixHandler;
    private final int vertexCount = triangleCoords.length / COORDS_PER_VERTEX; //顶点个数
    private final int vertexStride = COORDS_PER_VERTEX * 4; //每个float 4字节


    public Triangle() {
        //初始化顶点坐标的字节流
        ByteBuffer bb = ByteBuffer.allocateDirect(
                // float有4个字节
                triangleCoords.length * 4);
        //使用与设备相关的字节序
        bb.order(ByteOrder.nativeOrder());
        //创建字节流
        vertexBuffer = bb.asFloatBuffer();
        //顶点坐标数据添加进字节流中
        vertexBuffer.put(triangleCoords);
        //设置开始读取位置
        vertexBuffer.position(0);

        //着色器编译
        int vertexShader = MyGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = MyGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        //创建OpenGL Program对象
        mProgram = GLES20.glCreateProgram();
        //着色器和program进行绑定
        GLES20.glAttachShader(mProgram, vertexShader);
        GLES20.glAttachShader(mProgram, fragmentShader);
        //program链接后可执行
        GLES20.glLinkProgram(mProgram);
    }

    public void draw(float[] mMVPMatrix){
        // 添加program到OpenGL ES环境
        GLES20.glUseProgram(mProgram);

        //1、获取顶点着色器中的vPosition对象
        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        //设置mPositionHandle可用，用于传递顶点坐标数据
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        //准备三角形坐标数据
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, vertexStride, vertexBuffer);

        //2、获取片元着色器中的vColor对象
        mColorHandler = GLES20.glGetUniformLocation(mProgram, "vColor");
        //设置绘制三角形的颜色
        GLES20.glUniform4fv(mColorHandler, 1, color, 0);

        //3、获取片元着色器中的uMVPMatrix对象
        mMVPMatrixHandler = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");
        //把数据传到着色器对象中去
        GLES20.glUniformMatrix4fv(mMVPMatrixHandler, 1, false, mMVPMatrix, 0);

        //正式绘制三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);

        //绘制完成后顶点属性设置不可用
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
