package edu.suda.ide;




import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(400, 300));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setTitle("RadioFlex firmwares IDE"); //$NON-NLS-1$
	}

//	public void openIntro() {
//		IWorkbenchWindow window = (IWorkbenchWindow) PlatformUI.getWorkbench()
//				.getActiveWorkbenchWindow();
//		if (window instanceof WorkbenchWindow) {
//			MWindow model = ((WorkbenchWindow) window).getModel();
//			EModelService modelService = model.getContext().get(
//					EModelService.class);
//			MToolControl searchField = (MToolControl) modelService.find(
//					"SearchField", model);
//			if (searchField != null) {
//				searchField.setToBeRendered(false);
//				MTrimBar trimBar = modelService.getTrim((MTrimmedWindow) model,
//						SideValue.TOP);
//				trimBar.getChildren().remove(searchField);
//			}
//		}
//	}

}
