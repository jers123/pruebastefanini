package areafiguras;

public class Figura {

	private static double base = 5;
	private static double altura = 8;
	
	private static double areaTriangulo() {
		return (base * altura) /2;
	}
	
	private static double areaCirculo(double radio) {
		return (radio * radio) * Math.PI;
	}
	
	public static void main(String[] args) {
		System.out.println("El área del triángulo es: " + areaTriangulo());
		
		double radio = 7;
		System.out.println("El área del círculo es: " + areaCirculo(radio));
	}
}