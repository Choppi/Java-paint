/**
 * 
 */
package filters;

import java.awt.Paint;

import figures.Figure;

/**
 * Filtre filtrant les figures possédant une certaine couleur de trait
 * @author davidroussel
 */
public class EdgeColorFilter extends FigureFilter<Paint>
{
	
	public EdgeColorFilter(Paint p) {
		this.element = p;
	}
	
	public boolean test(Figure f) {
		return this.getElement().equals(f.getEdgePaint());
	}
}
