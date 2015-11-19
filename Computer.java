/**
*我自创的类主要用来选择最佳位置落子
*属性：棋盘、棋盘上每一点的势
*方法：pointPower（）、choosePos（）
*/

public class Computer {
	public static final int BOARD_SIZE = 22;
	// 势的概念：在棋盘中越靠近中间的位置越有利，势也越大
	public static int[][] shi = {
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,
					0 },
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 10, 9, 8, 7, 6, 5, 4, 3,
					2, 1 },
			{ 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 11, 10, 9, 8, 7, 6, 5, 4,
					3, 2 },
			{ 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 13, 12, 11, 10, 9, 8, 7, 6,
					5, 4, 3 },
			{ 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 13, 12, 11, 10, 9, 8,
					7, 6, 5, 4 },
			{ 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 14, 13, 12, 11, 10, 9,
					8, 7, 6, 5 },
			{ 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16, 15, 14, 13, 12, 11,
					10, 9, 8, 7, 6 },
			{ 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 17, 16, 15, 14, 13, 12,
					11, 10, 9, 8, 7 },
			{ 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 18, 17, 16, 15, 14, 13,
					12, 11, 10, 9, 8 },
			{ 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 19, 18, 17, 16, 15,
					14, 13, 12, 11, 10, 9 },
			{ 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 19, 18, 17, 16,
					15, 14, 13, 12, 11, 10 },
			{ 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 19, 18, 17, 16,
					15, 14, 13, 12, 11, 10 },
			{ 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 19, 18, 17, 16, 15,
					14, 13, 12, 11, 10, 9 },
			{ 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 18, 17, 16, 15, 14, 13,
					12, 11, 10, 9, 8 },
			{ 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 17, 16, 15, 14, 13, 12,
					11, 10, 9, 8, 7 },
			{ 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16, 15, 14, 13, 12, 11,
					10, 9, 8, 7, 6 },
			{ 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 14, 13, 12, 11, 10, 9,
					8, 7, 6, 5 },
			{ 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 13, 12, 11, 10, 9, 8,
					7, 6, 5, 4 },
			{ 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 13, 12, 11, 10, 9, 8, 7, 6,
					5, 4, 3 },
			{ 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 11, 10, 9, 8, 7, 6, 5, 4,
					3, 2 },
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 10, 9, 8, 7, 6, 5, 4, 3,
					2, 1 },
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,
					0 }, };
	public String board[][];

	public Computer(Chessboard che) {
		this.board = che.getBoard();
	}

	/**
	 * @return 在棋盘中选出最佳落子位置
	 */
	public int[] choosePos() {
		int[] pos = new int[2];
		float max = 0;
		for (int j = 0; j < BOARD_SIZE - 1; j++) {
			for (int i = 0; i < BOARD_SIZE - 1; i++) {
				if (board[i][j] == "十") {
					float a = pointPower(i, j, Chessman.WHITE.getChessman());
					float b = pointPower(i, j, Chessman.BLACK.getChessman());
					if (a < 0) {
						pos[0] = i;
						pos[1] = j;

						return pos;
					} else if (b < 0) {
						max = Integer.MAX_VALUE;
						pos[0] = i;
						pos[1] = j;
					} else if (b > max || a > max) {
						max = a > b ? a : b;
						pos[0] = i;
						pos[1] = j;
					}

				}
			}
		}
		return pos;
	}

	/**
	 * @param posX
	 *            X坐标
	 * @param posY
	 *            Y坐标
	 * @param ico
	 *            标志对战双方
	 * @return 我方在（X,Y）这点落子有利程度的量化（权）
	 */
	public float pointPower(int posX, int posY, String ico) {
		int xup = posX - 1, xdown = posX + 1, yleft = posY - 1, yright = posY + 1;
		float sum = (float) (shi[posX][posY] / 20.0);
		int[] line = new int[4];
		// 水平方向判别
		while (yleft >= 0 && board[posX][yleft] == ico) {
			yleft--;
		}
		while (yright < 22 && board[posX][yright] == ico) {
			yright++;
		}

		if (yright - yleft > 5)
			return -1;
		// 竖直方向判别
		else {
			line[0] = (yright - yleft);
			yleft = posY - 1;
			yright = posY + 1;
			while (xup >= 0 && board[xup][posY] == ico) {
				xup--;
			}
			while (xdown < 22 && board[xdown][posY] == ico) {
				xdown++;
			}

			if (xdown - xup > 5)
				return -1;
			// 左上到右下方向
			else {
				line[1] = (yright - yleft);
				yleft = posY - 1;
				yright = posY + 1;
				xup = posX - 1;
				xdown = posX + 1;
				while (yleft >= 0 && xup >= 0 && board[xup][yleft] == ico) {
					yleft--;
					xup--;
				}
				while (yright < 22 && xdown < 22 && board[xdown][yright] == ico) {
					yright++;
					xdown++;
				}
				if (xdown - xup > 5)
					return -1;
				// 右上到左下方向
				else {
					line[2] = yright - yleft;
					yleft = posY - 1;
					yright = posY + 1;
					xup = posX - 1;
					xdown = posX + 1;
					while (yright < 22 && xup >= 0 && board[xup][yright] == ico) {
						yright++;
						xup--;
					}
					while (yleft >= 0 && xdown < 22
							&& board[xdown][yleft] == ico) {
						yleft--;
						xdown++;
					}
					if (yright - yleft > 5)
						return -1;
					else
						line[3] = (yright - yleft);

				}
			}

		}
		int maxone = 0;
		for (int i = 0; i < 4; i++) {
			if (line[i] > maxone)
				maxone = line[i];
		}
		//
		sum += (line[1] + line[2] + line[3] + line[0]) / 2.0 + maxone;
		return sum;

	}

}
