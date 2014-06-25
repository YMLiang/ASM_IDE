package edu.suda.ide.newWizards;


import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import edu.suda.ide.Activator;


public class NewASMfile extends Wizard implements INewWizard {
/**
 * The first page of the wizard.
 */
private WizardNewFileCreationPage page1;


private IStructuredSelection selection;

/**
 * The constructor.
 */
public NewASMfile() {
  super();
  setWindowTitle("New a ASM File");
}

/**
 * {@inheritDoc}
 */
public void addPages() {
  super.addPages();

  page1 = new WizardNewFileCreationPage("New a ASM File", selection) {
    protected boolean validatePage() {
      if (!getFileName().toLowerCase().endsWith(".asm")) {
        setErrorMessage("Invalid file name. Must have extension asm. (e.g. test.asm)");
        return false;
      }
      return super.validatePage();
    }
  };
  page1.setTitle("ASM File");
  page1.setImageDescriptor(Activator.getImageDescriptor("icons/newWizard.gif"));
  page1.setDescription("New a ASM File");

  
  addPage(page1);

}

/**
 * {@inheritDoc}
 */
public boolean performFinish() {
 
  IFile file = page1.createNewFile();

  if (file == null) {
    return false;
  }
  return true;
}

/**
 * {@inheritDoc}
 */
public void init(IWorkbench workbench, IStructuredSelection selection) {
  this.selection = selection;
}
}
