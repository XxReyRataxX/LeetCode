class Solution(object):
   def finalValueAfterOperations(self, operations):
        """
        :type operations: List[str]
        :rtype: int
        """
        contador = 0
        for i in range(len(operations)):
            if operations[i]== "X++" or operations[i]=="++X":
                contador+=1
            if operations[i]== "X--" or operations[i] =="--X":
                contador-=1
        return contador