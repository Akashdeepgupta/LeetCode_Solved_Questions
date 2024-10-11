// Define a structure to store key-value pairs for the hash map
typedef struct {
    int key;
    int value;
} HashItem;

// A simple hash function
int hash(int key, int size) {
    return abs(key) % size;
}

// Insert function for the hash map
void insert(HashItem* hashTable[], int key, int value, int size) {
    int index = hash(key, size);
    while (hashTable[index] != NULL) {
        index = (index + 1) % size; // Linear probing
    }
    HashItem* newItem = (HashItem*)malloc(sizeof(HashItem));
    newItem->key = key;
    newItem->value = value;
    hashTable[index] = newItem;
}

// Search function for the hash map
int search(HashItem* hashTable[], int key, int size) {
    int index = hash(key, size);
    while (hashTable[index] != NULL) {
        if (hashTable[index]->key == key) {
            return hashTable[index]->value;
        }
        index = (index + 1) % size;
    }
    return -1; // Not found
}

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    // Create a hash table to store the complements and their indices
    int hashSize = numsSize * 2; // Size of hash table
    HashItem* hashTable[hashSize];
    for (int i = 0; i < hashSize; i++) {
        hashTable[i] = NULL;
    }

    int* result = (int*)malloc(2 * sizeof(int));

    // Traverse the array
    for (int i = 0; i < numsSize; i++) {
        int complement = target - nums[i];
        int complementIndex = search(hashTable, complement, hashSize);
        
        if (complementIndex != -1) {
            result[0] = complementIndex;
            result[1] = i;
            *returnSize = 2;
            return result;
        }
        
        // Insert the current number and its index into the hash table
        insert(hashTable, nums[i], i, hashSize);
    }

    *returnSize = 0;
    return NULL; // No solution found (although we assume there is always a valid solution)
}