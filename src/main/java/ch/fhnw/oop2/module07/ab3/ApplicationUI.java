package ch.fhnw.oop2.module07.ab3;

import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;


final class ApplicationUI extends BorderPane{
	
	private Slider slider;
	private TextField txtf;
	private NumberStringConverter converter;
	
	public ApplicationUI() {
		converter = new NumberStringConverter();
		initializeControls();
		layoutControls();
	}
	
	private void initializeControls() {
		
		slider = new Slider(0,10,2);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(0.5);
		slider.setSnapToTicks(true);
		
		txtf = new TextField("test");
		txtf.textProperty().bindBidirectional(slider.valueProperty(), converter);
		
	}
	
	private void layoutControls() {
		
//		Gibt es hier eine Möglichkeit "label" auch mit setCenter auszurichten, sodass es nicht mit dem Slider kollidiert?
		setTop(txtf);
		txtf.setMaxWidth(100);
		ApplicationUI.setMargin(txtf, new Insets(50, 0 , 0, 20));
		
		setCenter(slider);
		ApplicationUI.setMargin(slider, new Insets(0,20,0,20));

	}

}
