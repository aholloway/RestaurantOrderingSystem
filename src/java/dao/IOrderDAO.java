package dao;

import java.util.List;
import service.ItemStrategy;

/**
 * The general contract for all versions of OrderDAO classes. Copied from Jim's
 * code. This interface is simple and does what needs to get done.
 *
 * @author jlombardo
 */
public interface IOrderDAO {

    List<ItemStrategy> getCurrentMenuChoices() throws RuntimeException;

    void saveOrder(List<ItemStrategy> orderList) throws RuntimeException;

    public List<ItemStrategy> getCurrentTransaction();

    public List<ItemStrategy> getTransactionById(int id);

    public int getCurrentId();
}
