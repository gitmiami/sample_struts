package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class listMapMain {

	public static void main(String[] args) {


		///////////////////////////////////////////////////////////////
		//5件ずつ送信
		///////////////////////////////////////////////////////////////

		Person per1 = new Person();

		per1.setId("1");
		per1.setName("oosaka");

		Person per2 = new Person();

		per2.setId("2");
		per2.setName("tokyo");

		Person per3 = new Person();

		per3.setId("3");
		per3.setName("nagoya");

		Person per4 = new Person();

		per4.setId("4");
		per4.setName("kyotoa");

		Person per5 = new Person();

		per5.setId("5");
		per5.setName("okayama");

		Person per6 = new Person();

		per6.setId("6");
		per6.setName("okinawa");

		Person per7 = new Person();

		per7.setId("7");
		per7.setName("totri");

Person per8 = new Person();

		per8.setId("8");
		per8.setName("fukushima");



Person per9 = new Person();

		per9.setId("9");
		per9.setName("shibuya");

Person per10 = new Person();

		per10.setId("10");
		per10.setName("shinjyuku");


		ArrayList<Person> tableLAllist= new ArrayList<Person>();

		tableLAllist.add(per1);
		tableLAllist.add(per2);
		tableLAllist.add(per3);
		tableLAllist.add(per4);
		tableLAllist.add(per5);
		tableLAllist.add(per6);

		tableLAllist.add(per7);
		tableLAllist.add(per8);
		tableLAllist.add(per9);
		tableLAllist.add(per10);

		ArrayList<Person> tableList= new ArrayList<Person>();
		ArrayList<Person> tableList2= new ArrayList<Person>();

		Member mem = new Member();
		mem.setPersonList(tableLAllist);

		ArrayList<Person> memList=mem.getPersonList();

		int cnt=1;

		int cntAll=0;
		int maxCnt = memList.size();


		Map<String, ArrayList<Person>> sen5map= new HashMap<String, ArrayList<Person>>();
		int cntMap=1;


		//①5件ずつリストに詰める
		//②リストをmapに詰める。
		//③mapからリストを取得しバッファリストに詰める。


		for(Person per : memList){

			cntAll=cntAll+1;

			//5件リストに作成する
			if(!(cnt%5==0)){

				tableList.add(per);
				cnt=cnt+1;

			}else{
				tableList.add(per);


				//初期化　tableList2.clear()　だとsend5Mapの中もクリアされてします。
				tableList2 = new ArrayList<Person>();

				//tableList　参照型なのでマップに詰めた後クリアすると、mapに詰めたtableListもクリアされる
				//tableList2ここで作る.プリミティブではない
				for(Person tumekaeaePer : tableList){
					tableList2.add(tumekaeaePer);
				}

				sen5map.put(String.valueOf(cntMap), tableList2);

				//初期化処理
				tableList.clear();

				cnt=1;
				cntMap=cntMap+1;
				if(maxCnt==cntAll){
					break;
				}

			}

			//////////////////////////////
			//最後 のカウントが入る
			//////////////////////////////
			if(maxCnt==cntAll){
				//最後5件未満の場合
				sen5map.put(String.valueOf(cntMap), tableList);

			}

		}

		ArrayList<ArrayList<Person>> bufList= new ArrayList<ArrayList<Person>>();

		for(String key : sen5map.keySet()){

			ArrayList<Person> getTableList= new ArrayList<Person>();

			getTableList = sen5map.get(key);

			bufList.add(getTableList);

		}

		System.out.println("h:    " );

	}


	static void makePerson(Person per1){


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




	}




}
