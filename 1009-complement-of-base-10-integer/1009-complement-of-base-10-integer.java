class Solution {
    public int bitwiseComplement(int n) {
        String binario = Integer.toBinaryString(n);
        char [] x = binario.toCharArray();

        for (int i=0;i<x.length;i++){
            if (x[i] == '1'){
                x[i] = '0';
            }else{
                x[i] = '1';
            }
        }
        String r = new String(x);

        int resultado = Integer.parseInt(r, 2);

        return resultado;

    }
}