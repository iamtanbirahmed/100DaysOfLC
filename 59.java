class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n-1;
        int up = n-1;
        int down = 0;
        int curr = 1;
        int[][] matrix = new int[n][n];
        while(left<=right && down<=up){
            // left to right ; down row
            
            for(int i=left;i<=right;i++){
                matrix[down][i] = curr++;
            }
            
            // down to up ; right col
            
            for(int i=down+1;i<=up;i++){
                matrix[i][right] = curr++;
            }
            
            //right to left; up row
            if(up!=down){
                for(int i=right-1;i>=left;i--){
                    matrix[up][i] = curr++;
                }
            }
            
            // up to down; left col
            if(left!=right){
                for(int i=up-1;i>down;i--){
                    matrix[i][left] = curr++;
                }
            }
            
            left++;
            right--;
            down++;
            up--;
            
        }
        return matrix;
    }
}