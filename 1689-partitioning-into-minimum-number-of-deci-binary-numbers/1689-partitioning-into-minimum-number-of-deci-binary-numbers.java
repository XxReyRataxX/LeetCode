class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        // Recorremos cada carácter del String
        for (int i = 0; i < n.length(); i++) {
            // Convertimos el carácter actual a su valor numérico
            // '0' es 48 en ASCII, así que restamos '0' para obtener el int
            int digit = n.charAt(i) - '0';
            
            // Si encontramos un dígito mayor, actualizamos nuestro máximo
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            
            // Optimización: si ya encontramos un 9, no hay nada mayor, paramos
            if (maxDigit == 9) return 9;
        }
        
        return maxDigit;
    }
}