
public class Plane extends Vehicle {

	private int  sheet;

	public Plane(int m){
		meter = m;
		price = 200;
		sheet = 1000;
	}

	public void calcFare(){
		fare = meter * price+sheet;
		System.out.println("îÚçsã@ÇÃâ^í¿ÇÕ" + fare + "Ç≈Ç∑ÅB");
	}


}
