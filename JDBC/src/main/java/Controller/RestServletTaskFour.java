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


@WebServlet("/taskFour")
public class RestServletTaskFour extends HttpServlet {

    protected String processRequestFour(String fio) throws ServletException, IOException {
        GsonBuilder builderFour = new GsonBuilder();
        Gson gson = builderFour.create();
        List<StaffDAO> listOfStaffFour = new ArrayList<>();
        PreparedStatement ps = null;
        PreparedStatement psTwo = null;
        Connection conn = new ConnectionDB().getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM staff, department WHERE staff.FIO=?");
            ps.setString(1, fio);
            ResultSet rs = ps.executeQuery();
            StaffDAO querryFourPerson = null;
            String departName = null;

            while (rs.next()) {
                querryFourPerson = new StaffDAO( rs.getString("fio"),  rs.getBigDecimal("salary"), rs.getString("position"), rs.getInt("id"));
                departName = rs.getString("name");
            }
            try {
                ps.close();
                conn.clearWarnings();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(querryFourPerson.toString());

                if (querryFourPerson.getPosition().equalsIgnoreCase("worker")) {
                    querryFourPerson.setId(0);
                    querryFourPerson.setFIO(null);
                    querryFourPerson.setPosition(null);
                    listOfStaffFour.add(querryFourPerson);
                } else if (querryFourPerson.getPosition().equalsIgnoreCase("boss")) {
                    psTwo = conn.prepareStatement("SELECT staff.FIO, staff.salary, staff.position, staff.id FROM staff, department WHERE department.name=? and department.id = staff.id order by staff.FIO");

                    psTwo.setString(1, departName);
                    ResultSet rsTwo = psTwo.executeQuery();
                    while (rsTwo.next()) {
                        String subordinateFIO = rsTwo.getString("fio");
                        BigDecimal subordinateSalary = rsTwo.getBigDecimal("salary");
                        String subordinatePositionNew = rsTwo.getString("position");
                        int subordinateId = rsTwo.getInt("id");
                        if (!subordinateFIO.equalsIgnoreCase(querryFourPerson.getFIO())) {
                            listOfStaffFour.add(new StaffDAO(subordinateFIO, subordinateSalary, subordinatePositionNew, subordinateId));
                        }
                    }
                }
            psTwo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gson.toJson(listOfStaffFour);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String fio = request.getParameter("fio");
        System.out.println(fio);
        String answer = null;
        answer = processRequestFour(fio);
        System.out.println(answer);
        response.getWriter().write(answer);
    }
}