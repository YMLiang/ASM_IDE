package edu.suda.ide.editor;

import java.util.ArrayList;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

public class ASMCodeScanner extends RuleBasedScanner {
	private static String[] fgkeywords = { "include", "define", "start_loop",
			"delay_outer", "delay_inner" };
	private static String[] fginstructions = { "loadi", "out", "move", "bne",
			"addi", "cpi" };

	public ASMCodeScanner(ASMColorProvider provider) {

		IToken keyword = new Token(new TextAttribute(
				provider.getColor(ASMColorProvider.KEYWORD)));
		IToken instruction = new Token(new TextAttribute(
				provider.getColor(ASMColorProvider.INSTRUCTION)));
		IToken string = new Token(new TextAttribute(
				provider.getColor(ASMColorProvider.STRING)));
		IToken comment = new Token(new TextAttribute(
				provider.getColor(ASMColorProvider.SINGLE_LINE_COMMENT)));
		IToken other = new Token(new TextAttribute(
				provider.getColor(ASMColorProvider.DEFAULT)));

		ArrayList<IRule> rules = new ArrayList<IRule>();

		// Add rule for single line comments
		rules.add(new EndOfLineRule(";", comment));

		// Add rule for strings
		rules.add(new SingleLineRule("\"", "\"", string, '\\'));
		rules.add(new SingleLineRule("'", "'", string, '\\'));

		// Add generic whitespace rule.
		rules.add(new WhitespaceRule(new MyWhitespaceDetector()));

		// Add word rule for keywords and instructions.
		WordRule wordRule = new WordRule(new MyWordDetector(), other);
		for (int i = 0; i < fgkeywords.length; i++)
			wordRule.addWord(fgkeywords[i], keyword);
		for (int i = 0; i < fginstructions.length; i++)
			wordRule.addWord(fginstructions[i], instruction);
		rules.add(wordRule);

		IRule[] result = new IRule[rules.size()];
		rules.toArray(result);
		setRules(result);
	}
}
