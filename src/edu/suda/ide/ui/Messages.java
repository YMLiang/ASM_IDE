package edu.suda.ide.ui;

import org.eclipse.osgi.util.NLS;


/**
 * Class which holds the message constants.
 * 
 * @author YMLiang
 * 
 */
public class Messages {
	/**
	 * Name of the message bundle.
	 */
	private static final String BUNDLE_NAME = "edu.suda.ide.messages";

	/**
	   * Name of the string text style.
	   */
	  public static String TEXTCOLOR_STRING_NAME;

	  /**
	   * Name of the comment text style.
	   */
	  public static String TEXTCOLOR_COMMENT_NAME;

	  /**
	   * Name of the instruction text style.
	   */
	  public static String TEXTCOLOR_INSTRUCTION_NAME;

	  /**
	   * Name of the segment text style.
	   */
	  public static String TEXTCOLOR_SEGMENT_NAME;

	  /**
	   * Syntax Highlight Title Text.
	   */
	  public static String SYNTAXHIGHLIGHT_TITLE;

	  /**
	   * Foreground-Color-Text.
	   */
	  public static String FOREGROUNDCOLOR_TEXT;

	  /**
	   * Color-Text.
	   */
	  public static String COLOR_TEXT;

	  /**
	   * Bold-Text.
	   */
	  public static String BOLD_TEXT;

	  /**
	   * Italic-Text.
	   */
	  public static String ITALIC_TEXT;
	
	// Initialize the constants.
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
