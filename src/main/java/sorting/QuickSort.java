package sorting;

import com.example.fkhan368wold_assignment.SortingHubController;

public class QuickSort extends SortingStrategy {
    public QuickSort(SortingHubController controller,int[] numbers) {
        //this.controller = controller;
        super(controller,numbers);
    }

    @Override
    public void sort(int[] numbers) {
        this.numbers = numbers;
        quickSort(0, numbers.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = numbers[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (numbers[j] < pivot) {
                i++;
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                controller.updateGraph(numbers);
            }
        }

        int temp = numbers[i + 1];
        numbers[i + 1] = numbers[high];
        numbers[high] = temp;
        controller.updateGraph(numbers);

        return i + 1;
    }

    @Override
    public void run() {
        sort(numbers);
    }
}
