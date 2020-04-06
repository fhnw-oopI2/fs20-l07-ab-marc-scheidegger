package ch.fhnw.oop2.module07.ab2;

import java.text.DecimalFormat;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;


final class ApplicationUI extends BorderPane{
	
	private Slider slider;
	private Label label;
	
	public ApplicationUI() {
		initializeControls();
		initializeBindings();
		layoutControls();
	}
	
	private void initializeControls() {
		
		slider = new Slider(0,10,2);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(0.5);
		slider.setSnapToTicks(true);
		
		label = new Label("Start: 2");
	}
	
	private void initializeBindings() {
		DoubleProperty actualValue = slider.valueProperty();
		
		actualValue.addListener((observableValue, oldValue, newValue) -> {DecimalFormat dez = new DecimalFormat("0.000");
		label.setText(dez.format(newValue));
		});
	}
	

	private void layoutControls() {
		
//		Gibt es hier eine Möglichkeit "label" auch mit setCenter auszurichten, sodass es nicht mit dem Slider kollidiert?
		setTop(label);
		ApplicationUI.setMargin(label, new Insets(50, 0 , 0, 225));
		
		setCenter(slider);
		ApplicationUI.setMargin(slider, new Insets(0,20,0,20));

	}

}
