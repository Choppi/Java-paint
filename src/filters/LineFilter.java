package filters;

import figures.Figure;
import figures.enums.LineType;

/**
 * Filtre filtrant les figures ayant un certain type de trait
 * @author davidroussel
 */
public class LineFilter extends FigureFilter<LineType>
{
	
	public LineFilter(LineType type) {
		this.element = type;
		
	}
	public boolean test(Figure f) {
		return this.getElement().equals(f.getStroke());
	}
}
