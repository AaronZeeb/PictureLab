import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
public class TestPic
{
    public static void main( String args[])
    {
        ChangePic pic= new ChangePic("sponge.jpg");
        pic.explore();

        ChangePic pic1= new ChangePic("sponge.jpg");
        pic1.negate();
		pic1.explore();

		ChangePic pic2= new ChangePic("sponge.jpg");
		pic2.mirrorVertical();
		pic2.explore();

		ChangePic pic4= new ChangePic("sponge.jpg");
		pic4.grayscale();
		pic4.explore();

        //pic.flip();
        //Canvas.copy(pic,0,0)
        Canvas.copyPicture(0,0,pic);
        Canvas.copyPicture(0,634,pic1);
        Canvas.copyPicture(1106,0,pic2);
        Canvas.copyPicture(1106,634,pic4);
        Canvas.write("Final.jpg");
    }

}//end of TestPic