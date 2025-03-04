public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            int right = matrix[i].length - 1;
            if (matrix[i][right] >= target) {
                return bsRow(matrix, target, 0, right, i);
            }
        }
        return false;
    }

    public boolean bsRow(int[][] mat, int key, int left, int right, int row) {
        if (right < left) {
            return false;
        }

        int mid = left + (right - left) / 2;

        if (key == mat[row][mid]) {
            return true;
        } else if (key < mat[row][mid]) {
            return bsRow(mat, key, left, mid - 1, row);
        } else {
            return bsRow(mat, key, mid + 1, right, row);
        }
    }
