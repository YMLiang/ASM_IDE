package edu.suda.ide.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;

import edu.suda.ide.ui.Constants;

/**
 * The Editor class
 * 
 * @author YMLiang
 * 
 */
public class ASMEditor extends TextEditor {

	protected void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new ASMSourceViewerConfiguration(this));
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);

		IDocument document = getDocumentProvider()
				.getDocument(getEditorInput());

		FastPartitioner partitioner = new FastPartitioner(
				new ASMPartitionScanner(),
				new String[] { Constants.PARTITION_STRING,
						Constants.PARTITION_COMMENT });
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
	}

	/**
	 * Refresh the editor.
	 */
	public void refreshSourceViewer() {
		ISourceViewer isv = getSourceViewer();
		if (isv instanceof SourceViewer) {
			((SourceViewer) getSourceViewer()).refresh();
		}
	}

	public void dispose() {
		super.dispose();

		SourceViewerConfiguration svc = getSourceViewerConfiguration();
		if (svc instanceof ASMSourceViewerConfiguration) {
			((ASMSourceViewerConfiguration) svc).dispose();
		}
	}

	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
	}

	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {
		ISourceViewer viewer = new ProjectionViewer(parent, ruler,
				getOverviewRuler(), isOverviewRulerVisible(), styles);

		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);

		viewer.setDefaultPrefixes(new String[] { ";" },
				IDocument.DEFAULT_CONTENT_TYPE);
		viewer.setDefaultPrefixes(new String[] { ";" },
				Constants.PARTITION_COMMENT);

		return viewer;
	}
}
