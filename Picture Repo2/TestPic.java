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
        //pic.explore();

        ChangePic pic1= new ChangePic("sponge.jpg");
        pic1.negate();
		//pic1.explore();

		ChangePic pic2= new ChangePic("sponge.jpg");
		pic2.mirrorVertical();
		//pic2.explore();

		ChangePic pic4= new ChangePic("sponge.jpg");
		pic4.grayscale();
		//pic4.explore();

        ChangePic Canvas1 = new ChangePic("Canvas.jpg");
        Canvas1.copyPicture(0,0,pic);
        Canvas1.copyPicture(0,634,pic1);
        Canvas1.copyPicture(1006,0,pic2);
        Canvas1.copyPicture(1006,634,pic4);
        Canvas1.explore();
        Canvas1.write("Final.jpg");
    }

}//end of TestPic