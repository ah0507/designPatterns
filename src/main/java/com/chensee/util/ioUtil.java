package com.chensee.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ioUtil {
    /**
     * 文件下载
     */
    public void downLoad(HttpServletRequest request, HttpServletResponse response, String name){
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        BufferedInputStream bis = null;
        OutputStream os = null;
        if (name != null) {
            try {
                String fileName= URLEncoder.encode(name,"UTF-8");
                File loadFile = new File(filePath+fileName);
                response.reset();
                response.setContentType("application/octet-stream");
                response.setCharacterEncoding("utf-8");
                response.setContentLength((int) loadFile.length());
                response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
                os = response.getOutputStream();
                bis = new BufferedInputStream(new FileInputStream(loadFile));
                byte[] buff = new byte[1024];
                int i = 0;
                while ((i = bis.read(buff)) != -1) {
                    os.write(buff, 0, i);
                    os.flush();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bis!=null){
                        bis.close();
                    }
                    if(os!=null){
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件上传
     */
    public void upload(String filePwd,
                       HttpServletRequest request,
                       MultipartFile srcFile){
        String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        try {
            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  + srcFile.getOriginalFilename();
            srcFile.transferTo(new File(filePath));
            File zipFile = new File(filePath);
            this.unzip(zipFile,uploadPath);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void unzip(File file, String uploadPath) {
        String jsonStr = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                //解压entry.getName()文件
                if (entry.isDirectory()) {
                    String dirPath = uploadPath + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdirs();
                } else {
                    File targetFile = new File(uploadPath + entry.getName());
                    is = zipFile.getInputStream(entry);
                    //读取txt文件
                    String fileType = entry.getName().split("\\.")[1];
                    if ("txt".equals(fileType)) {
                        //fis = new FileInputStream(targetFile);
                        isr = new InputStreamReader(is, "utf-8");
                        br = new BufferedReader(isr);
                        StringBuffer stringBuffer = new StringBuffer();
                        String line = "";
                        while ((line = br.readLine()) != null) {
                            stringBuffer.append(line + System.getProperty("line.separator"));
                        }
                        jsonStr = new String(stringBuffer);
                    } else {
                        //字节流上传
                        fos = new FileOutputStream(targetFile);
                        int len;
                        byte[] buf = new byte[1024];
                        while ((len = is.read(buf)) != -1) {
                            fos.write(buf, 0, len);
                        }
//                        //字符流上传
//                        isr = new InputStreamReader(is, "utf-8");
//                        br = new BufferedReader(isr);
//                        fos = new FileOutputStream(targetFile);
//                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile));
//                        String line = "";
//                        while ((line = br.readLine()) != null) {
//                            bufferedWriter.write(line);
//                            bufferedWriter.newLine();
//                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (br != null) {
                    br.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(jsonStr);
    }
}
