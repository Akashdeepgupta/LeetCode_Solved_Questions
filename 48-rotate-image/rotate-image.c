
// Function to swap elements for transposing
void swap(int **arr, int i, int j) {
    int temp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = temp;
}

// Function to swap elements in rows (for reversing rows)
void Swap_ak(int **arr, int i, int j, int last) {
    int temp = arr[i][j];
    arr[i][j] = arr[i][last];
    arr[i][last] = temp;
}

// Function to transpose the matrix
void Transpose_Matrix(int **arr, int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i > j) {
                swap(arr, i, j);
            }
        }
    }
}

// Function to reverse each row
void ReverseRow(int **arr, int n) {
    for (int i = 0; i < n; i++) {
        int last = n - 1;
        for (int j = 0; j < n / 2; j++) {
            Swap_ak(arr, i, j, last);
            last--;
        }
    }
}

// Function to rotate the matrix by 90 degrees clockwise
void rotate(int **matrix, int matrixSize, int *matrixColSize) {
    Transpose_Matrix(matrix, matrixSize);
    ReverseRow(matrix, matrixSize);
}


