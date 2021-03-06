package sample;

public class Samples {
	public static void main(String[] args) {
		PlayerPiece p = new PlayerPiece();
		Object o = p;
		GameShape gs = p;
		Animatable a = p;
		gs.display();
		PlayerPiece pp = (PlayerPiece)new GameShape();
		int aa = new Character('9');
		System.out.println("this is the char: "+ aa);
		test(4l);
	}
	
	public static void test(Long... x){
		System.out.println(x[0]);
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
	@Override
	public void display() {
		System.out.println("PlayerPiece.display");
	}
}