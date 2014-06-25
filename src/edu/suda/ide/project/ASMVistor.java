package edu.suda.ide.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;

import edu.suda.ide.Activator;

public class ASMVistor implements IResourceProxyVisitor, IResourceDeltaVisitor {
	public boolean visit(IResourceProxy proxy) throws CoreException {
		String name = proxy.getName();
		if (name != null && name.endsWith(".asm")) {
			// found a source file
			// System.out.println("Processing " + name);
			processResource(proxy.requestResource());

		}
		return true;
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		return true;
	}

	private void processResource(IResource resource) throws CoreException {
		if (resource instanceof IFile) {
			try {
				IFile file = (IFile) resource;
				InputStream in = file.getContents();
				ASMTranslator.convert(new InputStreamReader(in),
						new OutputStreamWriter(System.out));
			} catch (IOException e) {
				throw new CoreException(new Status(Status.ERROR,
						Activator.PLUGIN_ID, "Failed to generate resource", e));
			}
		}
	}
}
