package jp.co.itone.ocpdev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/HelloWorld")
public class HelloServlet extends HttpServlet {

   static String PAGE_HEADER = "<html><head /><body>";
   static String PAGE_FOOTER = "</body></html>";

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      retHTML(req, resp);
   }
   public void retHTML(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
      String userName = req.getParameter("user");
      if (userName == null) {
         userName = "OpenShift";
      }

      resp.setContentType("text/html");

	   PrintWriter writer = resp.getWriter();
      writer.print(PAGE_HEADER);
      writer.print("Hello "+ userName);
      writer.print(PAGE_FOOTER);
      writer.close();

   }

}