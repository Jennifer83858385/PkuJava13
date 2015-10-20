import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	ChessAI chessAI = new ChessAI();

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		
		int[] result = chessAI.chessAIPos(chessboard,WIN_COUNT);
		//存上计算机最后一次下的点
		if(result!=null){
		chessboard.setAILastX(result[0]);
		chessboard.setAILastY(result[1]);
		}
		//int[] result = { posX, posY };
		return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		//分别表示当前点的横竖撇捺所有点
		String chessheng = "";
		String chessshu = "";
		String chesspei = "";
		String chessna = "";
		//匹配的条件
		String match = "\\.*+"+ico+"{"+WIN_COUNT+",}+\\.*";
		String[][] chessboardcurr = chessboard.getBoard();
		//判断横着有没有成功的
		for(int i = 0; i<chessboard.BOARD_SIZE; i++){
			chessheng = chessheng + chessboardcurr[posX][i];
			
			//System.out.println(chessheng);
			//if(chessheng.toString().matches(match)){
			//	return true;
			//}
		}
		if(pickup(chessheng,ico)){
			return true;
		}
		
		//判断竖着有没有成功的
		for(int i = 0; i<chessboard.BOARD_SIZE; i++){
			chessshu = chessshu + chessboardcurr[i][posY];
		}
		if(pickup(chessshu,ico)){
			return true;
		}
		
		//判断捺有没有成功的
		//这种情况就是求解方程y = x + b
		int b = posY - posX; 
		//System.out.println(b);
		if(b>=0){
			for(int i = 0; i+b < chessboard.BOARD_SIZE; i++){
				chessna = chessna + chessboardcurr[i][i+b];
			}
		}
		else{
			b = b*(-1);//System.out.println(b);
			for(int i = 0; i+b < chessboard.BOARD_SIZE; i++){
				//System.out.println(chessboardcurr[0][0]);
				chessna = chessna + chessboardcurr[i+b][i];
			}
		}
		if(pickup(chessna,ico)){
			return true;
		}
		
		//判断撇有没有成功的
		//这种情况就是求解方程y = -x + b
		int p = posY + posX; 
		System.out.println("p===:"+p);
		if(p<chessboard.BOARD_SIZE){
			for(int i = 0; p - i >= 0; i++){
				chesspei = chesspei + chessboardcurr[i][p - i];
			}
		}
		else{
			for(int i = chessboard.BOARD_SIZE-1; p - i <= chessboard.BOARD_SIZE-1; i--){
				chesspei = chesspei + chessboardcurr[i][p - i];
			}
		}
		//for(int i = 0; p - i >= 0; i++){
			//chesspei = chesspei + chessboardcurr[i][p - i];
		//}
		if(pickup(chesspei,ico)){
			return true;
		}
		
		//System.out.println(chessboard.BOARD_SIZE);
		//System.out.println(Chessman.BLACK.getChessman());
		return false;
	}
	
	/**
	 * 
	 * @param str
	 * 要处理的字符串
	 * @param ico
	 * 当前棋子颜色
	 * @return
	 * true匹配成功
	 */
	public boolean pickup(String str, String ico){
		//将棋子颜色变为去除的颜色
		if(ico.equals(Chessman.BLACK.getChessman())){
			ico = Chessman.WHITE.getChessman();
		}
		else{
			ico = Chessman.BLACK.getChessman();
		}
		//str = str.replaceAll("\\[^"+ico+"]", " ");
		str = str.replaceAll("\\"+ico, " ");
		str = str.replaceAll("\\十", " ");
		//System.out.println(str+"00"+ico);
		String[] newstr = str.split(" ");
		for(int i = 0; i < newstr.length; i++){
			if(newstr[i].length() >= WIN_COUNT){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
