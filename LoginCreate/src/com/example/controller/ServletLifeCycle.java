package com.example.controller;

import com.example.da.ValidateProduct;
import com.example.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pro = request.getParameter("pro");
        Product product = new Product();
        product.setName(name);
        product.setPro(pro);
        if(ValidateProduct.insertProduct(name,pro)){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
