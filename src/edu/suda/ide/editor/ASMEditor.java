package edu.suda.ide.editor;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

public class ASMEditor extends TextEditor {
	public ASMEditor() {
		setDocumentProvider(new TextFileDocumentProvider());
	}

	protected void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new ASMSourceViewerConfiguration(this));
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
}
