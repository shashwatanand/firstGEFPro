package firstgefpro.part;

import java.beans.PropertyChangeListener;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import firstgefpro.model.Node;

/**
 * AbstractEditPart.java
 * @author Shashwat Anand
 * @version $Id: $
 * @since Sept 27, 2014
 */
public abstract class AbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {
	@Override
	public void activate() {
		super.activate();
		((Node) getModel()).addPropertyChangeListener(this);
	}
	
	@Override
	public void deactivate() {
		super.deactivate();
		((Node) getModel()).removePropertyChangeListener(this);
	}
}
