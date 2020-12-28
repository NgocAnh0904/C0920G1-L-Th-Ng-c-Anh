package repository;

import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_web_jsp?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "NgocAnh090495";
//    private static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM customer_type";
//    private static final String GET_CUSTOMER_TYPE_BY_ID = "SELECT * FROM customer_type where customer_type_id = ?";

    private static final String SELECT_ALL_CUSTOMERTYPE = "select * from customer_type";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERTYPE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String idCustomerType = resultSet.getString("customer_type_id");
                String nameCustomerType = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(idCustomerType, nameCustomerType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }
}