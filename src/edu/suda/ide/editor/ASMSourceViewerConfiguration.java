package edu.suda.ide.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class ASMSourceViewerConfiguration extends SourceViewerConfiguration {

	
	static class SingleTokenScanner extends BufferedRuleBasedScanner {
		public SingleTokenScanner(TextAttribute attribute) {
			setDefaultReturnToken(new Token(attribute));
		}
	}

	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {

		PresentationReconciler reconciler = new PresentationReconciler();
		ASMColorProvider provider = new ASMColorProvider();
		reconciler
				.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(
				new ASMCodeScanner(provider));
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(provider
						.getColor(ASMColorProvider.SINGLE_LINE_COMMENT))));
		reconciler.setDamager(dr, ASMPartitionScanner.SINGLELINE_COMMENT);
		reconciler.setRepairer(dr, ASMPartitionScanner.SINGLELINE_COMMENT);

		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(provider.getColor(ASMColorProvider.STRING))));
		reconciler.setDamager(dr, ASMPartitionScanner.STRING);
		reconciler.setRepairer(dr, ASMPartitionScanner.STRING);

		return reconciler;
	}
}
