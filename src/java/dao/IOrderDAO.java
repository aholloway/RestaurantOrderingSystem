package dao;

import java.util.List;
import service.MenuItem;

/**
 * The general contract for all versions of OrderDAO classes.
 * Copied from Jim's code.  This interface is simple and does what needs
 * to get done.
 * 
 * @author jlombardo
 */
public interface IOrderDAO {

    List<MenuItem> getCurrentMenuChoices() throws RuntimeException;

    void saveOrder(List<MenuItem> orderList) throws RuntimeException;

}
