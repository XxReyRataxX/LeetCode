class Solution(object):
    def countPalindromicSubsequence(self, s):
        encontrados = set()

        for i in range(len(s)):
            prim = s[i]
            vistos_centro = set()
            iguales_despues = 0  # ← para detectar AAA

            for j in range(i+1, len(s)):

                if s[j] == prim:
                    iguales_despues += 1

                    # si hay al menos dos iguales → AAA existe
                    if iguales_despues >= 2:
                        encontrados.add((prim, prim, prim))

                    # generar palíndromos con centros ya vistos
                    for c in vistos_centro:
                        encontrados.add((prim, c, prim))

                else:
                    # cualquier distinto es posible centro
                    vistos_centro.add(s[j])

        return len(encontrados)
