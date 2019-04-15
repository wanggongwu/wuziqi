package game_wuziqi;

public class Judge implements Gobang {
    private int x, y;
    private int count;

    public Judge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean judge() {
        if (judge1(x, y) >= 5)
            return true;
        return false;
    }

    public int judge1(int x1, int y2) {

        // 横向检查
        count = 1;
        for (int i = x1 + 1; i < COLOUM; i++) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[i][y2]) {
                    count++;
                } else
                    break;
            } else
                break;
        }
        for (int i = x1 - 1; i >= 0; i--) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[i][y2]) {
                    count++;
                } else
                    break;
            } else
                break;
        }

        if (count >= 5)
            return count;

        // 纵向检查
        count = 1;
        for (int i = y2 + 1; i < ROW; i++) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[x1][i]) {
                    count++;
                } else
                    break;
            } else
                break;
        }
        for (int i = y2 - 1; i >= 0; i--) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[x1][i]) {
                    count++;
                } else
                    break;
            } else
                break;
        }

        if (count >= 5)
            return count;

        // 斜向检查
        count = 1;
        // 左上到右下
        for (int i = x1 + 1, j = y2 + 1; i < COLOUM && j < ROW; i++, j++) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[i][j]) {
                    count++;
                } else
                    break;
            } else
                break;
        }
        // 右下到左上
        for (int i = x1 - 1, j = y2 - 1; i >= 0 && j >= 0; i--, j--) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[i][j]) {
                    count++;
                } else
                    break;
            } else
                break;
        }
        if (count >= 5)
            return count;

        count = 1;
        // 左下到右上
        for (int i = x1 + 1, j = y2 - 1; i < COLOUM && j >= 0; i++, j--) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[i][j]) {
                    count++;
                } else
                    break;
            } else
                break;
        }
        // 右上到左下
        for (int i = x1 - 1, j = y2 + 1; i >= 0 && j < ROW; i--, j++) {
            if (ARRAY[x1][y2] != 0) {
                if (ARRAY[x1][y2] == ARRAY[i][j]) {
                    count++;
                } else
                    break;
            } else
                break;
        }

        return count;

    }

}