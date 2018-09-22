class Solution:
    """
    @param A: a sparse matrix
    @param B: a sparse matrix
    @return: the result of A * B
    """
    def multiply(self, A, B):
        # write your code here
        
        # number of rows
        m = len(A) 
        # tranvese distant for 
        l = len(B)
        # NUMBER OF COLS
        n = len(B[0])
        
        res = [[0 for _ in range(n)] for _ in range(m)]
        # print(res)
        
        for i in range(m):
            for j in range(n):
                if A[i][j] == 0:
                    continue
                # print()
                for k in range(l):
                    # print(A[i][k])
                    # print(B[k][j])
                    res[i][j] += A[i][k] * B[k][j]
                # print
                # print('\n')
        return res
