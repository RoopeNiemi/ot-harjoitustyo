
package ellin.sitsiprojekti.domain;

import ellin.sitsiprojekti.ui.Kayttoliittyma;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Kayttoliittyma.class);
            }
        }.start();
    }
}
