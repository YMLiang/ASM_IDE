package edu.suda.ide.ui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveIDE implements IPerspectiveFactory {
		
		
	    public void createInitialLayout(IPageLayout layout) {
	    	layout.addView("edu.suda.ide.projectview", IPageLayout.LEFT, 0.4f, IPageLayout.ID_EDITOR_AREA);
	    }
	}

