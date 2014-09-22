package firstgefpro.editor;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;

/**
 * MyTemplateTransferDropTargetListener.java
 * @author Shashwat Anand
 * @version $Id: $
 * @since Sept 22, 2014
 */
public class MyTemplateTransferDropTargetListener extends
		TemplateTransferDropTargetListener {

	public MyTemplateTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer);
	}

}
