package edu.suda.ide.newWizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import edu.suda.ide.Activator;



public class NewASMproject extends Wizard implements INewWizard{

	/**
	   * The first page of the wizard.
	   */
	  private WizardNewProjectCreationPage page1;

	  /**
	   * The constructor.
	   */
	  public NewASMproject() {
	    super();
	    setWindowTitle("Create a new ASM project");
	  }

	  /**
	   * {@inheritDoc}
	   */
	  public void addPages() {
	    super.addPages();

	    page1 = new WizardNewProjectCreationPage("ASM Project");
	    page1.setTitle("ASM Project");
	    page1.setImageDescriptor(Activator.getImageDescriptor("icons/wizards/newWizard.gif"));
	    page1.setDescription("Create a new ASM project");

	    addPage(page1);
	  }

	  /**
	   * {@inheritDoc}
	   */
	  public boolean performFinish() {
	    try {
	      IProject project = page1.getProjectHandle();

	      project.create(null);
	      project.open(null);
	      
	      //assign a nature  to a project  by updating the
	      //project's description to include the nature
	      
          IProjectDescription description = project.getDescription();
          String[] natures = description.getNatureIds();
          String[] newNatures = new String[natures.length + 1];
          System.arraycopy(natures, 0, newNatures, 0, natures.length);
          newNatures[natures.length] = "edu.suda.ide.nature";
          description.setNatureIds(newNatures);
          project.setDescription(description, null);

	    } catch (CoreException e) {
	      Activator.getDefault().getLog().log(e.getStatus());
	    }
	    return true;
	  }

	  /**
	   * {@inheritDoc}
	   */
	  public void init(IWorkbench workbench, IStructuredSelection selection) {
	  }

}
