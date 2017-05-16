import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;

public class ChangePic extends SimplePicture
{
    /**
    * Constructor that takes no arguments
    */
    public ChangePic()
    {
       /* not needed but use it to show students the implicit call to super()
       * child constructors always call a parent constructor
       */
       super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     * @param fileName the name of the file to create the picture from
     */
    public ChangePic(String fileName)
    {
       // let the parent class handle this fileName
       super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param width the width of the desired picture
     * @param height the height of the desired picture
    */
    public ChangePic(int width, int height)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     */
    public ChangePic(ChangePic copyChangePic)
    {
        // let the parent class do the copy
        super(copyChangePic);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public ChangePic(BufferedImage image)
    {
        super(image);
    }

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {

        String output = "Picture, filename " + getFileName() +
        " height " + getHeight()
        + " width " + getWidth();
        return output;

      }


   public void negate()
   {   //!!!!!!!!! this copies the picture into array
   	   //!!!!!!!!! large pictures could cause out of memory error!!!!!
	   Pixel[] pixelArray = this.getPixels();
	   Pixel pixel = null;
	   int redValue, blueValue, greenValue =0;

	   //loop through all the pixels
	   for (int i = 0; i<pixelArray.length; i++)
	   {
		   //get the current pixel
		   pixel = pixelArray[i];

		   //get the current red,green and blue vllues
		   redValue = pixel.getRed();
		   greenValue = pixel.getGreen();
		   blueValue = pixel.getBlue();

		   //set the pixel's color to the new color
		   pixel.setColor(new Color(255 - redValue,
		   							255 - greenValue,
		   							255 - blueValue));
	   }//end of for
   }//end of negate
	public void mirrorVertical()
   {
	   //String sourceFile = ("sponge.jpg");
	   //Picture sourcePicture = new Picture(sourceFile);

	   int width =this.getWidth();
	   int mirrorPoint=width/2;
	   Pixel leftPixel=null;
	   Pixel rightPixel=null;

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

	   Pixel temp= null;
	/*
	   //loop through the columns
	   for (int sourceX = 0, targetX=sourcePicture.getWidth();
	   		sourceX < sourcePicture.getWidth()/2;
	   		sourceX++, targetX--)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = sourcePicture.getHeight();
		   		sourceY < sourcePicture.getHeight();
		   		sourceY++, targetY--)
		   {

		   		//set the target pixel color to the source pixel color

		   		//temp = sourcePicture.getPixel(sourceX,sourceY);
		   		sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
		   		targetPixel = this.getPixel(targetX,targetY);
		   		targetPixel.setColor(sourcePixel.getColor());
		   		//sourcePixel.setColor(temp
		}
		}
		*/
		for(int y=0; y<getHeight(); y++)
		{
			for(int x=0; x<mirrorPoint;x++)
			{
				leftPixel=getPixel(x,y);
				rightPixel=getPixel(width-1-x,y);
				rightPixel.setColor(leftPixel.getColor());
				}
			}

	}//end of mirrorVertical

	public void grayscale()
		{//!!!!!! again copies all the pixels into an array!!!!!
			Pixel[] pixelArray = this.getPixels();
			Pixel pixel = null;
			int intensity = 0;

			for (int i = 0; i < pixelArray.length; i++)
			{
				//get the current pixel
				pixel = pixelArray[i];

				//compute the intensity of the pixel (average value)
				intensity = (int) ((pixel.getRed() + pixel.getGreen()+
								   pixel.getBlue())/3);

				//set the pixel color to the new color
				pixel.setColor(new Color(intensity,intensity,intensity));
			}//end of for

		}//end of grayscale

	public void copyPicture(int x, int y, ChangePic sourcePicture)
	{
		Pixel sourcePixel=null;
		Pixel targetPixel=null;

		//loops through each column
		for(int sourceX=0, targetX=x; sourceX<sourcePicture.getWidth(); sourceX++, targetX++)
		{
			//loop through each position in the column
			for(int sourceY=0, targetY=y; sourceY<sourcePicture.getHeight(); sourceY++, targetY++)
			{
				sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
				targetPixel = this.getPixel(targetX,targetY);
				targetPixel.setColor(sourcePixel.getColor());
				}
			}

	}//end of copy
}//end of ChangePic
