from typing import List

class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        # Usamos un puntero 'i' para recorrer la lista.
        i = 0
        n = len(bits)
        
        while i < n:
            # Si estamos en la penúltima posición (n-2) y el bit actual es '1',
            # significa que el último '0' será consumido por un carácter de dos bits (10 o 11).
            # Por lo tanto, el último carácter NO es de un bit.
            if i == n - 2 and bits[i] == 1:
                return False
            
            # Estamos en el último bit (el '0' final garantizado por la restricción del problema).
            # Si llegamos aquí, significa que todos los caracteres anteriores fueron decodificados correctamente,
            # dejando el '0' final como su propio carácter de un bit.
            if i == n - 1 and bits[i] == 0:
                return True
            
            # --- Decodificación ---
            
            # Si el bit actual es '1', es el inicio de un carácter de dos bits (10 o 11).
            if bits[i] == 1:
                # Saltamos dos posiciones para consumir el par (1X).
                i += 2
            
            # Si el bit actual es '0', es un carácter de un bit (0).
            elif bits[i] == 0:
                # Saltamos una posición.
                i += 1
                
        # Si el bucle termina sin haber devuelto True al llegar al último '0' (esto 
        # puede pasar si el último '0' fue consumido por un carácter de dos bits, 
        # aunque la lógica anterior debería cubrirlo), devolvemos False.
        # En la mayoría de los casos correctos, el 'return True' se ejecuta dentro del bucle.
        return False