package at.bestsolution.efxclipse.tooling.pde.e4.project.media.tpl.parts;

import at.bestsolution.efxclipse.tooling.rrobot.model.task.CompilationUnit;
import at.bestsolution.efxclipse.tooling.rrobot.model.task.DynamicFile;
import at.bestsolution.efxclipse.tooling.rrobot.model.task.Generator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MediaListPartTpl implements Generator<DynamicFile> {
  public InputStream generate(final DynamicFile file, final Map<String,Object> data) {
    EObject _eContainer = file.eContainer();
    final CompilationUnit cu = ((CompilationUnit) _eContainer);
    String _packagename = cu.getPackagename();
    String _packagename_1 = cu.getPackagename();
    int _lastIndexOf = _packagename_1.lastIndexOf(".");
    final String rootPackage = _packagename.substring(0, _lastIndexOf);
    String _packagename_2 = cu.getPackagename();
    String _packagename_3 = cu.getPackagename();
    int _lastIndexOf_1 = _packagename_3.lastIndexOf(".");
    String _substring = _packagename_2.substring(0, _lastIndexOf_1);
    final String modelPackage = (_substring + ".model");
    String _packagename_4 = cu.getPackagename();
    String _packagename_5 = cu.getPackagename();
    int _lastIndexOf_2 = _packagename_5.lastIndexOf(".");
    String _substring_1 = _packagename_4.substring(0, _lastIndexOf_2);
    final String handlersPackage = (_substring_1 + ".handlers");
    String _packagename_6 = cu.getPackagename();
    String _packagename_7 = cu.getPackagename();
    int _lastIndexOf_3 = _packagename_7.lastIndexOf(".");
    String _substring_2 = _packagename_6.substring(0, _lastIndexOf_3);
    final String partsPackage = (_substring_2 + ".parts");
    String _packagename_8 = cu.getPackagename();
    CharSequence _generate = this.generate(rootPackage, _packagename_8, modelPackage, handlersPackage, partsPackage);
    String _string = _generate.toString();
    byte[] _bytes = _string.getBytes();
    ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
    return _byteArrayInputStream;
  }
  
  public CharSequence generate(final String rootPackage, final String packageName, final String modelPackage, final String handlersPackage, final String partsPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javafx.collections.FXCollections;");
    _builder.newLine();
    _builder.append("import javafx.collections.ObservableList;");
    _builder.newLine();
    _builder.append("import javafx.event.EventHandler;");
    _builder.newLine();
    _builder.append("import javafx.scene.control.ListCell;");
    _builder.newLine();
    _builder.append("import javafx.scene.control.ListView;");
    _builder.newLine();
    _builder.append("import javafx.scene.image.ImageView;");
    _builder.newLine();
    _builder.append("import javafx.scene.input.MouseEvent;");
    _builder.newLine();
    _builder.append("import javafx.scene.layout.BorderPane;");
    _builder.newLine();
    _builder.append("import javafx.util.Callback;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.annotation.PostConstruct;");
    _builder.newLine();
    _builder.append("import javax.inject.Inject;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.e4.core.di.annotations.Optional;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.di.Focus;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.di.UIEventTopic;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.model.application.MApplication;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.model.application.ui.basic.MPart;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.workbench.modeling.EModelService;");
    _builder.newLine();
    _builder.append("import org.eclipse.e4.ui.workbench.modeling.EPartService;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(handlersPackage, "");
    _builder.append(".OpenHandler;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(modelPackage, "");
    _builder.append(".Media;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(modelPackage, "");
    _builder.append(".MediaType;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"restriction\")");
    _builder.newLine();
    _builder.append("public class MediaListPart {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class MediaCell extends ListCell<Media> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected void updateItem(Media item, boolean empty) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if(  ! empty && item != null ) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("setText(item.getName());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("switch (item.getType()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("case MOVIE:");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("setGraphic(new ImageView(\"platform:/plugin/");
    _builder.append(rootPackage, "					");
    _builder.append("/icons/kaffeine.png\"));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("case PICTURE:");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("setGraphic(new ImageView(\"platform:/plugin/");
    _builder.append(rootPackage, "					");
    _builder.append("/icons/games-config-background.png\"));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("setGraphic(new ImageView(\"platform:/plugin/");
    _builder.append(rootPackage, "					");
    _builder.append("/icons/player-volume.png\"));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super.updateItem(item, empty);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EPartService partService;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EModelService modelService;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("MApplication application;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ListView<Media> list;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PostConstruct");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void init(BorderPane pane) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list = new ListView<Media>(createList());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.setId(\"mediaList\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.setCellFactory(new Callback<ListView<Media>, ListCell<Media>>() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public ListCell<Media> call(ListView<Media> param) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return new MediaCell();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.setOnMouseClicked(new EventHandler<MouseEvent>() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public void handle(MouseEvent event) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if( event.getClickCount() > 1 ) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("handleOpen();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pane.setCenter(list);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void handleOpen() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MPartStack stack = (MPartStack) modelService.find(\"content.stack\", application);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Media m = list.getSelectionModel().getSelectedItem();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String instance = Media.serialize(m);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for( MStackElement e : stack.getChildren() ) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if( e instanceof MPart ) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if( instance.equals(e.getPersistedState().get(MediaPart.MEDIA_OBJECT_KEY)) ) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("partService.activate((MPart) e);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MPart p = MBasicFactory.INSTANCE.createPart();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p.setLabel(m.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if( m.getType() == MediaType.MOVIE ) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("p.setIconURI(\"platform:/plugin/");
    _builder.append(rootPackage, "			");
    _builder.append("/icons/22/kaffeine.png\");\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("} else if( m.getType() == MediaType.PICTURE ) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("p.setIconURI(\"platform:/plugin/");
    _builder.append(rootPackage, "			");
    _builder.append("/icons/22/games-config-background.png\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("p.setIconURI(\"platform:/plugin/");
    _builder.append(rootPackage, "			");
    _builder.append("/icons/22/player-volume.png\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p.setContributionURI(\"bundleclass://");
    _builder.append(rootPackage, "		");
    _builder.append("/");
    _builder.append(partsPackage, "		");
    _builder.append(".MediaPart\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("p.getPersistedState().put(MediaPart.MEDIA_OBJECT_KEY, instance);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("stack.getChildren().add(p);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("partService.activate(p,true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Focus");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void focus() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.requestFocus();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Optional");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void openMedia(@UIEventTopic(OpenHandler.OPEN_EVENT) String event) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handleOpen();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static ObservableList<Media> createList() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ObservableList<Media> l = FXCollections.observableArrayList();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("l.add(new Media(MediaType.PICTURE, \"Desert\",     \"platform:/plugin/");
    _builder.append(rootPackage, "		");
    _builder.append("/icons/resources/pics/pic1.jpg\"));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("l.add(new Media(MediaType.PICTURE, \"Lighthouse\", \"platform:/plugin/");
    _builder.append(rootPackage, "		");
    _builder.append("/icons/resources/pics/pic2.jpg\"));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("l.add(new Media(MediaType.MOVIE,   \"Grog\",       \"platform:/plugin/");
    _builder.append(rootPackage, "		");
    _builder.append("/icons/resources/movs/mov1.flv\"));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("l.add(new Media(MediaType.MOVIE,   \"OTN\",        \"http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv\"));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return l;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
