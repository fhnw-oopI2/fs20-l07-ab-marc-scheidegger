package ch.fhnw.oop2.module07.ab1;


import java.util.stream.Stream;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

final class ApplicationUI extends GridPane{
	
	private static final int NumberOfItems = 6;
	private static final double Percent = 100.0 / NumberOfItems;
	
	ApplicationUI (Stage stage){
		stage.setTitle(this.getClass().getSimpleName());
		setGridLinesVisible(true);
		
		Stream.iterate(0, n -> n + 1)
			.limit(NumberOfItems)
			.forEach(n -> {
				ColumnConstraints column = new ColumnConstraints();
				column.setPercentWidth(Percent);
				getColumnConstraints().add(column);
				
				RowConstraints row = new RowConstraints();
				row.setPercentHeight(Percent);
				getRowConstraints().add(row);
				
			});
	}
	
	
	private Button button;
	private int counterRow = 1;
	private int counterCol = 1;
	
	public ApplicationUI() {
		initializeControls();
		layoutControls();
	}
	
	private void initializeControls() {
		button = new Button("Add Label");
		button.setOnAction(event -> addLabel());
		button.setOnMouseEntered(System.out::println);  // What for? //
	}
	
	private void addLabel() {
		add(new Label("Label " + counterRow),counterRow, counterCol);
		counterRow++;
		if (counterRow == NumberOfItems) {
			counterCol++;
			counterRow = 1;
		}
	}

	private void layoutControls() {
		getChildren().add(button);
		setPadding(new Insets(10));
//		ApplicationUI.setMargin(Label, new Insets(5,0,0,0));
	}
}
