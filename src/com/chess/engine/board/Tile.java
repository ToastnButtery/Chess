package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import javax.management.ImmutableDescriptor;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile{

    protected final int tileCoordinate;

    private static final Map<Integer,emptyTile> EMPTY_TILES= createAllPossibleEmptyTiles();

    private static Map<Integer, emptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, emptyTile> emptyTileMap=new HashMap<>();

        for(int i=0;i<64;i++){
            emptyTileMap.put(i, new emptyTile(i));
        }

        return ImmutableMap.copyOf(emptyTileMap);
    }

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