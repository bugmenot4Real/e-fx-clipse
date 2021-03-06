package at.bestsolution.efxclipse.tooling.pde.e4.project.media.tpl.handlers

import at.bestsolution.efxclipse.tooling.rrobot.model.task.Generator
import at.bestsolution.efxclipse.tooling.rrobot.model.task.DynamicFile
import java.util.Map
import at.bestsolution.efxclipse.tooling.rrobot.model.task.CompilationUnit
import java.io.ByteArrayInputStream

class OpenHandlerTpl implements Generator<DynamicFile> {

	override generate(DynamicFile file, Map<String,Object> data) {
		val cu = file.eContainer as CompilationUnit;
		return new ByteArrayInputStream(generate(cu.packagename).toString.bytes);
	}
	
	def generate(String packageName) '''package «packageName»;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;

@SuppressWarnings("restriction")
public class OpenHandler {
	public static final String OPEN_EVENT = "media/open";
	@Execute
	public void execute(IEventBroker broker)
			throws InvocationTargetException, InterruptedException {
		broker.send(OPEN_EVENT, UUID.randomUUID().toString());
	}
}'''
}