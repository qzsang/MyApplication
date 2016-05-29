package com.example.administrator.videotest;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/3/10.
 */
public class SingleVideoUtil {


    //得到本地测试视频地址
    public static String getVideoPath(Context context) {
        final String filePath = context.getFilesDir()
                + File.separator + "video.mp4";
        File file = new File(filePath);

        if(!file.exists()) {

            try {
                InputStream inStream = context.getResources().openRawResource(R.raw.video);

                FileOutputStream fs = new FileOutputStream(file);
                byte[] buffer = new byte[1444];
                int bytesum = 0;
                int byteread = 0;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;            //字节数 文件大小
                    //   System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                fs.flush();
                fs.close();
                inStream.close();
                Log.e("playVideo path", "copy finish");

            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return filePath.toString();

    }


//视频播放器
    public static MediaPlayer mediaPlayer = null;


    public static void play() {

        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void preparePlay(SurfaceView sv_video) {

        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
       final String path = getVideoPath(sv_video.getContext());
        final SurfaceHolder surfaceHolder = sv_video.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                prepare(surfaceHolder, path);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

    }


    public static void prepare(SurfaceHolder surfaceHolder,String path) {
        if (mediaPlayer == null || surfaceHolder == null) return;

        mediaPlayer.setDisplay(surfaceHolder);
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(android.media.MediaPlayer mp) {
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //释放资源
    public static void release() {
        if (mediaPlayer == null)
            return;
       // mediaPlayer.release();
        mediaPlayer.pause();
    }

}
