
package ellin.sitsiprojekti.db;

import ellin.sitsiprojekti.domain.Henkilo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HenkiloDao implements Dao<Henkilo, Integer> {

    @Override
    public void create(Henkilo henkilo) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./henkilotietokanta", "ellipsi", "");

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Henkilo"
                + " (nimi, maili)"
                + " VALUES (?, ?)");
        stmt.setString(1, henkilo.getNimi());
        stmt.setString(2, henkilo.getMaili());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    @Override
    public Henkilo read(Integer key) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./henkilotietokanta", "ellipsi", "");

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Henkilo WHERE id = ?");
        stmt.setInt(1, key);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        Henkilo h = new Henkilo(rs.getString("nimi"), rs.getString("maili"));

        stmt.close();
        rs.close();
        connection.close();

        return h;
    }

    @Override
    public Henkilo update(Henkilo object) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        
    }

    @Override
    public List<Henkilo> list() throws SQLException {
        return null;
    }
    
}
