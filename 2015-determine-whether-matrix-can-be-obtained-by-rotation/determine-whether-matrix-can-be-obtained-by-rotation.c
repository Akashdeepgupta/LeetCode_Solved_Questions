// Function to rotate the matrix by 90 degrees clockwise
void rotate90(int** mat, int n) {
    // Transpose the matrix
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int temp = mat[i][j];
            mat[i][j] = mat[j][i];
            mat[j][i] = temp;
        }
    }
    // Reverse each row
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n / 2; j++) {
            int temp = mat[i][j];
            mat[i][j] = mat[i][n - j - 1];
            mat[i][n - j - 1] = temp;
        }
    }
}

// Function to check if two matrices are equal
bool isEqual(int** mat, int** target, int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] != target[i][j]) {
                return false;
            }
        }
    }
    return true;
}





bool findRotation(int** mat, int matSize, int* matColSize, int** target, int targetSize, int* targetColSize) {
    // Check if they are already equal without any rotation
    if (isEqual(mat, target, matSize)) {
        return true;
    }

    // Try rotating 90, 180, and 270 degrees
    for (int i = 0; i < 3; i++) {
        rotate90(mat, matSize);
        if (isEqual(mat, target, matSize)) {
            return true;
        }
    }
    
    // If none of the rotations matched, return false
    return false;
}