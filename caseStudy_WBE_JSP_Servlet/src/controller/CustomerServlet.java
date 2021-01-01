package controller;

import model.Customer;
import model.CustomerType;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.CustomerTypeService;
import service.CustomerTypeServiceImpl;
import validate.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    Validate validate = new Validate();
    private String birthday;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        try {
            switch (action) {
                case "create":
                    createCustomer(request,response);
                    break;
                case "search":
                    break;
                case "edit":
                    editCustomer(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String idCustomer = request.getParameter("customer_id");
        String customerType = request.getParameter("customer_type_id");
        String nameCustomer = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("Customer_id_card");
        String phoneNumber = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        customerService.updateCustomer(new Customer(idCustomer, customerType, nameCustomer, birthday,
                gender, idCard, phoneNumber, email, address));
        request.setAttribute("messageConfig","success!");
//        response.sendRedirect("/customers");
        listCustomer(request,response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        boolean check = true;
        String messageId = null;
        String messageIdCard = null;
        String messagePhoneNumber= null;
        String messageBirthDay = null;
        String messageEmail = null;
        String birthDay = null;
        String phoneNumber = null;
        String email = null;
        String idCustomer = null;
        String idCard = null;

        try {
            idCustomer = request.getParameter("customerId");
            validate.regexIdCustomer(idCustomer);
        } catch (ValidateException e) {
            messageId = e.getMessage();
            check = false;
        }

        String customerType = request.getParameter("typeId");
        String nameCustomer = request.getParameter("name");
        try {
            birthDay = request.getParameter("birthday");
            validate.regexDate(birthDay);
        } catch (BirthdayException e) {
            messageBirthDay = e.getMessage();
            check = false;
        }

        String gender = request.getParameter("gender");

        try {
            idCard = request.getParameter("idCard");
            validate.regexIdCard(idCard);
        }catch (ValidateException e){
            messageIdCard = e.getMessage();
            check = false;
        }

        try {
            phoneNumber = request.getParameter("phone");
            validate.regexPhone(phoneNumber);
        } catch (PhoneException e) {
            messagePhoneNumber = e.getMessage();
            check = false;
        }
        try {
            email = request.getParameter("email");
            validate.regexEmail(email);
        } catch (EmailException e) {
            messageEmail = e.getMessage();
            check = false;
        }
        String address = request.getParameter("address");

        if (!check){
            request.setAttribute("customer_id", idCustomer);
            request.setAttribute("customer_type_id", customerType);
            request.setAttribute("customer_name", nameCustomer);
            request.setAttribute("customer_birthday", birthDay);
            request.setAttribute("customer_gender", gender);
            request.setAttribute("customer_id_card", idCard);
            request.setAttribute("customer_phone", phoneNumber);
            request.setAttribute("customer_email", email);
            request.setAttribute("customer_address", address);
            request.setAttribute("messageId", messageId);
            request.setAttribute("messageIdCard", messageIdCard);
            request.setAttribute("messageBirthDay", messageBirthDay);
            request.setAttribute("messagePhone", messagePhoneNumber);
            request.setAttribute("messageEmail", messageEmail);
            showCreateCustomer(request,response);
        }else {
            customerService.insertCustomer(new Customer(idCustomer, customerType
                    , nameCustomer, birthday, gender, idCard, phoneNumber, email, address));
            request.setAttribute("messageConfig","add success!");
//        response.sendRedirect("/customers");
            listCustomer(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        try {
            switch (action) {
                case "create":
                    showCreateCustomer(request,response);
                    break;
                case "search":
                    findCustomerByname(request,response);
                    break;
                case "edit":
                    showEditCustomer(request,response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void findCustomerByname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("customerName");
        List<Customer> customerList = customerService.searchByName(name);
        request.setAttribute("customerList" ,customerList);
//        request.setAttribute("name" ,name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/search.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("id");
        Customer customer = customerService.selectCustomer(customerId);
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("cus",customer);
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String idCustomer = request.getParameter("customerId");
        customerService.deleteCustomer(idCustomer);
        request.setAttribute("messageConfig","deleted successfully!");
//        response.sendRedirect("/customers");
        listCustomer(request,response);
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.getAllCustomers();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/list.jsp");
        dispatcher.forward(request,response);
    }
}
