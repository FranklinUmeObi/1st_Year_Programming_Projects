import java.util.ArrayList ;
public class PaintThings {

	public static void main(String[] args) 
	{
		Shape deck = new Rectangle("Rectangle", 20, 35) ;
		Shape bigBall = new Sphere("Sphere", 15) ;
		Shape tank = new Cylinder("Cylinder", 10, 30) ;
		
		ArrayList<Shape> myShapes = new ArrayList<Shape>() ;
		myShapes.add(deck) ;
		myShapes.add(bigBall) ;
		myShapes.add(tank) ;
		
		for(Shape aShape : myShapes)
		{
			aShape.toString() ;
			Paint thePaint = new Paint(350) ;
			thePaint.amount(aShape) ;
		}

	}

}
