
public abstract class Animal implements Creature
{
	public int speed ;
	
	Animal(int speed)
	{
		this.speed = speed ;
	}
	
	public void run()
	{
		System.out.println("This animal ran " + speed*5 + " meters in 5 minutes");
	}
	
	public abstract void speak() ;
	
		
	
	
}
