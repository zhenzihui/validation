package zhenz;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import Utils.SqlHelper;
/**
 * Created by zhenz on 2017/3/1.
 */
@WebServlet(name = "Register")
public class Register extends HttpServlet {
    ServletContext context ;
    SqlHelper sqlHelper;
    HttpSession session;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context  = getServletContext();
        String driverName = context.getInitParameter("Driver");
        String dbURL=context.getInitParameter("Url");
        String userName=context.getInitParameter("userName");
        String password = context.getInitParameter("password");
      sqlHelper = new SqlHelper(driverName,userName,password,"valid");


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String psw = request.getParameter("password");
        //session
        session=request.getSession(true);
            String create = "INSERT INTO users(name,password) values(?,?)";
            sqlHelper.execute(create,new String[] {name,psw});
ResultSet set= sqlHelper.executeQuery("SELECT * FROM users WHERE NAME ='"+name+"' AND password='"+psw+"'");
//
        try {
            while (set.next()) {
                session.setAttribute("login",true);
                String id= set.getString("id");
                request.setAttribute("id",id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.print("注册成功");
                request.getSession();
                request.setAttribute("name",name);

               request.getRequestDispatcher("/success.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
