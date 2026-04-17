package com.afia577;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int salary = Integer.parseInt(request.getParameter("salary"));

        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setSalary(salary);

        EmployeeDAO dao = new EmployeeDAO();
        dao.updateEmployee(e);

        response.getWriter().println("Updated Successfully!");
    }
}