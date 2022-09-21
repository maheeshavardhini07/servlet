package com.kgisl.demo1.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgisl.demo1.entity.Bike;

public class BikeController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Bike Do get called");
        String action = req.getServletPath();
        System.out.println("Action block" + action);
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bikemanagementsystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "");

            ArrayList<Bike> bklist = new ArrayList<Bike>();
            java.sql.Statement stmt = conn.createStatement();
            String strSelect = "select bikeId, brand, carName, price from bike";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) { // Repeatedly process each row
                int id = rset.getInt("bikeId");
                String brand = rset.getString("brand"); // retrieve a 'String'-cell in the row
                String model = rset.getString("model"); // retrieve a 'double'-cell in the row
                Float price = rset.getFloat("price"); // retrieve a 'int'-cell in the row
                // System.out.println(id + " ," + brand + ", " + carName + ", " + price);
                bklist.add(new Bike(id, brand, model, price));
            }
            // crlist.forEach(System.out::println);
            req.setAttribute("bklist", bklist);
            RequestDispatcher dis = req.getRequestDispatcher("bikeList.jsp");
            dis.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
