package edu.suda.ide.editor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ASMColorProvider {
		public static final RGB SINGLE_LINE_COMMENT= new RGB(139, 0, 255);
		public static final RGB KEYWORD= new RGB(0, 0, 255);
		public static final RGB INSTRUCTION=new RGB(255,0,0);
		public static final RGB STRING= new RGB(0, 128, 0);
		public static final RGB DEFAULT= new RGB(0, 0, 0);
		
		protected Map<RGB, Color> fColorTable= new HashMap<RGB, Color>(5);

		public void dispose() {
			Iterator<Color> e= fColorTable.values().iterator();
			while (e.hasNext())
				 ((Color) e.next()).dispose();
		}
		
		public Color getColor(RGB rgb) {
			Color color= (Color) fColorTable.get(rgb);
			if (color == null) {
				color= new Color(Display.getCurrent(), rgb);
				fColorTable.put(rgb, color);
			}
			return color;
		}
}
