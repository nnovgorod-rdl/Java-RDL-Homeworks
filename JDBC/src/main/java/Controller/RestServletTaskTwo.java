package Controller;

import DB.ConnectionDB;
import Model.StaffDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@WebServlet("/taskTwo")
public class RestServletTaskTwo extends HttpServlet {

    protected String processRequestTwo(String department) throws ServletException, IOException {
        GsonBuilder builderTwo = new GsonBuilder();
        Gson gson = builderTwo.create();
        List<StaffDAO> listOfStaffTwo = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = new ConnectionDB().getConnection().prepareStatement("SELECT * FROM staff, department WHERE department.id = staff.id and department.name=? ORDER BY staff.FIO ASC");
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listOfStaffTwo.add(new StaffDAO(rs.getString(1), rs.getBigDecimal(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gson.toJson(listOfStaffTwo);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String department = request.getParameter("department");
        String answer = null;
        answer = processRequestTwo(department);
        System.out.println(answer);
        response.getWriter().write(answer);
    }
}