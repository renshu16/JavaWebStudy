package com.rensq.jsptag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by toothbond on 16/7/12.
 */
public class TagDemo1 extends TagSupport {


    /**
     * 控制自定义标签中的内容是否执行
     * @return
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
//        return Tag.SKIP_BODY;
        return Tag.EVAL_BODY_INCLUDE;
    }


    /**
     * 控制整个jsp页面是否执行
     * @return
     * @throws JspException
     */
    @Override
    public int doEndTag() throws JspException {
        //如果这个方法返回EVAL_PAGE，则执行标签余下的jsp页面，如果返回SKIP_PAGE，则不执行余下的jsp
//        return Tag.SKIP_PAGE;
        return Tag.EVAL_PAGE;
    }
}
