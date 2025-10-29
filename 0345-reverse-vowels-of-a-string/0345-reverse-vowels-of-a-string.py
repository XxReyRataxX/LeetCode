#
# @lc app=leetcode id=345 lang=python
#
# [345] Reverse Vowels of a String
#

# @lc code=start
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vocal = []
        for i in s:
            if i in 'aeiouAEIOU':

                vocal.append(i)

        vocal.reverse()

        # convertir la cadena a lista para poder asignar caracteres
        s_list = list(s)

        # mantener una posición de búsqueda para no reemplazar
        # posiciones ya modificadas: empezamos en 0 y avanzamos
        pos = 0
        for x in range(len(vocal)):
            for i in range(pos, len(s_list)):
                if s_list[i] in 'aeiouAEIOU':
                    s_list[i] = vocal[x]
                    pos = i + 1
                    break

        return ''.join(s_list)
                
# @lc code=end

