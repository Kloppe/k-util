package com.kk.rest;

import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * FileTest
 *
 * @author juejin
 * @datetime 2023/3/1
 */
public class FileTest {

    @Test
    public void fileTest() throws IOException {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        for (String name : Objects.requireNonNull(file.list())) {
            System.out.println(name);
        }
        String[] fileNames = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
        });
        System.out.println("-----------");
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
        System.out.println("-----------");
        Arrays.sort(fileNames, String.CASE_INSENSITIVE_ORDER);
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
        System.out.println("-----------");
        System.out.println(ppPrint(Arrays.asList(fileNames)));
    }

    public static String ppPrint(Collection<?> col) {
        StringBuffer result = new StringBuffer("[");
        for (Object o : col) {
            if (col.size() != 1) {
                result.append("\n");
            }
            result.append(o);
        }
        if (col.size() != 1) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    @Test
    public void readFileTest() throws IOException {
        readFile("./pom.xml");
    }


    public static String readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String s;
        StringBuilder buffer = new StringBuilder();
        while ((s = br.readLine()) != null) {
            buffer.append(s).append("\n");
        }
        br.close();
        System.out.println(buffer.toString());
        return br.toString();
    }

    // ##################### nio ##################

    @Test
    public void testFile() throws IOException {
        FileChannel fc = new FileOutputStream("./data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();


    }
}