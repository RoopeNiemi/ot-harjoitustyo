
package ellin.sitsiprojekti.domain;

import ellin.sitsiprojekti.ui.Kayttoliittyma;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Kayttoliittyma.class);
            }
        }.start();
    }
}
