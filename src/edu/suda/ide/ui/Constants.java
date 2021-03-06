package edu.suda.ide.ui;

import org.eclipse.jface.resource.ImageDescriptor;

import edu.suda.ide.Activator;

/**
 * Class which holds several constants.
 * 
 * @author YMLiang
 * 
 */
public class Constants {

	// Important IDs
	/**
	 * The Plug-in ID.
	 */
	public static final String PLUGIN_ID = "edu.suda.ide";
	
	/**
	 * The IDE perspective ID.
	 */
	public static final String IDE_PERSPECTIVE_ID = PLUGIN_ID + ".perspective.rcp";
	/**
	 * The Nature ID.
	 */
	public static final String NATURE_ID = "edu.suda.ide.nature";

	/**
	 * The Build ID.
	 */
	public static final String BUILDER_ID = "edu.suda.ide.builder";

	/**
	 * Preference key for string text style preference keys.
	 */
	public static final String PREFERENCES_TEXTCOLOR_STRING = "preferences.textcolor.string"; //$NON-NLS-1$

	/**
	 * Preference key for comment text style preference keys.
	 */
	public static final String PREFERENCES_TEXTCOLOR_COMMENT = "preferences.textcolor.comment"; //$NON-NLS-1$

	/**
	 * Preference key for instruction text style preference keys.
	 */
	public static final String PREFERENCES_TEXTCOLOR_INSTRUCTION = "preferences.textcolor.instruction"; //$NON-NLS-1$

	/**
	 * Preference key for segment text style preference keys.
	 */
	public static final String PREFERENCES_TEXTCOLOR_SEGMENT = "preferences.textcolor.segment"; //$NON-NLS-1$

	/**
	 * Name for the string partition.
	 */
	public static final String PARTITION_STRING = "partion.string";

	/**
	 * Name for the single line comment partition.
	 */
	public static final String PARTITION_COMMENT = "partion.comment";

	/**
	 * Icon for the new wizard.
	 */
	public static final ImageDescriptor WIZARD_NEW = Activator
			.getImageDescriptor("icons/newWizard.gif");
}
