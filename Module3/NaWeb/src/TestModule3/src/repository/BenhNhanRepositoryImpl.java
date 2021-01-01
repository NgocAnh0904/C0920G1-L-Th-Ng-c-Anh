package repository;

import model.BenhNhan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepositoryImpl implements BenhNhanRepository {
    private String jdbcURL = "jdbc:mysql://localhost:1099/Test_Module3?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "NgocAnh090495";

    private static final String INSERT_BENHNHAN_SQL = "INSERT INTO benhnhan (benh_nhan_id, benh_nhan_name)" +
            "VALUES " + "(?,?);";
    private static final String SELECT_ALL_BENHNHAN = "select * from benhnhan";
    private static final String SELECT_BENHNHAN_BY_NAME = "select * from benhnhan where benh_nhan_name like ?";
    private static final String DELETE_BENHNHAN_SQL = "delete from benhnhan where benh_nhan_id = ?";
    private static final String UPDATE_BENHNHAN_SQL = "update benhnhan set benh_nhan_id = ?, benh_nhan_name ? where benh_nhan_id = ?";
    private static final String SELECT_BENHNHAN = "select * from benhnhan where  benh_nhan_id = ?";
    private BenhNhan BenhNhan;

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
    public List<BenhNhan> getAllBenhNhan() {
        List<BenhNhan> BenhNhanList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BENHNHAN)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String idBenhNhan = "BN-" + resultSet.getString("benh_nhan_id");
                String nameBenhNhan = resultSet.getString("benh_nhan_name");
                BenhNhanList.add(new BenhNhan(idBenhNhan, nameBenhNhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return BenhNhanList;
    }

    @Override
    public void insertBenhNhan(BenhNhan customer) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_BENHNHAN_SQL)) {
            statement.setString(1,customer.getIdBenhNhan().substring(3));
            statement.setString(2,customer.getNameBenhNhan());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteBenhNhan (String id) throws SQLException {
        boolean check;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BENHNHAN_SQL)) {
            statement.setString(1,id.substring(3));
            check = statement.executeUpdate() > 0;
        }finally {
            getConnection().close();
        }
        return check;
    }

    @Override
    public boolean updateBenhNhan(BenhNhan BenhNhan) throws SQLException {
        boolean check;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BENHNHAN_SQL)) {
            statement.setString(1,BenhNhan.getIdBenhNhan());
            statement.setString(2,BenhNhan.getNameBenhNhan());
            check = statement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public BenhNhan selectBenhNhan (String id) {
        BenhNhan BenhNhan = null;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_BENHNHAN)) {
            statement.setString(1,id.substring(3));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String idBenhNhan = "BN-" + resultSet.getString("benh_nhan_id");
                String nameBenhNhan = resultSet.getString("benh_nhan_name");
                BenhNhan = new BenhNhan(idBenhNhan, nameBenhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BenhNhan;
    }

    @Override
    public List<model.BenhNhan> searchByName(String name) {
        return null;
    }
}
