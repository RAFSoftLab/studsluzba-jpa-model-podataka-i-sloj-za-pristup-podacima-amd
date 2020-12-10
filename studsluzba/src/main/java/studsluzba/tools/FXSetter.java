package studsluzba.tools;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXSetter {
	
	public static void emptyElements(Object ... elements) {
		for (Object o : elements) {
			if (o instanceof Label) {
				((Label) o).setText("");
			}
			else if (o instanceof TextField) {
				((TextField) o).setText("");
			}
			else if (o instanceof ComboBox) {
				((ComboBox) o).setItems(null);
			}
			else if (o instanceof TableView) {
				((TableView) o).setItems(null);
			}
			else if (o instanceof ListView) {
				((ListView) o).setItems(null);
			}
			else if (o instanceof CheckBox) {
				 ((CheckBox)o).setSelected(false);
			}
			else if (o instanceof Object[]) {
				for (Object x : (Object[])o) {
					if (x instanceof CheckBox) {
						((CheckBox) x).setSelected(false);
					}					
				}
			}
			else if (o instanceof DatePicker) {
				((DatePicker) o).setValue(null);
			}
		}
	}

}
