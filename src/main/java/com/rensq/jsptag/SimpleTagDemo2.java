package com.rensq.jsptag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by toothbond on 16/7/12.
 */
public class SimpleTagDemo2 extends SimpleTagSupport {

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void doTag() throws JspException, IOException {
        for (int i=0; i<count; i++){
            this.getJspBody().invoke(null);
        }
    }
}
