
public class abCar extends abVehicle {


	public abCar(int m){
		meter = m;
		price=100;
	}

	public void calcFare(){
		fare = meter * price;
		System.out.println("車の運賃は" + fare + "です。");
	}


}
