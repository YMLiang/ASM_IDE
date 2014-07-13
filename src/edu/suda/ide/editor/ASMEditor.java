package edu.suda.ide.editor;

import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;


public class ASMEditor extends TextEditor {
	public ASMEditor() {
		setDocumentProvider(new TextFileDocumentProvider());
	}

	protected void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new ASMSourceViewerConfiguration());
	}
}
