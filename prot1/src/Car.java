
public class Car extends Vehicle {


	public Car(int m){
		meter = m;
		price=100;
	}

	public void calcFare(){
		fare = meter * price;
		System.out.println("車の運賃は" + fare + "です。");
	}

}
