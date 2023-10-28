public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次取出最大堆的根节点，并进行堆调整
        for (int i = n - 1; i >= 0; i--) {
            // 将当前根节点（最大值）与最后一个元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 对剩余元素进行堆调整
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 当前节点为最大值
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 如果左子节点大于最大值节点
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点大于最大值节点
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值节点不是当前节点，交换最大值节点与当前节点，并递归进行堆调整
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array: ");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array: ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}