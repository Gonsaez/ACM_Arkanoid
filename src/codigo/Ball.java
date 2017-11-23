package codigo;
/*
 * Autor: Gonzalo Sáez Martí
 * 
 * La clase Ball es la que vamos a utilizar para
 * el juego del arkanoid
 * Tiene dos constructores
 */
import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Ball extends GOval{

	double xVelocidad = 1; //Velocidad de la bola en el eje X
	double yVelocidad = -1; //Velocidad de la bola en el eje Y



	/**
	 * Este es el constructor básico, que es idéntico al de la clase GOval
	 * @param _ancho
	 * @param _alto
	 */
	public Ball(double _ancho, double _alto){
		super(_ancho, _alto);
	}
	/**
	 * Este es el constructor dabuti que permite
	 * pasar el color como parámetro
	 * @param _ancho indica el ancho y el alto de la bola
	 * @param _color
	 */
	public Ball(double _ancho, Color _color){
		super(_ancho, _ancho);
		if(_ancho <=0){
			this.setSize(1,1);
		}
		this.setFillColor(_color);
		this.setFilled(true);
	}
	/**
	 * se encarga de mover a la pelota y chequear si ha habido colisión
	 */
	public void muevete(Arkanoid _arkanoid){
		if(this.getX() + this.getWidth() >= _arkanoid.getWidth() || this.getX() <0){
			xVelocidad *= -1;
		}
		if(this.getY() <0){
			yVelocidad *= -1;
		}
		if(chequeacolision(getX(), getY(), _arkanoid)){ //Chequea la esquina superior izquierda
			if(chequeacolision(getX() + getWidth(), getY(), _arkanoid)){ //Chequea la esquina superior derecha
				if(chequeacolision(getX(), getY() + getHeight(), _arkanoid)){ //Chequea la esquina inferior izquierda
					if(chequeacolision(getX() + getWidth(), getY() + getHeight(), _arkanoid)){ //Chequea la esquina inferior derecha
						
					}
				}
			}
		}
		//Voy a crear un método chequeacolision generico que sirva para comprobar
		//los choques entre la bola y los ladrillos y la bola y el cursor.
		
		
		
		move(xVelocidad, yVelocidad);
	}
	
	private boolean chequeacolision(double posX, double posY, Arkanoid _arkanoid){
		boolean noHaChocado = true;
		GObject auxiliar;
		auxiliar = _arkanoid.getElementAt(posX, posY);
		
		if(auxiliar instanceof Ladrillo){
			if(auxiliar.getY() == posY || auxiliar.getY() + auxiliar.getHeight() == posY){
				yVelocidad *= -1;
			}
			else if( auxiliar.getX() == posX || auxiliar.getX() + auxiliar.getWidth() == posX){
				xVelocidad *= -1;
			}
			_arkanoid.remove(auxiliar);
			noHaChocado = false;
		}
		else if( auxiliar instanceof Barra){
			yVelocidad *= -1;
			noHaChocado = false;
		}
		return noHaChocado;
	}
	
}
