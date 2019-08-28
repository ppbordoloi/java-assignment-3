package com.zaloni.assgn.Assgn3.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyErrorController implements ErrorController {

  @RequestMapping("/error")
  @ResponseBody
  public String handleError(HttpServletRequest request, HttpServletResponse resp) throws IOException {
      resp.sendRedirect("errorPage.jsp");
      return null;
  }

  @Override
  public String getErrorPath() {
      return "/error";
  }
}
