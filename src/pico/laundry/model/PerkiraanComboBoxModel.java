package pico.laundry.model;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import pico.laundry.entity.Perkiraan;

public class PerkiraanComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private Connection connection;
    private List<Perkiraan> data;
    private Object selection;

    public PerkiraanComboBoxModel(Connection connection) {
        this.connection = connection;
        data = new ArrayList<Perkiraan>();
    }

    @Override
    public int getSize() {
        return getData().size();
    }

    @Override
    public Object getElementAt(int index) {
        return getData().get(index).getNama();
    }

    @Override
    public void setSelectedItem(Object anObject) {
        if ((selection != null && !selection.equals(anObject))
                || selection == null && anObject != null) {
            selection = anObject;
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    public List<Perkiraan> getData() {
        return data;
    }

    public void setData(List<Perkiraan> data) {
        this.data = data;
    }

}
