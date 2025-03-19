package com.example.fkhan368wold_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.SortingStrategy;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.application.Platform;


public class SortingHubController {
    @FXML
    private Pane visualizationPane;
    @FXML
    private Slider timeDelaySlider;
    @FXML
    private Slider arraySizeSlider;
    @FXML
    private ComboBox<String> algorithmComboBox;

    private int[] numbers;
    private Rectangle[] bars;
    private SortingStrategy sortingMethod;

    @FXML
    public void initialize() {
        algorithmComboBox.getItems().addAll("Quick Sort", "Selection Sort", "Merge Sort");
        algorithmComboBox.setValue("Merge Sort");

        arraySizeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            initializeArray(newVal.intValue());
        });

        initializeArray(48); // Default size
    }

    private void initializeArray(int size) {
        numbers = new int[size];
        bars = new Rectangle[size];
        double barWidth = visualizationPane.getPrefWidth() / size;

        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * visualizationPane.getPrefHeight());
            bars[i] = new Rectangle(barWidth - 1, numbers[i]);
            bars[i].setX(i * barWidth);
            bars[i].setY(visualizationPane.getPrefHeight() - numbers[i]);
            bars[i].setFill(Color.RED);
        }

        visualizationPane.getChildren().clear();
        visualizationPane.getChildren().addAll(bars);
    }

    public void updateGraph(int[] array) {
        try {
            Thread.sleep((long) timeDelaySlider.getValue());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Platform.runLater(() -> {
            for (int i = 0; i < array.length; i++) {
                bars[i].setHeight(array[i]);
                bars[i].setY(visualizationPane.getPrefHeight() - array[i]);
            }
        });
    }

    @FXML
    private void handleSort() {
        switch (algorithmComboBox.getValue()) {
            case "Quick Sort":
                sortingMethod = new QuickSort(this,numbers);
                break;
            case "Selection Sort":
                sortingMethod = new SelectionSort(this,numbers);
                break;
            case "Merge Sort":
                sortingMethod = new MergeSort(this,numbers);
                break;
        }

        new Thread(sortingMethod).start();
    }

    @FXML
    private void handleShuffle() {
        if (sortingMethod != null) {
            sortingMethod.shuffle(numbers);
        }
    }

    @FXML
    private void handleReverse() {
        if (sortingMethod != null) {
            sortingMethod.reverse(numbers);
        }
    }
}