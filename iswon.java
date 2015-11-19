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
		String board[][] = chessboard.getBoard();
		int xup = posX, xdown = posX, yleft = posY, yright = posY;
		// 水平方向判别
		while (yleft >= 0 && board[posX][yleft] == ico) {
			yleft--;
		}
		while (yright < 22 && board[posX][yright] == ico) {
			yright++;
		}
		System.out.println(ico + "yleft=" + yleft + "  yright=" + yright);

		if (yright - yleft > 5)
			return true;
		// 竖直方向判别
		else {
			yleft = yright = posY;
			while (xup >= 0 && board[xup][posY] == ico) {
				xup--;
			}
			while (xdown < 22 && board[xdown][posY] == ico) {
				xdown++;
			}
			System.out.println(ico + "xup=" + xup + "  xdown=" + xdown);

			if (xdown - xup > 5)
				return true;
			// 左上到右下方向
			else {
				yleft = yright = posY;
				xup = xdown = posX;
				while (yleft >= 0 && xup >= 0 && board[xup][yleft] == ico) {
					yleft--;
					xup--;
				}
				while (yright < 22 && xdown < 22 && board[xdown][yright] == ico) {
					yright++;
					xdown++;
				}
				if (xdown - xup > 5)
					return true;
				// 右上到左下方向
				else {
					yleft = yright = posY;
					xup = xdown = posX;
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
						return true;
					else
						return false;
				}
			}

		}

	}