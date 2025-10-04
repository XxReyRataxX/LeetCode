class Solution {
    public int[] decode(int[] encoded) {
        int n= encoded.length+1;
        int [] sol = new int [n];
        int totalXor = 0;
        for (int i = 1; i <= n; i++) {   // antes lo hacías hasta 100000
        totalXor ^= i;
    }
        // 2. XOR de encoded en índices impares (1-indexed)
    int oddXor = 0;
    for (int i = 1; i < encoded.length; i += 2) {
        oddXor ^= encoded[i];
    }
    
    // 3. Encontrar perm[0]
    sol[0] = totalXor ^ oddXor;
    
    // 4. Reconstruir el resto
    for (int i = 0; i < encoded.length; i++) {
        sol[i + 1] = encoded[i] ^ sol[i];
    }
    
    return sol;
}

    }
