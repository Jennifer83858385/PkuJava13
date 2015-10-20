import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	ChessAI chessAI = new ChessAI();

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		
		int[] result = chessAI.chessAIPos(chessboard,WIN_COUNT);
		//���ϼ�������һ���µĵ�
		if(result!=null){
		chessboard.setAILastX(result[0]);
		chessboard.setAILastY(result[1]);
		}
		//int[] result = { posX, posY };
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		//�ֱ��ʾ��ǰ��ĺ���Ʋ�����е�
		String chessheng = "";
		String chessshu = "";
		String chesspei = "";
		String chessna = "";
		//ƥ�������
		String match = "\\.*+"+ico+"{"+WIN_COUNT+",}+\\.*";
		String[][] chessboardcurr = chessboard.getBoard();
		//�жϺ�����û�гɹ���
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
		
		//�ж�������û�гɹ���
		for(int i = 0; i<chessboard.BOARD_SIZE; i++){
			chessshu = chessshu + chessboardcurr[i][posY];
		}
		if(pickup(chessshu,ico)){
			return true;
		}
		
		//�ж�����û�гɹ���
		//�������������ⷽ��y = x + b
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
		
		//�ж�Ʋ��û�гɹ���
		//�������������ⷽ��y = -x + b
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
	 * Ҫ������ַ���
	 * @param ico
	 * ��ǰ������ɫ
	 * @return
	 * trueƥ��ɹ�
	 */
	public boolean pickup(String str, String ico){
		//��������ɫ��Ϊȥ������ɫ
		if(ico.equals(Chessman.BLACK.getChessman())){
			ico = Chessman.WHITE.getChessman();
		}
		else{
			ico = Chessman.BLACK.getChessman();
		}
		//str = str.replaceAll("\\[^"+ico+"]", " ");
		str = str.replaceAll("\\"+ico, " ");
		str = str.replaceAll("\\ʮ", " ");
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
