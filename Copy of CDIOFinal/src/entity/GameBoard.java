package entity;

import java.awt.Color;

public class GameBoard {
	
//private static final String TEST = "Test";
private  Field[] fields;
	
public GameBoard(){
	
	fields =  new Field[40];
	
	fields[0] = new Empty("Start", Color.red, "Whenever you pass/land on this field you get 4000$");
	fields[1] = new Houseable("Rødovrevej",Color.blue,"This field costs: 1200$",1200, null, 50, false,7, 1000, 250, 750, 2250, 4000, 6000,2);
	fields[2] = new Chance("Try your luck",Color.LIGHT_GRAY,"Try your luck, picks a random card when you land on this field");
	fields[3] = new Houseable("Hvidovrevej",Color.blue,"This field costs: 1200$",1200, null, 50, false,7, 1000, 250, 750, 2250, 4000, 6000,2);
	fields[4] = new Bonus("Income tax", Color.cyan, "Betal 4000 kr.", 4000);
	fields[5] = new Ferry("Scandlines", Color.gray.darker(), "This field costs: 4000$", 4000, null, false, 500);
	fields[6] = new Houseable("Roskildevej",Color.orange,"This field costs: 2000$",2000, null, 100, false,1, 1000, 600, 1800, 5400, 8000, 11000,3);
	fields[7] = new Chance("Try your luck",Color.LIGHT_GRAY, "Try your luck, picks a random card when you land on this field");
	fields[8] = new Houseable("Valby Langgade",Color.orange,"This field costs: 2000$",2000, null, 100, false,1, 1000, 600, 1800, 5400, 8000, 11000,3);
	fields[9] = new Houseable("Allé Gade",Color.orange,"This field costs: 2400$",2400, null, 150, false,1, 1000, 800, 2000, 6000, 9000, 12000,3);
	fields[10] = new Empty("Prison", Color.blue.brighter(), "Dont feed the prisoners");
	fields[11] = new Houseable("Frederiksberg Allé" ,Color.green,"This field costs: 2800$",2800, null, 200, false,2, 2000, 1000, 3000, 9000, 12500, 15000,3);
	fields[12] = new Soda("Tuborg Squash", Color.magenta, "This field costs: 3000$", 3000, null, 100, false);
	fields[13] = new Houseable("Bülowsvej",Color.green,"This field costs: 2800$",2800, null, 200, false,2, 2000, 1000, 3000, 9000, 12500, 15000,3);
	fields[14] = new Houseable("Gl. Kongevej",Color.green, "This field costs: 3200$", 3200, null, 250, false, 2, 2000, 1250, 3750, 10000, 14000, 18000,3);
	fields[15] = new Ferry("Mols-Linien", Color.gray.darker(), "This field costs: 4000$", 4000, null, false, 500);
	fields[16] = new Houseable("Berntoffsvej", Color.gray, "This field costs: 3600$", 3600, null, 300, false, 3, 2000, 1400, 4000, 11000, 15000, 19000,3);
	fields[17] = new Chance("Try your luck",Color.LIGHT_GRAY,"Try your luck, picks a random card when you land on this field");
	fields[18] = new Houseable("Hellerupsvej",Color.gray, "This field costs: 3600$", 3600, null, 300, false, 3, 2000, 1400, 4000, 11000, 15000, 19000,3);
	fields[19] = new Houseable("Strandvejen", Color.gray, "This field costs: 4000$", 4000, null, 350, false, 3, 2000, 1600, 4400, 12000, 16000, 20000,3);
	fields[20] = new Empty("Parking", Color.green.brighter(), "Chill spot");
	fields[21] = new Houseable("Trianglen", Color.red.darker(), "This field costs: 4400$", 4400, null, 350, false, 4, 3000, 1800, 5000, 14000, 17500, 21000,3);
	fields[22] = new Chance("Try your luck",Color.LIGHT_GRAY,"Try your luck, picks a random card when you land on this field");
	fields[23] = new Houseable("Østerbrogade", Color.red.darker(), "This field costs: 4400$", 4400, null, 350, false, 4, 3000, 1800, 5000, 14000, 17500, 21000,3);
	fields[24] = new Houseable("Grønningen", Color.red.darker(), "This field costs: 4800$", 4800, null, 400, false, 4, 3000, 2000, 6000, 15000, 18500, 22000,3);
	fields[25] = new Ferry("Scandlines", Color.gray.darker(), "This field costs: 4000$", 4000, null, false,500);
	fields[26] = new Houseable("Bredgade", Color.white, "This field costs: 5200$", 5200, null, 450, false, 5, 3000, 2200, 6600, 16000, 19500, 23000,3);
	fields[27] = new Houseable("Kgs. Nytorv", Color.white, "This field costs: 5200$", 5200, null, 450, false, 5, 3000, 2200, 6600, 16000, 19500, 23000,3);
	fields[28] = new Soda("Coca-Cola", Color.magenta, "This field costs: 3000$", 3000, null, 100, false);
	fields[29] = new Houseable("Østergade", Color.white, "This field costs: 5600$", 5600, null, 500, false, 5, 3000, 2400, 7200, 17000, 20500, 24000,3);
	fields[30] = new Jail("Go to prison", Color.green.brighter(), "The cops got you, enjoy your stay in prison");
	fields[31] = new Houseable("Amagertorv", Color.yellow, "This field costs: 6000$", 6000, null, 550, false, 6, 4000, 2600, 7800, 18000, 22000, 25000,3);
	fields[32] = new Houseable("Vimmelskaftet", Color.yellow, "This field costs: 6000$", 6000, null, 550, false, 6, 4000, 2600, 7800, 18000, 22000, 25000,3);
	fields[33] = new Chance("Try your luck",Color.LIGHT_GRAY,"Try your luck, picks a random card when you land on this field");
	fields[34] = new Houseable("Nygade", Color.yellow, "This field costs: 6400$", 6400, null, 600, false, 6, 4000, 3000, 9000, 20000, 24000, 28000,3);
	fields[35] = new Ferry("Scandlines", Color.gray.darker(), "This field costs: 4000$", 4000, null, false,500);
	fields[36] = new Chance("Try your luck",Color.LIGHT_GRAY,"Try your luck, picks a random card when you land on this field");
	fields[37] = new Houseable("Frederiksberggade", Color.pink.darker(), "This field costs: 7000$", 7000, null, 700, false, 8, 4000, 3500, 10000, 22000, 26000, 30000,2);
	fields[38] = new Bonus("Income tax", Color.cyan, "Betal 4000 kr.", 4000);
	fields[39] = new Houseable("Rådhuspladsen", Color.pink.darker(), "This field costs: 8000$", 8000, null, 1000, false, 8, 4000, 4000, 12000, 28000, 34000, 4000,2);
	
	
}
	
public Field getField  (int fieldNumber){
	return  fields[fieldNumber];
}

public Field[] getFields() {

	return fields;
}
	
	

}
