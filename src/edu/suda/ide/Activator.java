package edu.suda.ide;

import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import edu.suda.ide.ui.Constants;
import edu.suda.ide.ui.TextAttributeConverter;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		super();
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(Constants.PLUGIN_ID, path);
	}

	/**
	 * Returns the absolute path of a entry from the plugin's directory.
	 * 
	 * @param entry
	 *            a file or directory (don't use "dir1\dir2" or "dir1\file1")
	 * @return Returns the path from the plug-in.
	 */
	public static String getFilePathFromPlugin(String entry) {
		URL url = null;
		IPath path = null;
		String result = "";

		Enumeration<URL> enu = Activator.getDefault().getBundle()
				.findEntries("/", entry, true);
		if (enu.hasMoreElements()) {
			url = (URL) enu.nextElement();
		}

		if (url == null) {
			return "";
		}

		try {
			path = new Path(FileLocator.toFileURL(url).getPath());
			result = path.makeAbsolute().toOSString();
		} catch (Exception e) {
			result = "";
		}

		return result;
	}

	protected void initializeDefaultPreferences(IPreferenceStore store) {
	    Display display = Display.getCurrent();

	    String textAttribute = TextAttributeConverter.textAttributesToPreferenceData(new Color(display, 0, 0, 255), false,
	                                                                                 false);
	    store.setDefault(Constants.PREFERENCES_TEXTCOLOR_STRING, textAttribute);

	    textAttribute = TextAttributeConverter.textAttributesToPreferenceData(new Color(display, 0, 128, 0), false, true);
	    store.setDefault(Constants.PREFERENCES_TEXTCOLOR_COMMENT, textAttribute);

	    textAttribute = TextAttributeConverter.textAttributesToPreferenceData(new Color(display, 0, 0, 128), true, false);
	    store.setDefault(Constants.PREFERENCES_TEXTCOLOR_INSTRUCTION, textAttribute);

	    textAttribute = TextAttributeConverter.textAttributesToPreferenceData(new Color(display, 128, 64, 0), true, false);
	    store.setDefault(Constants.PREFERENCES_TEXTCOLOR_SEGMENT, textAttribute);

	}

}
