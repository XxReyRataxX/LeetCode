class Solution {
    public int maxArea(int[] height) {
        //encontrar maximo
        int max = Integer.MIN_VALUE;
        int indicemax=0;
        int indicemax2=0;
        int max2=0;

       for (int i = 0; i < height.length; i++) {
        if (height[i] > max){
            max = height[i];
            indicemax= i;
        } 
        }

        //busqueda de segundo maximo que cumpla la condicion
        for (int j=indicemax;j<height.length;j++){
            if (height[j]<=max){
                if(indicemax2 < j){
                    indicemax2=j;
                    max2=height[j];

                }
            }

        }
        return (indicemax2 - indicemax) * max2;

        
    }
}