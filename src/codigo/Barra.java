package codigo;

import java.awt.Color;

import acm.graphics.GRect;
/**
 * 
 * @author Gonzalo Sáez Martí
 * 
 * La clase Barra es la que dibuja el cursor del juego
 */
public class Barra extends GRect{
	/**
	 * Crea el cursor del juego
	 * @param width -> El ancho del cursor
	 * @param height -> El alto del cursor
	 * @param _color -> Color del cursor
	 */
	public Barra(double width, double height, Color _color) {
		super(width, height);
		setFilled(true);
		setFillColor(_color);
	}
	/**
	 * mueveBarra reposiciona la barra en la coordenada
	 * en la que está el ratón
	 * @param posX la posición X del ratón. La Y la obtiene de la propia barra
	 * @param anchoPantalla porque así mo tengo que pasar nada más.
	 */
	public void mueveBarra(int posX, int anchoPantalla){
		if(posX + getWidth() < anchoPantalla){
			setLocation(posX, getY());
		}
	}

}
