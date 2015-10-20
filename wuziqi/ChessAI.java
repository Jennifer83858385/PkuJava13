
public class ChessAI {
	
	/*
	 * 
	 * 1.自己有4个的，可以冲5
	 * 2.自己有3个的，对方有4个的，赌对方
	 * 3.自己有3个的，对方没有4个的，冲4
	 * 4.自己有2个的。对方有3个的，赌对方
	 * 5.自己有2个的，对方有2个的，冲3
	 * 6.自己有1个的，对方有2个的，赌对方
	 * 7。自己有1个的，对方有1个的，冲2
	 * 8.自己有0个的，对方有1个的，赌对方
	 * 9.自己有0个的，对方有0个的，冲1
	 * 总而言之，先判断自己有没有（WIN_SIZE - 1）个的，
	 * 在判断对方有没有（WIN_SIZE - 1）个的，
	 * 有就堵没有就判断（WIN_SIZE - 2）的，以此类推
	 * 直到WIN_SIZE-WIN_SIZE
	 * 
	 */
	
	/*
	 * 可以找最后电脑和人下的最后点，四个方向最大连通数。
	 * 电脑最大连通数>=人最大连通数，电脑冲，否则堵人
	 * 
	 */
	
	//电脑下棋算法
	//输入Chessboard类,这里包含了棋盘信息，电脑和人最后一次下的点,win_size表示几子祺·
	//返回下的点
	public int[] chessAIPos(Chessboard chessboard, int win_size){
		String[][] board = chessboard.getBoard();
		int manLastX = chessboard.getLastX();
		int manLastY = chessboard.getLastY();
		int AILastX = chessboard.getAILastX();
		int AILastY = chessboard.getAILastY();
		
		String maxmancount = maxCount(board,Chessman.BLACK.getChessman(),manLastX,manLastY,win_size);
		String maxAIcount = maxCount(board,Chessman.WHITE.getChessman(),AILastX,AILastY,win_size);
		System.out.println("maxmancount"+maxmancount);
		System.out.println("maxAIcount"+maxAIcount);
		String[] arrman =  maxmancount.split("\\+");
		String[] arrAI = maxAIcount.split("\\+");
		int arrmanInt = Integer.parseInt(arrman[0]);
		int arrAIInt = Integer.parseInt(arrAI[0]);
		if(arrAIInt >= arrmanInt){
			System.out.println("进攻");
			return AIAttack(arrman[1],arrAI[1],board,Chessman.BLACK.getChessman());
		}
		else{
			System.out.println("防守");
			return AIDefense(arrman[1], board, Chessman.BLACK.getChessman());
		}
		//for (int j = 0; j < maxcount.length; j++) { 
		//	for (int i = 0; i < maxcount[1].length; i++) { 
		//	System.out.print(maxcount[j][i]);
		//	}
		//}
		//System.out.println("in");
		//int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		//int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		//System.out.println(posX+":::"+posY);
		//String[][] board = chessboard.getBoard();
		//while (board[posX][posY] != "十") {
		//	posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		//	posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		//}
		//int[] result = {posX, posY};
		//System.out.println("电脑最后一次下的位置："+AILastX+","+AILastY+"----人最后一次下的位置："+manLastX+","+manLastY);
		//return result;
	}
	
	//找最大连通数算法
	//输入棋盘。棋子颜色。当前坐标中心
	//返回String类型字符串 格式为  最大连通次数+坐标+横竖撇捺哪种情况
	public static String maxCount(String[][] board,String ico, int x, int y, int win_size){
		if(x == -1 || y ==-1){
			return "-1";
		}
		//System.out.println("xyxy:"+x+":::"+y);
		//最大横行和当前横行，临时横行：导数据用
		int[][] maxResult = new int[win_size][2];
		int[][] curResult = new int[win_size][2];
		int[][] tmpResult = new int[win_size][2];
		int count = -1;
		String direction = "";
		for (int j = 0; j < curResult.length; j++) { 
			for (int i = 0; i < curResult[1].length; i++) { 
			System.out.print(curResult[j][i]);
			}
		}System.out.println("----");
		int countHeng = 0;
		int countShu = 0;
		//----------------------------找衡行----------------
		//1.左侧
		for(int i = 1; y-i>=0; i++){
			if(ico.equals(board[x][y-i])){
				tmpResult[i-1][0] = x;
				tmpResult[i-1][1] = y-i;
				countHeng++;
			}
			else{
				i = Chessboard.BOARD_SIZE;
			}
		}
		//2.反转，从小到大顺序，并结束循环
		for(int j = countHeng-1,k=0; j>=0; j--,k++){
			curResult[k][0] = tmpResult[j][0];
			curResult[k][1] = tmpResult[j][1];
		}
		//3.加上当前点
		curResult[countHeng][0] = x;
		curResult[countHeng][1] = y;
		countHeng++;
		//4.右侧
		for(int i = 1; y+i<Chessboard.BOARD_SIZE; i++){
			if(ico.equals(board[x][y+i])){
				//System.out.println("in777");
				curResult[countHeng][0] = x;
				curResult[countHeng][1] = y+1;
				countHeng++;
			}
			else{
				i = Chessboard.BOARD_SIZE;
			}
		}
		System.out.println("countHeng:"+countHeng);
		maxResult = curResult;
		count = countHeng;
		direction = "H";
		tmpResult = new int[win_size][2];
		curResult = new int[win_size][2];
		
		//---------------------找竖行--------------------------------
		//1.上面
		for(int i = 1; x-i>=0; i++){
			if(ico.equals(board[x-i][y])){
				tmpResult[i-1][0] = x-i;
				tmpResult[i-1][1] = y;
				countShu++;
			}
			else{
				i = Chessboard.BOARD_SIZE;
			}
		}
		//2.反转，从小到大顺序，并结束循环
		for(int j = countShu-1,k=0; j>=0; j--,k++){
			curResult[k][0] = tmpResult[j][0];
			curResult[k][1] = tmpResult[j][1];
			//System.out.println("curResult[k][0]:"+curResult[k][0]+"1"+curResult[k][1]);
		}
		
		//3.加上自己
		curResult[countShu][0] = x;
		curResult[countShu][1] = y;
		countShu++;
		//4.下面
		for(int i = 1; x+i<Chessboard.BOARD_SIZE; i++){
			if(ico.equals(board[x+i][y])){
				//System.out.println("in777");
				curResult[countShu][0] = x+i;
				curResult[countShu][1] = y;
				countShu++;
			}
			else{
				i = Chessboard.BOARD_SIZE;
			}
		}
		System.out.println("countShu:"+countShu);
		
		if(countShu >= countHeng){
			maxResult = new int[win_size][2];
			maxResult = curResult;
			count = countShu;
			direction = "S";
		}
		
		String result = "";
		result = result + count + "+";
		for (int j = 0; j < maxResult.length; j++) { 
			for (int i = 0; i < maxResult[1].length; i++) { 
				result = result + maxResult[j][i] + ",";
			}
		}
		result = result + direction;
		return result;
	}
	
	//电脑攻击策略
	//参数分别是str：最大连通数方法返回部分值，包括坐标点和横竖撇捺(strman人的最大连通值)
	//board棋盘
	//ico人的棋子颜色
	public static int[] AIAttack(String strman,String str, String[][] board, String ico){
		//int[] result = {1,2};
		String[] arrstr = str.split("\\,");
		int max = arrstr.length - 1;
		int xFirst = Integer.parseInt(arrstr[0]);
		int yFirst = Integer.parseInt(arrstr[1]);
		int xLast = xFirst;
		int yLast = yFirst;
		for(int i=0;i<arrstr.length-1;i=i+2){
			if(!(arrstr[i].equals("0") && arrstr[i+1].equals("0"))){
				xLast = Integer.parseInt(arrstr[i]);
				yLast = Integer.parseInt(arrstr[i+1]);
			}
			else{
				break;
			}
		}
		System.out.println("arrstr[max]:"+arrstr[max]);
		
		if(arrstr[max].equals("H")){
			if(yFirst > 0){
				if(board[xFirst][yFirst-1].equals("十")){
					int[] resultH = {xFirst,yFirst-1};//要加1！！！！！！！！
					return resultH;
				}
			}
			if(yLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast][yLast+1].equals("十")){
					int[] resultH = {xLast,yLast+1};//要加1！！！！！！！！
					return resultH;
				}
			}
			//左右都不能下的情况，随机下棋
			//应该转成防守！！！！！！！！还没写
			return AIDefense(strman,board,ico);
		}
		else if((arrstr[max].equals("S"))){
			if(xFirst > 0){
				if(board[xFirst - 1][yFirst].equals("十")){
					int[] resultS = {xFirst-1,yFirst};//要加1！！！！！！！！
					return resultS;
				}
			}
			if(xLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast+1][yLast].equals("十")){
					int[] resultS = {xLast+1,yLast};//要加1！！！！！！！！
					return resultS;
				}
			}
			//左右都不能下的情况，随机下棋
			//应该转成防守！！！！！！！！还没写
			return AIDefense(strman,board,ico);
		}
		//System.out.println(arrstr[0]+">>>>>>>>>>>>");
		return AIRandom(board);
		//return result;
	}
	
	//AI防守策略
	//参数分别是str：最大连通数方法返回部分值，包括坐标点和横竖撇捺
	//board棋盘
	//ico人的棋子颜色
	public static int[] AIDefense(String str, String[][] board, String ico){
		//int[] result = {1,2};
		String[] arrstr = str.split("\\,");
		int max = arrstr.length - 1;
		int xFirst = Integer.parseInt(arrstr[0]);
		int yFirst = Integer.parseInt(arrstr[1]);
		int xLast = xFirst;
		int yLast = yFirst;
		for(int i=0;i<arrstr.length-1;i=i+2){
			if(!(arrstr[i].equals("0") && arrstr[i+1].equals("0"))){
				xLast = Integer.parseInt(arrstr[i]);
				yLast = Integer.parseInt(arrstr[i+1]);
			}
			else{
				break;
			}
		}
		if(arrstr[max].equals("H")){
			if(yFirst > 0){
				if(board[xFirst][yFirst-1].equals("十")){
					int[] resultH = {xFirst,yFirst-1};//要加1！！！！！！！！
					return resultH;
				}
			}
			if(yLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast][yLast+1].equals("十")){
					int[] resultH = {xLast,yLast+1};//要加1！！！！！！！！
					return resultH;
				}
			}
			//左右都不能下的情况，随机下棋
			//应该转成防守！！！！！！！！还没写
			return AIRandom(board);
		}
		else if((arrstr[max].equals("S"))){
			if(xFirst > 0){
				if(board[xFirst - 1][yFirst].equals("十")){
					int[] resultS = {xFirst-1,yFirst};//要加1！！！！！！！！
					return resultS;
				}
			}
			if(xLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast+1][yLast].equals("十")){
					int[] resultS = {xLast+1,yLast};//要加1！！！！！！！！
					return resultS;
				}
			}
			//左右都不能下的情况，随机下棋
			//应该转成防守！！！！！！！！还没写
			return AIRandom(board);
		}
		//System.out.println(arrstr[0]+">>>>>>>>>>>>");
		
		return AIRandom(board);
	}
	
	//电脑随机算法
	public static int[] AIRandom(String[][] board){
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = {posX, posY};
		return result;
	}
}
