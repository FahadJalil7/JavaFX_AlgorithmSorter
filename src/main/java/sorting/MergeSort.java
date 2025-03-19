package sorting;

import com.example.fkhan368wold_assignment.SortingHubController;

public class MergeSort extends SortingStrategy {
    public MergeSort(SortingHubController controller,int[] numbers) {
        //this.controller = controller;
        super(controller, numbers);
    }

    @Override
    public void sort(int[] numbers) {
        this.numbers = numbers;
        mergeSort(0, numbers.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (numbers[i] <= numbers[j]) {
                temp[k++] = numbers[i++];
            } else {
                temp[k++] = numbers[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = numbers[i++];
        }

        while (j <= right) {
            temp[k++] = numbers[j++];
        }

        for (i = 0; i < temp.length; i++) {
            numbers[left + i] = temp[i];
            controller.updateGraph(numbers);
        }
    }

    @Override
    public void run() {
        sort(numbers);
    }
}
