package firstgefpro.command;

import org.eclipse.gef.requests.CreationFactory;

import firstgefpro.model.Employee;
import firstgefpro.model.Service;

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
		if (template == null) return null;
	    if (template == Service.class) {
	      Service srv = new Service();
	      srv.setEtage(42);
	      srv.setName("Factory");
	      return srv;
	    } else if (template == Employee.class) {
	      Employee emp = new Employee();
	      emp.setName("Halle");
	      emp.setLastName("Berry");
	      return emp;
	    }
	    return null;
	}

	@Override
	public Object getObjectType() {
		return this.template;
	}

}
