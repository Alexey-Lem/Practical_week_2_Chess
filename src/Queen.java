public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)){
            int sl = line - toLine;
            int cl = column - toColumn;
            if (((line != toLine) && (column != toColumn)) &&
                    (!this.getColor().equals(chessBoard.board[toLine][toColumn]))){

                if ((line - column) == (toLine - toColumn)) {
                    for (int i = 1; i < Math.abs(sl); i++) {
                        if (sl > 0) {
                            if (chessBoard.board[line - i][column - i] != null) return false;
                        } else   {
                            if (chessBoard.board[line + i][column + i] != null) return false;
                        }
                    }
                    return true;
                } else if ((line + column) == (toLine + toColumn)){
                    for (int i = 1; i < Math.abs(sl); i++) {
                        if (sl > 0) {
                            if (chessBoard.board[line - i][column + i] != null) return false;
                        } else  {
                            if (chessBoard.board[line + i][column - i] != null) return false;
                        }
                    }
                    return true;
                } else return false;
            }

            if (((line != toLine) ^ (column != toColumn)) && (!this.getColor().equals(chessBoard.board[toLine][toColumn]))) {
                if (column != toColumn) {
                    for (int i = 1; i < Math.abs(cl); i++) {
                        if (cl > 0) {
                            if (chessBoard.board[line][column - i] != null) return false;
                        } else {
                            if (chessBoard.board[line][column + i] != null) return false;
                        }
                    }
                } else if (line != toLine) {
                    for (int i = 1; i < Math.abs(sl); i++) {
                        if (sl > 0) {
                            if (chessBoard.board[line - i][column] != null) return false;
                        } else {
                            if (chessBoard.board[line + 1][column] != null) return false;
                        }
                    }
                }
                return true;
            } else return false;

        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
