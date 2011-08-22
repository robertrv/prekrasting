package sample;
public class Samples {
	public static void main(String[] args) {
		PlayerPiece p = new PlayerPiece();
		Object o = p;
		GameShape gs = p;
		Animatable a = p;
		gs.display();
	}
}

class GameShape {
	public void display() {
		System.out.println("GameShape.display");
	}
	
}

interface Animatable {
	
}

class PlayerPiece extends GameShape implements Animatable {
	public void display() {
		System.out.println("PlayerPiece.display");
	}	
}