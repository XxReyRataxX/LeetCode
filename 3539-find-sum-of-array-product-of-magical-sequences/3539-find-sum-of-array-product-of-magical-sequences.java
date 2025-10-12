import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    private int m, k, n;
    private int[] nums;
    // DP[j][used][carry][set_bits]
    private Long[][][][] memo;
    
    // Precomputed values
    private long[][] powers; // powers[j][c] = nums[j]^c % MOD
    private long[] invFact;  // invFact[c] = (c!)^{-1} % MOD
    private long factM;      // m! % MOD

    // Modular Exponentiation (a^b % mod)
    private long modPow(long base, int exp, int mod) {
        long result = 1;
        long b = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * b) % mod;
            b = (b * b) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Modular Inverse using Fermat's Little Theorem (a^{mod-2} % mod)
    private long modInverse(long n, int mod) {
        return modPow(n, mod - 2, mod);
    }
    
    // Precompute factorials and inverse factorials up to m
    private void precompute() {
        // Precompute Factorials and Inverse Factorials
        long[] fact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        factM = fact[m];
        invFact = new long[m + 1];
        invFact[m] = modInverse(fact[m], MOD);
        for (int i = m - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
        
        // Precompute powers[j][c] = nums[j]^c % MOD
        powers = new long[n][m + 1];
        for (int j = 0; j < n; j++) {
            powers[j][0] = 1;
            for (int c = 1; c <= m; c++) {
                powers[j][c] = (powers[j][c - 1] * nums[j]) % MOD;
            }
        }
    }

    // Dynamic Programming function
    private long dp(int j, int used, int carry, int set_bits) {
        // Base case: All indices considered
        if (j == n) {
            // Must have used exactly m elements
            if (used != m) return 0;
            
            // Check the final set bit condition, including the remaining carry
            if (set_bits + Long.bitCount(carry) == k) {
                return 1; // Base case for the multiplicative part (product of f_i(c_i))
            }
            return 0;
        }

        if (memo[j][used][carry][set_bits] != null) {
            return memo[j][used][carry][set_bits];
        }

        long total = 0;
        // Iterate over the count c_j for the current index j
        for (int c_j = 0; c_j <= m - used; c_j++) {
            int new_used = used + c_j;
            
            // Calculate bit j and the new carry
            int sum_at_j = c_j + carry;
            int bit_j = sum_at_j & 1;
            int new_carry = sum_at_j >> 1;

            int new_set_bits = set_bits + bit_j;

            // Pruning: if we already have too many set bits
            if (new_set_bits > k) continue;

            // Recursive call for the next index j+1
            long res = dp(j + 1, new_used, new_carry, new_set_bits);
            
            if (res > 0) {
                // Multiplicative factor f_j(c_j) = (nums[j]^c_j / c_j!) % MOD
                long f_j = (powers[j][c_j] * invFact[c_j]) % MOD;
                
                // DP transition: DP[j+1] += DP[j] * f_j(c_j)
                total = (total + (res * f_j) % MOD) % MOD;
            }
        }

        return memo[j][used][carry][set_bits] = total;
    }

    public int magicalSum(int m, int k, int[] nums) {
        this.m = m;
        this.k = k;
        this.n = nums.length;
        this.nums = nums;

        precompute();

        // The max value for carry is m (30), max set_bits is k (30).
        // Array size: n+1, m+1, m+1, k+1
        memo = new Long[n + 1][m + 1][m + 1][k + 1];

        // Initial call: j=0, used=0, carry=0, set_bits=0
        long totalSumWithoutM_Fact = dp(0, 0, 0, 0);

        // Final result = (Sum of DP products) * m! % MOD
        long finalResult = (totalSumWithoutM_Fact * factM) % MOD;
        
        return (int) finalResult;
    }
}