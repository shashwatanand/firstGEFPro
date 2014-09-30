package firstgefpro.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Node.java
 * @author Shashwat Anand
 * @version $Id: $
 * @since Sept 25, 2014
 */
public class Node {
	private PropertyChangeSupport listeners;
	
	private Rectangle layout;

	private List<Node> children;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	public PropertyChangeSupport getListeners() {
		return listeners;
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}
}
