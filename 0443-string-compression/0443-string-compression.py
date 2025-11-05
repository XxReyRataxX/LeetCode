class Solution(object):
    def compress(self, chars):
        """
        Comprime la lista de caracteres 'chars' in-place.
        :type chars: List[str]
        :rtype: int (la nueva longitud de la lista modificada)
        """
        n = len(chars)
        
        # Puntero para escribir el resultado comprimido en 'chars'
        write_ptr = 0
        
        # Puntero para leer la lista original
        i = 0
        
        while i < n:
            char_actual = chars[i]
            count = 0
            
            # Usamos 'j' para encontrar el final de la secuencia
            j = i
            
            # Contar la longitud de la secuencia
            while j < n and chars[j] == char_actual:
                count += 1
                j += 1 

            # --- Escribir el resultado en 'chars' (in-place) ---
            
            # 1. Escribir el carácter
            chars[write_ptr] = char_actual
            write_ptr += 1

            # 2. Escribir la cuenta (solo si es mayor que 1)
            if count > 1:
                # Convertir la cuenta a cadena y escribir CADA dígito en 'chars'
                for digit in str(count):
                    chars[write_ptr] = digit
                    write_ptr += 1
            
            # Mover el puntero principal 'i' al inicio de la siguiente secuencia
            i = j
            
        # Al final, 'chars' contendrá los elementos comprimidos
        # en los índices 0 hasta (write_ptr - 1).
        # Ejemplo: chars = ["a", "2", "b", "2", "c", "3", "c"]
        # El resultado comprimido es solo hasta el índice 5.
        
        # Devolvemos la nueva longitud
        return write_ptr

