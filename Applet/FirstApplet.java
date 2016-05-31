/*
This is my First Applet program
*/
import java.awt.*;
import java.applet.*;
/*
<applet code="FirstApplet" width=300 height=100>
</applet>
*/
public class FirstApplet extends Applet
{
 public void paint(Graphics g)
 {
  g.drawString("HELLOJAVA",50,30);
 }
}
