package com.weijinqian;

public class GetNumberOfKSolution {
    public int GetNumberOfK(int[] array, int k) {
        int leftBoarder = binarySearch(array, k, true);
        int rightBoarder = binarySearch(array, k, false);
        if (leftBoarder == -1 || rightBoarder == -1) {
            return 0;
        }
        return rightBoarder - leftBoarder + 1;
    }

    private int binarySearch(int[] array, int k, boolean isLeftBoarder) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int mid = 0;
        int left = 0;
        int right = array.length - 1;

        boolean isBoarder = false;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] == k) {
                if (isLeftBoarder) {
                    isBoarder = mid == 0 || array[mid - 1] < array[mid];
                } else {
                    isBoarder = mid == array.length - 1 || array[mid + 1] > array[mid];
                }
                if (isBoarder) {
                    return mid;
                } else {
                    if (isLeftBoarder) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
