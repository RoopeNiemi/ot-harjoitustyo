
package ellin.sitsiprojekti.domain;

import ellin.sitsiprojekti.db.HenkiloDao;
import ellin.sitsiprojekti.ui.Kayttoliittyma;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException {
        alustaTaulut();
        
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Kayttoliittyma.class);
            }
        }.start();
    }
    
    public static void alustaTaulut() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./henkilotietokanta", "ellipsi", "")) {
            conn.prepareStatement("DROP TABLE Henkilo IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE Henkilo(id serial, nimi varchar(255), maili varchar(100));").executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
