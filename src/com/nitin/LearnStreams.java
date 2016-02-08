package com.nitin;

import java.io.*;

/**
 * Created by harsh on 1/25/16.
 */
public class LearnStreams {

    /**
     * Use FileInputStream.read(byte[])
     *
     * @param fileName   name of the file (absolute)
     * @param bufferSize kitna buffer karna hain.
     * @throws FileNotFoundException if file is not found
     */
    public static void readFile(String fileName, int bufferSize) throws IOException {
        FileInputStream fs = new FileInputStream(fileName);
        byte b[] = new byte[bufferSize];
        System.out.println("total bytes" + fs.available());

        while (fs.read(b) != -1) {
            for (int j = 0; j < b.length; j++) {
                System.out.print((char) (b[j]));
            }
        }
        try {
            if (fs != null) {
                fs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeFile(byte data[], String fileName, int bufferSize) throws IOException {
        ByteArrayInputStream bi = new ByteArrayInputStream(data);
        FileOutputStream fout = new FileOutputStream(fileName);
        byte b[] = new byte[bufferSize];
        while (bi.read() != -1) {
            for (int j = 0; j < b.length; j++) {
                fout.write(b[j]);
            }
        }
        try {
            if (fout != null) {
                fout.flush();
                fout.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bi != null) {
                bi.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Try implementing a basic version.
     *
     * @param srcFile
     * @param destFile
     * @param bufferSize
     */
    public static void efficientCopyFile(String srcFile, String destFile, int bufferSize) throws IOException {
        FileInputStream fi = new FileInputStream(srcFile);
        FileOutputStream fo = new FileOutputStream(destFile);
        byte b[] = new byte[bufferSize];
        while (fi.read(b) != -1) {
            for (int i = 0; i < b.length; i++) {
                fo.write(b[i]);
            }
        }
        try {
            if (fo != null) {
                fo.flush();
                fo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fi != null) {
                fi.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
//        long startTime = System.nanoTime();
//        readFile("C:/Users/Nitin/Desktop/nitin.txt", 100);
//        long endTime = System.nanoTime();
//        System.out.println("IT took " + (endTime - startTime) + "ns to read");

//        String s = "This is a new World";
//        byte b[] = s.getBytes();
//        writeFile(b, "C:/Users/Nitin/Desktop/nitin.txt", 5);
        long startTime = System.nanoTime();
        efficientCopyFile("C:/Users/Nitin/Desktop/the-hobbit-the-desolation-of-smaug-yify-english.srt",
                "C:/Users/Nitin/Desktop/nitin1.txt", 200);
        long endTime = System.nanoTime();
        System.out.println("It took"+(endTime - startTime)+"ns to read and write it to another file the file");
    }
}
/**
 * Reading 102kb srt file                                     Read and Write 102kb srt file
 * Buffer Size   Time Taken(ns)                               5 - 1642200655
 * 50             2501834483                                 20 - 1457006298
 * 100              907320725                                30 - 1400283157
 * 200              818662400                                60 - 1819761822
 * 400              835619217                               200 - 1805323834
 * 800             2063366790
 * <p/>
 * Reading a 318mb mp4 file
 * <p/>
 * Reading a 318mb mp4 file
 * <p/>
 * Reading a 318mb mp4 file
 * <p/>
 * Reading a 318mb mp4 file
 * <p/>
 * Reading a 318mb mp4 file
 * <p/>
 * Reading a 318mb mp4 file
 */
/**
 *Reading a 318mb mp4 file
 *
 *
 *
 *
 */

