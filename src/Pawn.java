public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPos(toLine)&& (column==toColumn)) {
            if ((toLine - line) > 0) {
                if (color.equals("White") && (line == 1) && (toLine - line) == 2) {
                    return true;
                } else if (color.equals("White") && (toLine - line) == 1) {
                    return true;
                } else return false;
            } else if ((toLine - line) < 0) {
                if (color.equals("Black") && (line == 6) && (line - toLine) == 2) {
                    return true;
                } else if (color.equals("Black") && (line - toLine) == 1) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

}
