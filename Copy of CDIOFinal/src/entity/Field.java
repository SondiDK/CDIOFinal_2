package entity;

import java.awt.Color;

public abstract class Field {
	
	protected String fieldName;
	private  Color backgroundColor;
	private String description;	

//konstruktoer for field
public Field(String fieldName, Color backgroundColor, String description) {
	this.fieldName = fieldName;
	this.backgroundColor = backgroundColor;
	this.description = description;
}

	//abstrakt metode, der anvendes af alle felt typer
public abstract void landOnField(Player player);

//set og getter metoder
public String getFieldName() { return fieldName; }
public Color getBackgroundColor() { return backgroundColor;	}
public String getDescription() { return description; }

}