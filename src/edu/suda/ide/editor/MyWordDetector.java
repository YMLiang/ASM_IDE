package edu.suda.ide.editor;

import org.eclipse.jface.text.rules.IWordDetector;

public class MyWordDetector implements IWordDetector {

	public boolean isWordPart(char character) {
		return Character.isJavaIdentifierPart(character);
	}

	public boolean isWordStart(char character) {
		return Character.isJavaIdentifierStart(character);
	}
}
