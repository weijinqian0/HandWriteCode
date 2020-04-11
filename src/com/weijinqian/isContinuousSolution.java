package com.weijinqian;

public class isContinuousSolution {

    public boolean isContinuous(int[] numbers) {
        int len = numbers.length;
        if (len != 5) {
            return false;
        }

        int[] card = new int[14];
        for (int i = 0; i < len; i++) {
            card[numbers[i]]++;
        }

        int supplement = card[0];
        int begin = 0;
        for (int i = 1; i < card.length - 5; i++) {
            if (card[i] >= 2) {
                return false;
            }
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (card[i + j] >= 2) {
                    return false;
                }
                if (card[i + j] == 0) {
                    tmp++;
                }
            }

            if (tmp <= supplement) {
                return true;
            }
        }

        return false;

    }
}
