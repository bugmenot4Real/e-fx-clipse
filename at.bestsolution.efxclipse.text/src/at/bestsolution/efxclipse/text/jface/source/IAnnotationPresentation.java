package at.bestsolution.efxclipse.text.jface.source;

/**
 * Interface for annotations that can take care of their own visible representation.
 *
 * @since 3.0
 */
public interface IAnnotationPresentation {

	/**
	 * The default annotation layer.
	 */
	static final int DEFAULT_LAYER= 0;


	/**
	 * Returns the annotations drawing layer.
	 *
	 * @return the annotations drawing layer
	 */
	int getLayer();

//	/**
//	 * Implement this method to draw a graphical representation
//	 * of this annotation within the given bounds.
//	 * <p>
//	 * <em>Note that this method is not used when drawing annotations on the editor's
//	 * text widget. This is handled trough a {@link org.eclipse.jface.text.source.AnnotationPainter.IDrawingStrategy}.</em>
//	 * </p>
//	 * @param gc the drawing GC
//	 * @param canvas the canvas to draw on
//	 * @param bounds the bounds inside the canvas to draw on
//	 */
//	void paint(GC gc, Canvas canvas, Rectangle bounds);
}
