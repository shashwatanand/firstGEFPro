package firstgefpro.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;

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
	protected PaletteRoot getPaletteRoot() {
		// TODO Auto-generated method stub
		return null;
	}
}
