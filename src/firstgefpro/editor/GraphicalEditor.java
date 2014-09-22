package firstgefpro.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;

import firstgefpro.part.AppEditPartFactory;

/**
 * GraphicalEditor.java
 * @author Shashwat Anand
 * @version $Id: $
 * @since Sept 21, 2014
 */
public class GraphicalEditor extends GraphicalEditorWithPalette {
	public static final String ID = "firstGEFPro.graphicalEditor";

	/**
	 * Constructor
	 */
	public GraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}


	@Override
	protected void initializeGraphicalViewer() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void configureGraphicalViewer() {
	    super.configureGraphicalViewer();
	    GraphicalViewer viewer = getGraphicalViewer();
	    viewer.setEditPartFactory(new AppEditPartFactory());

	    ContextMenuProvider provider = new AppContextMenuProvider(viewer, getActionRegistry());
	    viewer.setContextMenu(provider);
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void initializePaletteViewer() {
		super.initializePaletteViewer();
		getPaletteViewer().addDragSourceListener(new TemplateTransferDragSourceListener(getPaletteViewer()));
	}
}
