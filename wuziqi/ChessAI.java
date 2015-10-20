
public class ChessAI {
	
	/*
	 * 
	 * 1.�Լ���4���ģ����Գ�5
	 * 2.�Լ���3���ģ��Է���4���ģ��ĶԷ�
	 * 3.�Լ���3���ģ��Է�û��4���ģ���4
	 * 4.�Լ���2���ġ��Է���3���ģ��ĶԷ�
	 * 5.�Լ���2���ģ��Է���2���ģ���3
	 * 6.�Լ���1���ģ��Է���2���ģ��ĶԷ�
	 * 7���Լ���1���ģ��Է���1���ģ���2
	 * 8.�Լ���0���ģ��Է���1���ģ��ĶԷ�
	 * 9.�Լ���0���ģ��Է���0���ģ���1
	 * �ܶ���֮�����ж��Լ���û�У�WIN_SIZE - 1�����ģ�
	 * ���ж϶Է���û�У�WIN_SIZE - 1�����ģ�
	 * �оͶ�û�о��жϣ�WIN_SIZE - 2���ģ��Դ�����
	 * ֱ��WIN_SIZE-WIN_SIZE
	 * 
	 */
	
	/*
	 * �����������Ժ����µ����㣬�ĸ����������ͨ����
	 * ���������ͨ��>=�������ͨ�������Գ壬�������
	 * 
	 */
	
	//���������㷨
	//����Chessboard��,���������������Ϣ�����Ժ������һ���µĵ�,win_size��ʾ��������
	//�����µĵ�
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
			System.out.println("����");
			return AIAttack(arrman[1],arrAI[1],board,Chessman.BLACK.getChessman());
		}
		else{
			System.out.println("����");
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
		//while (board[posX][posY] != "ʮ") {
		//	posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		//	posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		//}
		//int[] result = {posX, posY};
		//System.out.println("�������һ���µ�λ�ã�"+AILastX+","+AILastY+"----�����һ���µ�λ�ã�"+manLastX+","+manLastY);
		//return result;
	}
	
	//�������ͨ���㷨
	//�������̡�������ɫ����ǰ��������
	//����String�����ַ��� ��ʽΪ  �����ͨ����+����+����Ʋ���������
	public static String maxCount(String[][] board,String ico, int x, int y, int win_size){
		if(x == -1 || y ==-1){
			return "-1";
		}
		//System.out.println("xyxy:"+x+":::"+y);
		//�����к͵�ǰ���У���ʱ���У���������
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
		//----------------------------�Һ���----------------
		//1.���
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
		//2.��ת����С����˳�򣬲�����ѭ��
		for(int j = countHeng-1,k=0; j>=0; j--,k++){
			curResult[k][0] = tmpResult[j][0];
			curResult[k][1] = tmpResult[j][1];
		}
		//3.���ϵ�ǰ��
		curResult[countHeng][0] = x;
		curResult[countHeng][1] = y;
		countHeng++;
		//4.�Ҳ�
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
		
		//---------------------������--------------------------------
		//1.����
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
		//2.��ת����С����˳�򣬲�����ѭ��
		for(int j = countShu-1,k=0; j>=0; j--,k++){
			curResult[k][0] = tmpResult[j][0];
			curResult[k][1] = tmpResult[j][1];
			//System.out.println("curResult[k][0]:"+curResult[k][0]+"1"+curResult[k][1]);
		}
		
		//3.�����Լ�
		curResult[countShu][0] = x;
		curResult[countShu][1] = y;
		countShu++;
		//4.����
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
	
	//���Թ�������
	//�����ֱ���str�������ͨ���������ز���ֵ�����������ͺ���Ʋ��(strman�˵������ֵͨ)
	//board����
	//ico�˵�������ɫ
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
				if(board[xFirst][yFirst-1].equals("ʮ")){
					int[] resultH = {xFirst,yFirst-1};//Ҫ��1����������������
					return resultH;
				}
			}
			if(yLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast][yLast+1].equals("ʮ")){
					int[] resultH = {xLast,yLast+1};//Ҫ��1����������������
					return resultH;
				}
			}
			//���Ҷ������µ�������������
			//Ӧ��ת�ɷ��أ�����������������ûд
			return AIDefense(strman,board,ico);
		}
		else if((arrstr[max].equals("S"))){
			if(xFirst > 0){
				if(board[xFirst - 1][yFirst].equals("ʮ")){
					int[] resultS = {xFirst-1,yFirst};//Ҫ��1����������������
					return resultS;
				}
			}
			if(xLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast+1][yLast].equals("ʮ")){
					int[] resultS = {xLast+1,yLast};//Ҫ��1����������������
					return resultS;
				}
			}
			//���Ҷ������µ�������������
			//Ӧ��ת�ɷ��أ�����������������ûд
			return AIDefense(strman,board,ico);
		}
		//System.out.println(arrstr[0]+">>>>>>>>>>>>");
		return AIRandom(board);
		//return result;
	}
	
	//AI���ز���
	//�����ֱ���str�������ͨ���������ز���ֵ�����������ͺ���Ʋ��
	//board����
	//ico�˵�������ɫ
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
				if(board[xFirst][yFirst-1].equals("ʮ")){
					int[] resultH = {xFirst,yFirst-1};//Ҫ��1����������������
					return resultH;
				}
			}
			if(yLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast][yLast+1].equals("ʮ")){
					int[] resultH = {xLast,yLast+1};//Ҫ��1����������������
					return resultH;
				}
			}
			//���Ҷ������µ�������������
			//Ӧ��ת�ɷ��أ�����������������ûд
			return AIRandom(board);
		}
		else if((arrstr[max].equals("S"))){
			if(xFirst > 0){
				if(board[xFirst - 1][yFirst].equals("ʮ")){
					int[] resultS = {xFirst-1,yFirst};//Ҫ��1����������������
					return resultS;
				}
			}
			if(xLast < Chessboard.BOARD_SIZE-1){
				if(board[xLast+1][yLast].equals("ʮ")){
					int[] resultS = {xLast+1,yLast};//Ҫ��1����������������
					return resultS;
				}
			}
			//���Ҷ������µ�������������
			//Ӧ��ת�ɷ��أ�����������������ûд
			return AIRandom(board);
		}
		//System.out.println(arrstr[0]+">>>>>>>>>>>>");
		
		return AIRandom(board);
	}
	
	//��������㷨
	public static int[] AIRandom(String[][] board){
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = {posX, posY};
		return result;
	}
}
