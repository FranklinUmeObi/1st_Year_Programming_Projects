
public class MyKingDom {

	public static void main(String[] args) {
		
		Animal rover = new Dog(11) ;
		Dog ghost = new Dog(12) ;
		Horse lena = new Horse(17) ;
		Turtle tim = new Turtle(1) ;
		Animal jim = tim ;
		
		Animal[] kingdom = new Animal[5] ;
		
		kingdom[0] = rover ;
		kingdom[1] = ghost ;
		kingdom[2] = lena ;
		kingdom[3] = tim ;
		kingdom[4] = jim ;
		
		for(Animal x : kingdom)
		{
			x.run();
			x.speak();
		}

	}

}
