/*
 * @lc app=leetcode id=1404 lang=java
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        //paso de string binario a entero
        int numero=0;
       for (int i = 0; i < s.length(); i++) {
    // 1. Desplazamos el valor actual a la izquierda (multiplicar por 2)
    numero = numero * 2; 
    
    // 2. Sumamos el valor del caracter actual ('0' o '1')
    // Restamos '0' para convertir el char en su valor numérico real
    if (s.charAt(i) == '1') {
        numero = numero + 1;
    }
}
        int pasos=0;
        while (numero>1){
            if ((numero % 2) ==0){
                numero= numero/2;
            }else{
                numero++;
            }
            pasos++;
        }
        
        return pasos;
    }
}
// @lc code=end

