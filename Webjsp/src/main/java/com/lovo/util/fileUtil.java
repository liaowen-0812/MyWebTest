package com.lovo.util;


import java.io.*;

public class fileUtil {
    public void streamFile(String name) throws Exception {
        InputStream input = new FileInputStream(name);
        OutputStream out = new FileOutputStream("E/image"+name);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = input.read(bytes)) >0){
            out.write(bytes,0,len);
        }

        out.close();
        input.close();
    }
}
