package com.lovo.servlet;

import com.lovo.service.IKaoqingService;
import com.lovo.service.impl.KaoqingServiceImpl;
import com.lovo.util.UploadUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class fileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UploadUtil uploadUtil=new UploadUtil();
        try {
            Map<String, List<FileItem>> map= uploadUtil.getFileItem(request);
//            获得表单集合
            List<FileItem> listForm=   map.get("listForm");
//            获得文件集合
            List<FileItem> listFile=   map.get("listFile");

            for (FileItem file:listFile) {
                String fileName = file.getName();

                String ext = fileName.substring(fileName.lastIndexOf(".")+1);
                boolean flag = false;
                String[] arr = {"jpg","png","gif"};
                for (String str:arr) {
                    if(str.equals(ext)){
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    request.getRequestDispatcher("f/fileShow.jsp").forward(request,response);
                    return;
                }else{
                    long tempTime = System.currentTimeMillis();
                    IKaoqingService service = new KaoqingServiceImpl();
                    service.insertFileInfo(tempTime+fileName);

                    OutputStream out=new FileOutputStream("E:/image/"+ tempTime+ file.getName());
                    InputStream in= file.getInputStream();
                    byte[]bytes=new byte[1024];
                    int len=0;
                    while ((len=in.read(bytes))>0){
                        //写
                        out.write(bytes,0,len);
                    }
                    out.close();
                    in.close();
                }
            }
            
        } catch (FileUploadException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
