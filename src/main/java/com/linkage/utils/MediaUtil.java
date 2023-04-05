package com.linkage.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MediaUtil {

    /**
     * 调用系统命令转码每个文件
     *
     * @param inputFile 输入视频文件路径
     * @param outputFileName 输出文件名
     */
    public  static void transferToH264(File inputFile, String outputFileName) {
        String outputFile = inputFile.getParentFile().getAbsolutePath() + "/" + outputFileName;
        String command = "ffmpeg -threads 5  -i " + inputFile.getAbsolutePath() + " -vcodec libx264 -preset ultrafast -r 29 -s 1920x1080 " + outputFile;
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            while(br.readLine() != null) {
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        if(inputFile.exists()){
            inputFile.delete();
        }
    }
}
