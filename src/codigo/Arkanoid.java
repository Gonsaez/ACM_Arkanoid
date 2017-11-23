package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

/*
 * Autor: Gonzalo Sáez Martí
 * 
 * El Arkanoid pero orientado a objetos
 */

import acm.graphics.*;
public class Arkanoid extends acm.program.GraphicsProgram{

	Ball ball1 = new Ball(20, Color.BLUE);
	Barra barra1 = new Barra(60, 15, Color.RED);
	int anchoLadrillo = 35;
	int altoLadrillo =15;
	
	//El sistema del marcador
	int puntuacion= 0;
	Marcador marcador = new Marcador (20, 40);
	

	public void init(){
		addMouseListeners();
		setSize(400, 600);

		add(ball1, 0, getHeight()*0.75  - ball1.getHeight());
		add(barra1, 0, getHeight()*0.80);

	}

	public void run(){
		dibujaNivel02();
		marcador.dibuja(this);
		while(true){
			ball1.muevete(this);
			pause(8);
		}
	}
	public void mouseMoved(MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth());
	}
	private void dibujaNivel01(){
		int numLadrillos = 14;
		for(int j=0; j<numLadrillos; j++){
			for(int i=j; i<numLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(((getWidth()/2)-(numLadrillos/2)*anchoLadrillo)+(anchoLadrillo*i - anchoLadrillo*j/2), altoLadrillo*j + altoLadrillo, anchoLadrillo, altoLadrillo, Color.PINK);
				add(miLadrillo);
				pause(7);
			}
		}
	}
	private void dibujaNivel02(){
		int numLadrillos = 10;
		for(int j=0; j<numLadrillos; j++){
			for(int i=0; i<numLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(i+j + getWidth(), getHeight());
			}
		}
	}
}
