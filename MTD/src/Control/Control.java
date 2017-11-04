package Control;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import GUI.GameplayPanel;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Control implements MouseMotionListener, MouseListener {

	
	public void mousePressed(MouseEvent e) {
		//GameplayPanel.store.click(e.getButton());
	}

	public void mouseDragged(MouseEvent e) {
		//Screen.mse = new Point(e.getX() - ((Frame.size.width - Screen.myWidth) / 2), e.getY() - (Frame.size.height - Screen.myHeight - (Frame.size.width - Screen.myWidth) / 2));
	}

	public void mouseMoved(MouseEvent e) {
		//Screen.mse = new Point(e.getX() - ((Frame.size.width - Screen.myWidth) / 2), e.getY() - (Frame.size.height - Screen.myHeight - (Frame.size.width - Screen.myWidth) / 2));
	}
	////////////UNUSED OVERRIDES//////////////
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	/////////////////////////////////////////
}
