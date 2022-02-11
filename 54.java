class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int down = 0;
        int right = matrix[0].length-1;
        int up = matrix.length-1;
        List<Integer> result = new ArrayList();
        while(left<=right && down<=up){
            // left-right, down row
            for(int i=left;i<=right;i++){
                result.add(matrix[down][i]);
            }
            
            // down-up, right col
            for(int i=down+1;i<=up;i++){
                result.add(matrix[i][right]);
            }
            
            if(down!=up){
                // right-left; up row
                for(int i = right-1;i>=left;i--){
                    result.add(matrix[up][i]);
                }
            }
            
            if(left!=right){
                // up-down; left col
                for(int i=up-1;i>down;i--){
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            down++;
            up--;
        }
        return result;
        
    }
}