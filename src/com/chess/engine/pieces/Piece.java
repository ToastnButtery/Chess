package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.List;

public abstract class Piece {

    protected final int piece_posistion;
    protected final Alliance piece_Alliance;

    Piece(final int piece_position, final Alliance piece_Alliance){
        this.piece_Alliance=piece_Alliance;
        this.piece_posistion=piece_position;
    }

    public abstract List<Move> calculateLegalMoves(final Board board)

}