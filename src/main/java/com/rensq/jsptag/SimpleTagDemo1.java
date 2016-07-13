package com.rensq.jsptag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by toothbond on 16/7/12.
 * 简单标签的常见应用
 */
public class SimpleTagDemo1 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        //得到代表jsp标签体的JspFragment
        JspFragment jspFragment = this.getJspBody();
//        //得到jsp页面的的PageContext对象
//        JspContext jspContext = jspFragment.getJspContext();
//        //调用JspWriter将标签体的内容输出到浏览器
//        jspFragment.invoke(jspContext.getOut());

        //1.将标签体的内容输出到浏览器
        refreshContent(jspFragment);

        //2.重复执行
        //refreshLoop(jspFragment);

        //3.修改jsp页面的内容
        //modifyContent(jspFragment);

        //4.控制jsp页面是否继续执行
        //抛出一个SkipPageException异常就可以控制标签余下的Jsp不执行
//        throw new SkipPageException();
    }

    private void modifyContent(JspFragment jspFragment) throws JspException, IOException {
        StringWriter sw = new StringWriter();
        //将标签体的内容写入到sw流中
        jspFragment.invoke(sw);
        //获取sw流缓冲区的内容
        String content = sw.getBuffer().toString();
        content = content.toUpperCase();
        PageContext pageContext = (PageContext) this.getJspContext();
        //将修改后的content输出到浏览器中
        pageContext.getOut().write(content);
    }

    private void refreshLoop(JspFragment jspFragment) throws JspException, IOException {
        for (int i = 0; i < 5; i++) {
            // 将标签体的内容输出到浏览器
            jspFragment.invoke(null);
        }
    }

    private void refreshContent(JspFragment jspFragment) throws JspException, IOException {
        jspFragment.invoke(null);
    }
}
