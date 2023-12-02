public class Sorting {

    public static void main(String[] args) {

        int[] data = { 4, 7, 9, 3, 5, 2, 1, 6, 8, 0 };
        // bubbleSort(data);
        // selectionSort(data);
        // insertionSort(data);
        // mergeSort(data, 0, data.length - 1);
        quickSort(data, 0, data.length - 1);
        for (int i : data) {
            System.out.print(i);
        }
    }

    public static void bubbleSort(int[] data) {
        int size = data.length;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = true;
                }
            }
            size--;
        } while (swapped);
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min])
                    min = j;
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }

    int[] data = { 4, 7, 9, 3, 5, 2, 1, 6, 8 };

    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }

    public static void mergeSort(int[] data, int left, int right) {

        if (left >= right)
            return;

        int middle = left + (right - left) / 2;
        mergeSort(data, left, middle);
        mergeSort(data, middle + 1, right);

        merge(data, left, middle, right);
    }

    public static void merge(int[] data, int left, int middle, int right) {

        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++)
            leftArray[i] = data[i + left];
        for (int i = 0; i < sizeRight; i++)
            rightArray[i] = data[i + middle + 1];

        int leftPointer = 0;
        int rightPointer = 0;
        int index = left;
        while (leftPointer < sizeLeft && rightPointer < sizeRight) {
            if (rightArray[rightPointer] < leftArray[leftPointer])
                data[index++] = rightArray[rightPointer++];
            else
                data[index++] = leftArray[leftPointer++];
        }

        while (leftPointer < sizeLeft)
            data[index++] = leftArray[leftPointer++];

        while (rightPointer < sizeRight)
            data[index++] = rightArray[rightPointer++];
    }

    public static void quickSort(int[] data, int left, int right) {

        if (left >= right)
            return;

        int pivot = partition(data, left, right);
        quickSort(data, left, pivot - 1);
        quickSort(data, pivot + 1, right);
    }

    public static int partition(int[] data, int left, int right) {

        int pivot = data[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (data[j] < pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        i++;
        data[right] = data[i];
        data[i] = pivot;

        return i;
    }

}
