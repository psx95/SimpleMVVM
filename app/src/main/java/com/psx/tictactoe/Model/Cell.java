package com.psx.tictactoe.Model;

public class Cell {
    private Player player;

    public Cell (Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
