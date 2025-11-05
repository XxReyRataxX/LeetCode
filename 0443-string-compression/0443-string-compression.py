class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        sol= ""
        consecutives=[]

        for i in range(len(chars)):
            j=i+1
            consecutives=[]
            consecutives.append(chars[i])
            for j in range(len(chars)):
                if chars[i] == chars[j]:
                    consecutives.append(chars[j])
                else:
                    break
            
            if len(consecutives) == 1:
                sol+=consecutives[0]

            else:
                sol += consecutives[0]
                sol+= str(len(consecutives))
        return len(sol)


        