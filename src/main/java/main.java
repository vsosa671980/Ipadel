import dao.DBconection;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try {
            DBconection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
