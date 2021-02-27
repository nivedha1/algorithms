public class MatrixSpiral {



public static void main(String args[]){
    int[][] mat={{1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}};


    int rowS=0;
    int rowEnd=4;
    int colS=0;
    int colEnd=4;
    while(rowS<rowEnd && colS<colEnd){

        for(int i=colS;i<colEnd;i++){
            System.out.print(mat[rowS][i]+" ");
        }
        rowS++;
        for(int i=rowS;i<rowEnd;i++){
            System.out.print(mat[i][colEnd-1]+" ");
        }
        colEnd--;
        if(colS<colEnd&&rowS<rowEnd) {
            for (int i = colEnd-1; i >= colS; i--) {
                System.out.print(mat[rowEnd - 1][i]+" ");
            }
            rowEnd--;
            for (int i = rowEnd-1; i >= rowS; i--) {
                System.out.print(mat[i][colS]+" ");
            }
            colS++;
        }

    }

    }





}
