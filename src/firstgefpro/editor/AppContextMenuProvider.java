package firstgefpro.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

/**
 * AppContextMenuProvider.java
 * 
 * @author Shashwat Anand
 * @version $Id: $
 * @since Feb 22, 2014
 */
public class AppContextMenuProvider extends ContextMenuProvider {
	private ActionRegistry actionRegistry;

	public AppContextMenuProvider(EditPartViewer viewer, ActionRegistry registry) {
		super(viewer);
		setActionRegistry(registry);
	}

	@Override
	public void buildContextMenu(IMenuManager menu) {
		IAction action;
		GEFActionConstants.addStandardActionGroups(menu);
		action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
		action = getActionRegistry().getAction(ActionFactory.REDO.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
	}

	private ActionRegistry getActionRegistry() {
		return this.actionRegistry;
	}

	private void setActionRegistry(ActionRegistry registry) {
		this.actionRegistry = registry;
	}

}
