class Solution(object):
    def removeAnagrams(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        i = 1
        while i < len(words):
            # Si la palabra actual y la anterior son anagramas
            if sorted(words[i]) == sorted(words[i - 1]):
                # Se elimina la palabra actual
                words.pop(i)
            else:
                # Solo avanzamos si no hemos borrado nada
                i += 1
        return words
