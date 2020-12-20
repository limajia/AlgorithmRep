package suanfa;

public class AB {

	public static void main(String[] args) {
//		System.out.println();
		name();
	}

	public static int fun(int a) {
		return a == 3 ? 0 : 1 == 1 ? 2 : 3;
//		return num >= 90 ? "A" : num >= 80 ? "B"  : num >= 70 ? "C"  : num >= 60 ? "D" : "E" ;
//		每次从右到左 效率低
	}

	public static void name() {
		int a = 10;
		switch (a) {
		default:
			a += 10;
			break;
		case 20:
			a += 10;
			System.out.println(a);
			break;
		}
	}
}
