package edu.suda.ide.editor;

import java.util.ArrayList;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class ASMPartitionScanner extends RuleBasedPartitionScanner {
	//string constants for different partition types
	public final static String SINGLELINE_COMMENT="singleline_comment";
	public final static String STRING="string";
	public final static String[] PARTITION_TYPES=new String[]{SINGLELINE_COMMENT,STRING};
	
	/**
	 * Creates  the partitioner and set up the appropriate rules
 	 */
	public ASMPartitionScanner(){
		super();

		IToken singlelinecomment = new Token(SINGLELINE_COMMENT);
		IToken string = new Token(STRING);
		
		ArrayList<IRule> rules = new ArrayList<IRule>();
		
		//Add rule for single line comments
		rules.add(new EndOfLineRule(";", singlelinecomment));
		
		//Add rule for strings and character constants
		rules.add(new SingleLineRule("\"", "\"", string));
		rules.add(new SingleLineRule("'", "'", string));

		 IPredicateRule[] result= new IPredicateRule[rules.size()]; 
		 rules.toArray(result); 
		 setPredicateRules(result);
	}
}
