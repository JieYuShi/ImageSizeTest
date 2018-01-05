package com.xishuang.imagesizetest.opengles;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Author:xishuang
 * Date:2018/1/2
 * Des:渲染器
 */
public class MyGLRenderer implements GLSurfaceView.Renderer {
    //mMVPMatrix是视图模型投影矩阵
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mCameraMatrix = new float[16];
    private final float[] mRotationMatrix = new float[16];

    private Triangle triangle;
    private Square square;
    private float mAngle;

    @Override
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        //设置背景颜色
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        //初始化三角形
        triangle = new Triangle();
        //初始化四边形
        square = new Square();
    }

    @Override
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        // 视图的几何形状改变调用设置视图窗口大小
        GLES20.glViewport(0, 0, width, height);

        //计算宽高比
        float ratio = (float) width / height;
        // 在onDrawFrame()方法中采用投影矩阵
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
    }

    @Override
    public void onDrawFrame(GL10 unused) {
        //清除颜色缓存区，重绘背景颜色
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        float[] scrath = new float[16];

        //设置摄像头位置
        Matrix.setLookAtM(mCameraMatrix, 0, 0, 0, -3, 0, 0, 0, 0, 1.0f, 0);
        //根据投影矩阵和摄像头位置计算视图模型投影矩阵
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mCameraMatrix, 0);
        //三角形旋转角度构建矩阵
//        long time = SystemClock.uptimeMillis() % 4000L;
//        float angle = 0.09f * ((int)time);
        Matrix.setRotateM(mRotationMatrix, 0, mAngle, 0, 0, -1);
        Matrix.multiplyMM(scrath, 0, mMVPMatrix, 0, mRotationMatrix, 0);

        triangle.draw(scrath);
    }

    public void setAngle(float angle) {
        mAngle = angle;
    }

    public float getAngle() {
        return mAngle;
    }

    /**
     * 加载着色器
     */
    public static int loadShader(int type, String shaderCode) {
        // 创建顶点着色器类型(GLES20.GL_VERTEX_SHADER)
        // 创建片元着色器类型(GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        //着色器源码编译，并完成
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }
}
