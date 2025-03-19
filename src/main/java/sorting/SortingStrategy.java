package sorting;

import com.example.fkhan368wold_assignment.SortingHubController;
import java.util.Random;

public abstract class SortingStrategy implements Runnable {
    protected int[] numbers;
    protected SortingHubController controller;


    public SortingStrategy(SortingHubController controller, int[] numbers) {
        this.controller = controller;
        this.numbers = numbers;
    }


    public abstract void sort(int[] numbers);

    public void shuffle(int[] numbers) {
        Random rand = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            controller.updateGraph(numbers);
        }
    }

    public void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
            controller.updateGraph(numbers);
        }
    }
}

