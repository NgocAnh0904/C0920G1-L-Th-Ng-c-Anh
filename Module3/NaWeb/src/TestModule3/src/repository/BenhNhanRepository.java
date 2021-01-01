package repository;

import model.BenhNhan;

import java.sql.SQLException;
import java.util.List;

public interface BenhNhanRepository {
    List<BenhNhan> getAllBenhNhan();
    void insertBenhNhan(BenhNhan BenhNhan) throws SQLException;
    boolean deleteBenhNhan(String id) throws SQLException;
    boolean updateBenhNhan(BenhNhan BenhNhan) throws SQLException;
    BenhNhan selectBenhNhan(String id);
    List<BenhNhan> searchByName(String name);
}
