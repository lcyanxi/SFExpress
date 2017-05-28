package cn.coolbhu.sfexpress.webcontroller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by brainy on 17-5-27.
 */
public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    protected Subject subject;
    protected Session session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        //得到当前用户的 Subject
        subject = SecurityUtils.getSubject();
        session = subject.getSession();
    }
}
