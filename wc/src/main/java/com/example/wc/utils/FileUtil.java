package com.example.wc.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    /**
     * 压缩图片为zip格式
     *
     * @param zipOutputStream
     * @param input
     * @param fileName
     */
    public static void generateZip(ZipOutputStream zipOutputStream, InputStream input, String fileName) {
        BufferedInputStream bufferStream = null;
        try {
            String zipEntryName = fileName;
            byte[] bytes = new byte[1024 * 100];
            bufferStream = new BufferedInputStream(input);

            ZipEntry zipEntry = new ZipEntry(zipEntryName);
            // 定位到该压缩条目位置，开始写入文件到压缩包中
            zipOutputStream.putNextEntry(zipEntry);
            int len = 0;
            while ((len = bufferStream.read(bytes)) != -1) {
                zipOutputStream.write(bytes, 0, len);
            }
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferStream != null) {
                try {
                    bufferStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + File.separator + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 删除文件
     *
     * @param filePath
     */
    public static void deleteFile(String filePath) {
        File targetFile = new File(filePath);
        if (targetFile.exists()) {
            targetFile.delete();
        }
    }
}
