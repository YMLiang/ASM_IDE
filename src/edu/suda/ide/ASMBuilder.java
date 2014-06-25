package edu.suda.ide;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class ASMBuilder extends IncrementalProjectBuilder {

	public ASMBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub
		// add your build logic here
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
			fullBuild(monitor);
		} else {
//			IResourceDelta delta = getDelta(getProject());
//			if (delta == null) {
//				fullBuild(monitor);
//			} else {
//				incrementalBuild(delta, monitor);
//			}
		}
		return null;
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new ASMBuildVisitor());
		} catch (CoreException e) {
		}
	}

//	protected void incrementalBuild(IResourceDelta delta,
//			IProgressMonitor monitor) throws CoreException {
//		// the visitor does the work.
//		delta.accept(new ASMBuildDeltaVisitor());
//	}

	protected void startupOnInitialize() {
		// add builder logic here
	}

	protected void clean(IProgressMonitor monitor) {
		// add build clean logic here
	}

	private class ASMBuildVisitor implements IResourceVisitor {
		public boolean visit(IResource res) {
			// build the specified resource.
			// return true to continue visiting children.
			return true;
		}
	}

}
