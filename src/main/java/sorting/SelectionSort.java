package sorting;

import com.example.fkhan368wold_assignment.SortingHubController;

public class SelectionSort extends SortingStrategy {
    public SelectionSort(SortingHubController controller,int[] numbers) {
        //this.controller = controller;
        super(controller, numbers);
    }

    @Override
    public void sort(int[] numbers) {
        this.numbers = numbers;
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = numbers[minIdx];
            numbers[minIdx] = numbers[i];
            numbers[i] = temp;
            controller.updateGraph(numbers);
        }
    }

    @Override
    public void run() {
        sort(numbers);
    }
}
