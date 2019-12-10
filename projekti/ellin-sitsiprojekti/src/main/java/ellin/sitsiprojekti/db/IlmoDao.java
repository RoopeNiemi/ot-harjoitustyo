
package ellin.sitsiprojekti.db;

import ellin.sitsiprojekti.domain.Ilmo;
import java.sql.SQLException;
import java.util.List;

public class IlmoDao implements Dao<Ilmo, Integer> {

    //ei vielä missään käytössä
    
    @Override
    public void create(Ilmo object) throws SQLException {
        
    }

    @Override
    public Ilmo read(Integer key) throws SQLException {
        return null;
    }

    @Override
    public Ilmo update(Ilmo object) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        
    }

    @Override
    public List<Ilmo> list() throws SQLException {
        return null;
    }
    
}
