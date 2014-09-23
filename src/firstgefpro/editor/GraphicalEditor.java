package firstgefpro.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;





import firstgefpro.command.NodeCreationFactory;
import firstgefpro.model.Employee;
import firstgefpro.model.Service;
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
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(createEntreprise());
		viewer.addDropTargetListener(new MyTemplateTransferDropTargetListener(
				viewer));
	}


	private EditPart createEntreprise() {
		// TODO Auto-generated method stub
		return null;
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
	    PaletteRoot root = new PaletteRoot();
	    PaletteGroup manipGroup = new PaletteGroup("Manipulation of object");
	    root.add(manipGroup);
	    SelectionToolEntry selectionToolEntry = new SelectionToolEntry();
	    manipGroup.add(selectionToolEntry);
	    manipGroup.add(new MarqueeToolEntry());
	    root.setDefaultEntry(selectionToolEntry);

	    PaletteSeparator sep2 = new PaletteSeparator();
	    root.add(sep2);
	    PaletteGroup instGroup = new PaletteGroup("Creation of elements");
	    root.add(instGroup);
	    instGroup.add(new CombinedTemplateCreationEntry("Service", "Creation of service model", new NodeCreationFactory(Service.class), null, null));
	    instGroup.add(new CombinedTemplateCreationEntry("Employee", "Creation of employee model", new NodeCreationFactory(Employee.class), null, null));
	    return root;
	}
	
	@Override
	protected void initializePaletteViewer() {
		super.initializePaletteViewer();
		getPaletteViewer().addDragSourceListener(new TemplateTransferDragSourceListener(getPaletteViewer()));
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Nothing
	}

}
