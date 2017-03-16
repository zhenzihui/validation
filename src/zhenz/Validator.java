package zhenz;

import Utils.SqlHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by zhenz on 2017/2/28.
 */
@WebServlet(name = "Validator")
public class Validator extends HttpServlet {
    ServletContext context ;
SqlHelper helper;
HttpSession session ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context  = getServletContext();
        String driverName = context.getInitParameter("Driver");

        String dbURL=context.getInitParameter("Url");
        String userName=context.getInitParameter("userName");
        String password = context.getInitParameter("password");
        String database = context.getInitParameter("Database");
        helper = new SqlHelper(driverName,userName,password,database);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="";
        String name = request.getParameter("name");
        String psw = request.getParameter("password");
        //session
        session = request.getSession(true);
        String sql = "select * from users where name='" +name+"'" +
                " and password='" +psw+
                "'" ;
        System.out.print(sql);
      ResultSet set=  helper.executeQuery(sql);

        boolean flag = false;


        try {
            if(set.next())
            {
                flag=true;
                request.setAttribute("name",name);
                session.setAttribute("login",true);
                String user = set.getString("name");
                String id = set.getString("id");
                request.setAttribute("name",user);
                request.setAttribute("id",id);
                HttpSession loginState =request.getSession(true);
                loginState.setAttribute("login",true);
                request.getRequestDispatcher("/success.jsp").forward(request,response);
               request.getRequestDispatcher("/success.jsp").forward(request,response);
            }else
            {
                result="登录失败,你输入的用户名：" +
                        name +
                        "密码:" +
                        psw;

            }







        } catch (SQLException e) {
        e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
