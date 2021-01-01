package repository;

import model.BenhAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoryImpl implements BenhAnRepository {
    private String jdbcURL = "jdbc:mysql://localhost:1099/Test_Module3?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "NgocAnh090495";

    private static final String SELECT_ALL_BENHAN = "select * from benh_an";

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
    public List<BenhAn> getAllBenhAn() {
        List<BenhAn> benhAnList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BENHAN)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String idBenhAn = resultSet.getString("benh_an_id");
                String dateIn = resultSet.getString("ngay_ra_vien");
                String dateOut = resultSet.getString("ngay_nhap_vien");
                String reasonIn = resultSet.getString("lydo_nhapvien");
                benhAnList.add(new BenhAn(idBenhAn, dateIn, dateOut, reasonIn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhAnList;
    }
}
