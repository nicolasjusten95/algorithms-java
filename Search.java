public class Search {

    public static void main(String[] args) {

        int[] data = new int[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

        System.out.println(linearSearch(data, 134));
        System.out.println(binarySearch(data, 134));
        System.out.println(binarySearchRecursive(data, 134, 0, data.length - 1));
        System.out.println(interpolationSearch(data, 134));
        System.out.println(linearSearch(data, 787));
        System.out.println(binarySearch(data, 787));
        System.out.println(binarySearchRecursive(data, 787, 0, data.length - 1));
        System.out.println(interpolationSearch(data, 787));
        System.out.println(linearSearch(data, 1000));
        System.out.println(binarySearch(data, 1000));
        System.out.println(binarySearchRecursive(data, 1000, 0, data.length - 1));
        System.out.println(interpolationSearch(data, 1000));
    }

    public static int linearSearch(int[] data, int value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] data, int value) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (data[middle] == value)
                return middle;
            if (data[middle] < value)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] data, int value, int low, int high) {
        int middle = low + (high - low) / 2;
        if (low <= high) {
            if (data[middle] == value)
                return middle;
            if (data[middle] > value)
                return binarySearchRecursive(data, value, low, middle - 1);
            if (data[middle] < value)
                return binarySearchRecursive(data, value, middle + 1, high);
        }
        return -1;
    }

    public static int interpolationSearch(int[] data, int value) {
        int low = 0;
        int high = data.length - 1;
        while (value >= data[low] && value <= data[high] && low <= high) {
            int position = low + (high - low) * (value - data[low]) / (data[high] - data[low]);
            if (data[position] == value)
                return position;
            if (data[position] < value)
                low = position + 1;
            else
                high = position - 1;
        }
        return -1;
    }

}
