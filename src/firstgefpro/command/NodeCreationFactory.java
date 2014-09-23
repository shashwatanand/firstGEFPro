package firstgefpro.command;

import org.eclipse.gef.requests.CreationFactory;

/**
 * NodeCreationFactory.java
 * @author Shashwat Anand
 * @version $Id: $
 * @since Sept 23, 2014
 */
public class NodeCreationFactory implements CreationFactory {

	private Class<?> template;

	public NodeCreationFactory(Class<?> t) {
		this.template = t;
	}

	@Override
	public Object getNewObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObjectType() {
		return this.template;
	}

}
