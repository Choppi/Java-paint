package filters;

import figures.Figure;
import figures.enums.FigureType;

/**
 * Filtre de figure appliqué au type de figure
 * @author davidroussel
 */
public class ShapeFilter extends FigureFilter<FigureType>
{
	
	public ShapeFilter(FigureType type) {
		this.element = type;		
	}
		
	public boolean test(Figure f) {
		return this.getElement().equals(f.getShape());
	}
}
