package 배열;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
		char[][] arr = new char[m][n];
		int[][] check = new int[m][n];
		// 2차원 배열로 만듬
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = board[i].charAt(j);
			}
		}

		while (true) {
			int flag = 0;
			// 4개 확인
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (arr[i][j] != '@' && arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i + 1][j]
							&& arr[i][j] == arr[i + 1][j + 1]) {
						check[i][j] = 1;
						check[i][j + 1] = 1;
						check[i + 1][j] = 1;
						check[i + 1][j + 1] = 1;
					}
				}
			}
			// 점수세기 , 보드 수정
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] == 1) {
						answer++;
						flag=1;
						arr[i][j] = '@';
					}
				}
			}
			//점수판 리셋
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					check[i][j] = 0;
				}
			}

			// 블록 내리기
			
			for(int j=0;j<n;j++) {
				for(int i=m-1;i>=0;i--) {
					if(arr[i][j]=='@') {
						
						
						for(int k=i-1;k>=0;k--) {
							if(arr[k][j]!='@') {
								arr[i][j] = arr[k][j];
								arr[k][j] = '@';
								break;
							}
						}
					}
				}
			}
			
			
			
			//점수 증가 없으면 끝
			if(flag==0) {
				break;
			}
		}

		return answer;
    }
}