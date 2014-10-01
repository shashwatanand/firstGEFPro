package firstgefpro.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Node.java
 * 
 * @author Shashwat Anand
 * @version $Id: $
 * @since Sept 25, 2014
 */
public class Node {
	public static final String PROPERTY_ADD = "NodeAddChild";

	public static final String PROPERTY_LAYOUT = "NodeLayout";

	private PropertyChangeSupport listeners;

	private Rectangle layout;

	private List<Node> children;

	private String name;

	private Node parent;

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

	public boolean addChild(Node child) {
		boolean b = this.children.add(child);
		if (b) {
			child.setParent(this);
			getListeners().firePropertyChange(PROPERTY_ADD, null, child);
		}
		return b;
	}

	public boolean removeChild(Node child) {
		return this.children.remove(child);
	}

	public List<Node> getChildrenArray() {
		return this.children;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setLayout(Rectangle newLayout) {
		Rectangle oldLayout = this.layout;
		this.layout = newLayout;
		getListeners()
				.firePropertyChange(PROPERTY_LAYOUT, oldLayout, newLayout);
	}

	public Rectangle getLayout() {
		return this.layout;
	}
}
