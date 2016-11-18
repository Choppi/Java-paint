package widgets;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Paint;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import figures.Figure;
import figures.enums.FigureType;
import figures.enums.LineType;
import utils.IconFactory;
import utils.PaintFactory;

import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel
{
	/**
	 * Une chaine vide pour remplir les champs lorsque la souris n'est au dessus
	 * d'aucune figure
	 */
	private static final String emptyString = new String();

	/**
	 * Une icône vide pour remplir les chanmps avec icône lorsque la souris
	 * n'est au dessus d'aucune figure
	 */
	private static final ImageIcon emptyIcon = IconFactory.getIcon("None");

	/**
	 * Le formatteur à  utiliser pour formater les coordonnés
	 */
	private final static DecimalFormat coordFormat = new DecimalFormat("000");

	/**
	 * Le label contenant le nom de la figure
	 */
	private JLabel lblFigureName;
	
	/**
	 * Le label contenant l'icône correspondant à  la figure
	 */
	private JLabel lblTypeicon;
	
	/**
	 * La map contenant les différentes icônes des types de figures
	 */
	private Map<FigureType, ImageIcon> figureIcons;
	
	/**
	 * Le label contenant l'icône de la couleur de remplissage
	 */
	private JLabel lblFillcolor;
	
	/**
	 * Le label contenant l'icône de la couleur du contour
	 */
	private JLabel lblEdgecolor;
	
	/**
	 * Map contenant les icônes relatives aux différentes couleurs (de contour
	 * ou de remplissage)
	 */
	private Map<Paint, ImageIcon> paintIcons;
	
	/**
	 * Le label contenant le type de contour
	 */
	private JLabel lblStroketype;
	
	/**
	 * Map contenant les icônes relatives au différents types de traits de 
	 * contour
	 */
	private Map<LineType, ImageIcon> lineTypeIcons;
	
	/**
	 * Le label contenant l'abcisse du point en haut à  gauche de la figure
	 */
	private JLabel lblTlx;
	
	/**
	 * Le label contenant l'ordonnée du point en haut à  gauche de la figure
	 */
	private JLabel lblTly;

	/**
	 * Le label contenant l'abcisse du point en bas à  droite de la figure
	 */
	private JLabel lblBrx;

	/**
	 * Le label contenant l'ordonnée du point en bas à  droite de la figure
	 */
	private JLabel lblBry;

	/**
	 * Le label contenant la largeur de la figure
	 */
	private JLabel lblDx;

	/**
	 * Le label contenant la hauteur de la figure
	 */
	private JLabel lblDy;

	/**
	 * Le label contenant l'abcisse du barycentre de la figure
	 */
	private JLabel lblCx;

	/**
	 * Le label contenant l'ordonnée du barycentre de la figure
	 */
	private JLabel lblCy;
	
	/**
	 * Create the panel.
	 */
	public InfoPanel()
	{
		// --------------------------------------------------------------------
		// Initialisation des maps
		// --------------------------------------------------------------------
		figureIcons = new HashMap<FigureType, ImageIcon>();
		// Remplissage de figureIcons en utilisant l'IconFactory
		
		for (FigureType type : FigureType.values()) {
			  figureIcons.put(type, IconFactory.getIcon(type.toString()));
		}

		paintIcons = new HashMap<Paint, ImageIcon>();
		String[] colorStrings = {
			"Black",
			"Blue",
			"Cyan",
			"Green",
			"Magenta",
			"None",
			"Orange",
			"Others",
			"Red",
			"White",
			"Yellow"
		};

		/*
		 * Obtention des paints par la PaintFactory, puis
		 * Obtention des icônes correspondant aux paints avec l'IconFactory
		 * pour remplir paintIcons
		 */
		
		for (String str : colorStrings) {
			Paint p = PaintFactory.getPaint(str);
			paintIcons.put(p, IconFactory.getIcon(str));
		}
		
		lineTypeIcons = new HashMap<LineType, ImageIcon>();
		
		/*
		 * Remplissage de lineTypeIcons avec l'IconFactory pour chaque
		 * type de lignes
		 */
		
		for (LineType type : LineType.values()) {
			lineTypeIcons.put(type, IconFactory.getIcon(type.toString()));
		}
		
		// --------------------------------------------------------------------
		// Création de l'UI
		// --------------------------------------------------------------------
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {80, 60, 60};
		gridBagLayout.rowHeights = new int[] {30, 32, 32, 32, 20, 20, 20, 20, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		lblFigureName = new JLabel();
		GridBagConstraints gbc_lblFigureName = new GridBagConstraints();
		gbc_lblFigureName.gridwidth = 2;
		gbc_lblFigureName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFigureName.gridx = 0;
		gbc_lblFigureName.gridy = 0;
		add(lblFigureName, gbc_lblFigureName);
		
		JLabel lblType = new JLabel("type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 1;
		add(lblType, gbc_lblType);
		
		lblTypeicon = new JLabel();
		GridBagConstraints gbc_lblTypeicon = new GridBagConstraints();
		gbc_lblTypeicon.gridwidth = 2;
		gbc_lblTypeicon.insets = new Insets(0, 0, 5, 0);
		gbc_lblTypeicon.gridx = 1;
		gbc_lblTypeicon.gridy = 1;
		add(lblTypeicon, gbc_lblTypeicon);
		
		JLabel lblFill = new JLabel("fill");
		GridBagConstraints gbc_lblFill = new GridBagConstraints();
		gbc_lblFill.insets = new Insets(0, 0, 5, 5);
		gbc_lblFill.gridx = 0;
		gbc_lblFill.gridy = 2;
		add(lblFill, gbc_lblFill);
		
		lblFillcolor = new JLabel();
		GridBagConstraints gbc_lblFillcolor = new GridBagConstraints();
		gbc_lblFillcolor.gridwidth = 2;
		gbc_lblFillcolor.insets = new Insets(0, 0, 5, 0);
		gbc_lblFillcolor.gridx = 1;
		gbc_lblFillcolor.gridy = 2;
		add(lblFillcolor, gbc_lblFillcolor);
		
		JLabel lblStroke = new JLabel("stroke");
		GridBagConstraints gbc_lblStroke = new GridBagConstraints();
		gbc_lblStroke.insets = new Insets(0, 0, 5, 5);
		gbc_lblStroke.gridx = 0;
		gbc_lblStroke.gridy = 3;
		add(lblStroke, gbc_lblStroke);
		
		lblEdgecolor = new JLabel();
		GridBagConstraints gbc_lblEdgecolor = new GridBagConstraints();
		gbc_lblEdgecolor.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdgecolor.gridx = 1;
		gbc_lblEdgecolor.gridy = 3;
		add(lblEdgecolor, gbc_lblEdgecolor);
		
		lblStroketype = new JLabel();
		GridBagConstraints gbc_lblStroketype = new GridBagConstraints();
		gbc_lblStroketype.insets = new Insets(0, 0, 5, 0);
		gbc_lblStroketype.gridx = 2;
		gbc_lblStroketype.gridy = 3;
		add(lblStroketype, gbc_lblStroketype);
		
		JLabel lblX = new JLabel("x");
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 1;
		gbc_lblX.gridy = 4;
		add(lblX, gbc_lblX);
		
		JLabel lblY = new JLabel("y");
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 5, 0);
		gbc_lblY.gridx = 2;
		gbc_lblY.gridy = 4;
		add(lblY, gbc_lblY);
		
		JLabel lblTopLeft = new JLabel("top left");
		GridBagConstraints gbc_lblTopLeft = new GridBagConstraints();
		gbc_lblTopLeft.insets = new Insets(0, 0, 5, 5);
		gbc_lblTopLeft.gridx = 0;
		gbc_lblTopLeft.gridy = 5;
		add(lblTopLeft, gbc_lblTopLeft);
		
		lblTlx = new JLabel();
		GridBagConstraints gbc_lblTlx = new GridBagConstraints();
		gbc_lblTlx.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlx.gridx = 1;
		gbc_lblTlx.gridy = 5;
		add(lblTlx, gbc_lblTlx);
		
		lblTly = new JLabel();
		GridBagConstraints gbc_lblTly = new GridBagConstraints();
		gbc_lblTly.insets = new Insets(0, 0, 5, 0);
		gbc_lblTly.gridx = 2;
		gbc_lblTly.gridy = 5;
		add(lblTly, gbc_lblTly);
		
		JLabel lblBottomRight = new JLabel("bottom right");
		GridBagConstraints gbc_lblBottomRight = new GridBagConstraints();
		gbc_lblBottomRight.insets = new Insets(0, 0, 5, 5);
		gbc_lblBottomRight.gridx = 0;
		gbc_lblBottomRight.gridy = 6;
		add(lblBottomRight, gbc_lblBottomRight);
		
		lblBrx = new JLabel();
		GridBagConstraints gbc_lblBrx = new GridBagConstraints();
		gbc_lblBrx.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrx.gridx = 1;
		gbc_lblBrx.gridy = 6;
		add(lblBrx, gbc_lblBrx);
		
		lblBry = new JLabel();
		GridBagConstraints gbc_lblBry = new GridBagConstraints();
		gbc_lblBry.insets = new Insets(0, 0, 5, 0);
		gbc_lblBry.gridx = 2;
		gbc_lblBry.gridy = 6;
		add(lblBry, gbc_lblBry);
		
		JLabel lblDimensions = new JLabel("dimensions");
		GridBagConstraints gbc_lblDimensions = new GridBagConstraints();
		gbc_lblDimensions.insets = new Insets(0, 0, 5, 5);
		gbc_lblDimensions.gridx = 0;
		gbc_lblDimensions.gridy = 7;
		add(lblDimensions, gbc_lblDimensions);
		
		lblDx = new JLabel();
		GridBagConstraints gbc_lblDx = new GridBagConstraints();
		gbc_lblDx.insets = new Insets(0, 0, 5, 5);
		gbc_lblDx.gridx = 1;
		gbc_lblDx.gridy = 7;
		add(lblDx, gbc_lblDx);
		
		lblDy = new JLabel();
		GridBagConstraints gbc_lblDy = new GridBagConstraints();
		gbc_lblDy.insets = new Insets(0, 0, 5, 0);
		gbc_lblDy.gridx = 2;
		gbc_lblDy.gridy = 7;
		add(lblDy, gbc_lblDy);
		
		JLabel lblCenter = new JLabel("center");
		GridBagConstraints gbc_lblCenter = new GridBagConstraints();
		gbc_lblCenter.insets = new Insets(0, 0, 0, 5);
		gbc_lblCenter.gridx = 0;
		gbc_lblCenter.gridy = 8;
		add(lblCenter, gbc_lblCenter);
		
		lblCx = new JLabel();
		GridBagConstraints gbc_lblCx = new GridBagConstraints();
		gbc_lblCx.insets = new Insets(0, 0, 0, 5);
		gbc_lblCx.gridx = 1;
		gbc_lblCx.gridy = 8;
		add(lblCx, gbc_lblCx);
		
		lblCy = new JLabel();
		GridBagConstraints gbc_lblCy = new GridBagConstraints();
		gbc_lblCy.gridx = 2;
		gbc_lblCy.gridy = 8;
		add(lblCy, gbc_lblCy);
		
		resetLabels();

	}

	/**
	 * Mise à  jour de tous les labels avec les informations de figure
	 * @param figure la figure dont il faut extraire les informations
	 */
	public void updateLabels(Figure figure)
	{
		// MAJ titre de la figure
		
		lblFigureName.setText(figure.getName());
		
		// MAJ Icône du type de figure
		
		lblTypeicon.setIcon(figureIcons.get(figure.getType()));
		
		// MAJ Icône de la couleur de remplissage
		
		Paint p = figure.getFillPaint();
		
		if (p == null) // None color
			lblFillcolor.setIcon(emptyIcon);
		else {
			if (!paintIcons.containsKey(p))
				p = null; // Other color
				
			lblFillcolor.setIcon(paintIcons.get(p));
		}
		
		// MAJ Icône de la couleur de trait
		
		p = figure.getEdgePaint();
		if (!paintIcons.containsKey(p))
			p = null; // Other color
		
		lblEdgecolor.setIcon(paintIcons.get(p));
		
		// MAJ Icône du type de trait
		
		lblStroketype.setIcon(lineTypeIcons.get(LineType.fromStroke(figure.getStroke())));
		
		/*
		 * MAJ Données numériques de la figure en utilisant les méthodes
		 * de la classe Figure
		 * 	- Top left corner x & y
		 * 	- Bottom right corner ...
		 * 	- Dimensions ...
		 * 	- Center ...
		 */

		/*
		 * Formmattage des données numérique avec coordFormat pour mette
		 *   jour les différents label avec les nouvelles valeurs numériques
		 */
		
		lblCx.setText(coordFormat.format(figure.getCenter().getX()));
		lblCy.setText(coordFormat.format(figure.getCenter().getY()));
		
		lblTlx.setText(coordFormat.format(figure.getBounds2D().getX()));
		lblTly.setText(coordFormat.format(figure.getBounds2D().getY()));
		
		lblBrx.setText(coordFormat.format(figure.getBounds2D().getX() + figure.getBounds2D().getWidth()));
		lblBry.setText(coordFormat.format(figure.getBounds2D().getY() + figure.getBounds2D().getHeight()));
		
		lblDx.setText(coordFormat.format(figure.getBounds2D().getWidth()));
		lblDy.setText(coordFormat.format(figure.getBounds2D().getHeight()));
	}

	/**
	 * Effacement de tous les labels	 
	 */
	public void resetLabels()
	{
		// RAZ titre de la figure
		
		lblFigureName.setText(emptyString);
		
		// RAZ Icône du type de figure
		
		lblTypeicon.setIcon(emptyIcon);
		
		// RAZ Icône de la couleur de remplissage
		
		lblFillcolor.setIcon(emptyIcon);
		
		// RAZ Icône de la couleur de trait
		
		lblEdgecolor.setIcon(emptyIcon);
		
		// RAZ Icône du type de trait
		
		lblStroketype.setIcon(emptyIcon);
		
		// RAZ Données numériques
		
		lblCx.setText(emptyString);
		lblCy.setText(emptyString);
		
		lblTlx.setText(emptyString);
		lblTly.setText(emptyString);
		
		lblBrx.setText(emptyString);
		lblBry.setText(emptyString);
		
		lblDx.setText(emptyString);
		lblDy.setText(emptyString);
		
	}
}
