package com.antumbrastation.schrodingerchess.board.moves;

import com.antumbrastation.schrodingerchess.board.ChessPiece;
import com.antumbrastation.schrodingerchess.board.PhantomChessState;
import com.antumbrastation.schrodingerchess.csp.StateRestraint;

public class MovePiece extends BaseMove {

    private int pieceNumber;

    private int newRow;
    private int newColumn;

    public MovePiece(StateRestraint newWaveFunction,
                     int pieceNumber, int newRow, int newColumn) {
        super((pieceNumber >= 8 && pieceNumber < 24 ? "p" : pieceNumber) + "-" + newRow + "," + newColumn, newWaveFunction);

        this.pieceNumber = pieceNumber;
        this.newRow = newRow;
        this.newColumn = newColumn;
    }

    @Override
    public void resolve(PhantomChessState resolveOn) {
        super.resolve(resolveOn);

        for (ChessPiece piece : resolveOn.getWhitePieces()) {
            if (pieceNumber == piece.getPieceNumber()) {
                piece.setRow(newRow);
                piece.setColumn(newColumn);
            }
        }

        for (ChessPiece piece : resolveOn.getBlackPieces()) {
            if (pieceNumber == piece.getPieceNumber()) {
                piece.setRow(newRow);
                piece.setColumn(newColumn);
            }
        }
    }
}
