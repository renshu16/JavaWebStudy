package com.rensq.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * Created by toothbond on 16/7/6.
 */
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向浏览器输出字符串
        //outputChinese(resp);

        //实现文件下载
        //downloadFileByOutputStream(resp);

        //HttpServletResponse应用,生成随机图片验证码
        //buildRandomAuthImage(resp);

        //通过response实现请求重定向
        //requestRedirect(resp);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);


    }

    private void requestRedirect(HttpServletResponse resp) throws IOException {

        //1.调用sendRedirect方法实现请求重定向,
        //resp.sendRedirect("/servlet/context1");

        //2.使用response设置302状态码和设置location响应头实现重定向实现请求重定向
        resp.setHeader("Location","/servlet/context1");
        resp.setStatus(HttpServletResponse.SC_FOUND);
    }

    private void buildRandomAuthImage(HttpServletResponse resp) throws IOException {
        resp.setHeader("refresh","5");
        BufferedImage image = new BufferedImage(90,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,90,20);
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeRandomNumber(),0,20);

        resp.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
        resp.setDateHeader("expries",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        ImageIO.write(image,"jpg",resp.getOutputStream());

    }

    private String makeRandomNumber(){
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<7-num.length(); i++){
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
    }

    private void downloadFileByOutputStream(HttpServletResponse resp) throws IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/image/shuqi.JPG");
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        resp.setHeader("content-disposition","attachment;filename=" + fileName);
        InputStream in = new FileInputStream(path);
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = resp.getOutputStream();
        while ((len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }
        in.close();


    }

    private void outputChinese(HttpServletResponse resp) throws IOException {
        String data = "你好,世界!";

        outputChineseByOutStream(resp, data);

        outputChineseByPrintWriter(resp, data);

    }

    /**
     * //通过OutputStream输出信息
     * @param resp
     * @param data
     * @throws IOException
     */
    private void outputChineseByOutStream(HttpServletResponse resp, String data) throws IOException {
        ServletOutputStream outputStream = resp.getOutputStream();
        //控制客户端浏览器以UTF-8的编码打开
        resp.setHeader("content-type","text/html;charset=UTF-8");
        //使用OutputStream流向客户端浏览器输出中文，以UTF-8的编码进行输出
        byte[] bytes = data.getBytes("UTF-8");
        outputStream.write(bytes);
    }

    /**
     * //通过PrintWriter输出信息
     * @param resp
     * @param data
     * @throws IOException
     */
    private void outputChineseByPrintWriter(HttpServletResponse resp, String data) throws IOException {
        //让chrome浏览器支持识别html标签
        resp.setHeader("content-type","text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        writer.write("<h1>" + data + "</h1>");
    }
}
