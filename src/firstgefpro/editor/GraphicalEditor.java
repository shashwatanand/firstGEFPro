package firstgefpro.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
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
import firstgefpro.model.Entreprise;
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


	private Entreprise createEntreprise() {
	    Entreprise psyEntreprise = new Entreprise();
	    psyEntreprise.setName("Psykokwak Entreprise");
	    psyEntreprise.setAddress("Quelque part sur terre");
	    psyEntreprise.setCapital(100000);

	    Service comptaService = new Service();
	    comptaService.setName("Compta");
	    comptaService.setEtage(2);
	    comptaService.setLayout(new Rectangle(30, 50, 250, 150));
	    Employee employeCat = new Employee();
	    employeCat.setName("Debroua");
	    employeCat.setLastName("Cat");
	    employeCat.setLayout(new Rectangle(25, 40, 60, 40));
	    comptaService.addChild(employeCat);
	    Employee employeJyce = new Employee();
	    employeJyce.setName("Psykokwak");
	    employeJyce.setLastName("Jyce");
	    employeJyce.setLayout(new Rectangle(100, 60, 60, 40));
	    comptaService.addChild(employeJyce);
	    Employee employeEva = new Employee();
	    employeEva.setName("Longoria");
	    employeEva.setLastName("Eva");
	    employeEva.setLayout(new Rectangle(180, 90, 60, 40));
	    comptaService.addChild(employeEva);
	    psyEntreprise.addChild(comptaService);
	    Service rhService = new Service();
	    rhService.setName("Ressources Humaine");
	    rhService.setEtage(1);
	    rhService.setLayout(new Rectangle(220, 230, 250, 150));
	    Employee employePaul = new Employee();
	    employePaul.setName("Dupond");
	    employePaul.setLastName("Paul");
	    employePaul.setLayout(new Rectangle(40, 70, 60, 40));
	    rhService.addChild(employePaul);
	    Employee employeEric = new Employee();
	    employeEric.setName("Durand");
	    employeEric.setLastName("Eric");
	    employeEric.setLayout(new Rectangle(170, 100, 60, 40));
	    rhService.addChild(employeEric);
	    psyEntreprise.addChild(rhService);

	    return psyEntreprise;
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
