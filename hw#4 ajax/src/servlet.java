import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet", urlPatterns={"/servlet"})
public class servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType(
                "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String message = "404";
        if(!request.getParameter("preference").equals("")) {
            message = "ok";
        }
        out.print(message);
        out.close();
    }
}
