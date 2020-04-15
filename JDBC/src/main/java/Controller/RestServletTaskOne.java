package Controller;

import DB.ConnectionDB;
import Model.StaffDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/taskOne")
public class RestServletTaskOne extends HttpServlet {

    protected String processRequest(String department) throws ServletException, IOException {
        System.out.println("Вход в метод, аргумент: "+department);
        GsonBuilder builderOne = new GsonBuilder();
        Gson gson = builderOne.create();
        List<StaffDAO> listOfStaffOne = new ArrayList<>();
        PreparedStatement ps = null;

        try {
            ps = new ConnectionDB().getConnection().prepareStatement("SELECT * FROM staff, department WHERE department.id = staff.id and department.name=? ORDER BY staff.salary ASC");
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.toString());
                listOfStaffOne.add(new StaffDAO(rs.getString(1), rs.getBigDecimal(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gson.toJson(listOfStaffOne);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String department = request.getParameter("department");
        System.out.println(department);
        String answer = null;
        answer = processRequest(department);
        System.out.println("Fyswer is : "+answer);
        response.getWriter().write(answer);
    }
}