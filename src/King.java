public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)) {
            System.out.println(line + " " + column + " " + toLine + " " + toColumn);
            if (((Math.abs(line - toLine) <= 1) && (Math.abs(column - toColumn) <= 1)) &&
                    ((Math.abs(line - toLine)) + Math.abs((column-toColumn)) > 0)) {
                System.out.println("Ok");
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard boardObj, int line, int column) {
        boolean r = false;
        String s = this.getSymbol();
        String c = this.getColor();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece hu = boardObj.board[i][j];
                if (hu != null && !this.getColor().equals(hu.color)) {
                    r = hu.canMoveToPosition(boardObj, i, j, line, column);
                    if (r) return true;
                }
            }
        }
        return false;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
