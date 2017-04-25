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
        //pic.flip();
        //Canvas.copy(pic,0,0)
    }

}//end of TestPic