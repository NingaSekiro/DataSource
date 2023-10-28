import java.util.Arrays;

public class MaxHeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆（从最后一个非叶子节点开始）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次取出堆顶元素（最大值），并调整堆
        for (int i = n - 1; i >= 0; i--) {
            // 将堆顶元素与当前未排序部分的最后一个元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整堆，使其满足最大堆性质
            heapify(arr, i, 0);
        }
    }

    // 调整堆，使其满足最大堆性质
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化当前节点为最大值
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 比较左子节点与当前节点
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 比较右子节点与当前节点
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前节点，则交换节点并继续调整堆
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 18, 25, 47, 58, 12, 51, 10, 56};

        System.out.println("Original array: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}