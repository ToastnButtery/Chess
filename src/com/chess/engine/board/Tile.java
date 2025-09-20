package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public abstract class Tile{

    protected final int tileCoordinate;

    Tile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class emptyTile extends Tile{
        emptyTile(final int  coordinate){
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Piece getPiece(){
            return null;
        }
    }

    public static final class occupiedTile extends Tile{
        private final Piece pieceOnTile;
        occupiedTile(int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }

}