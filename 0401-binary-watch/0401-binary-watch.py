class Solution(object):
    def readBinaryWatch(self, turnedOn):
        resultado = []
        
        for hora in range(12):
            for minuto in range(60):
                
                if bin(hora).count("1") + bin(minuto).count("1") == turnedOn:
                    
                    # Formato correcto
                    tiempo = str(hora) + ":" + "{:02d}".format(minuto)
                    resultado.append(tiempo)
        
        return resultado
