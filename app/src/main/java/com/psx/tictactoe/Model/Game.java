package com.psx.tictactoe.Model;

import android.arch.lifecycle.MutableLiveData;

public class Game {

    private Player player1;
    private Player player2;

    private Player currentPlayer = player1;
    public MutableLiveData<Player> winner = new MutableLiveData<>();

    private Cell[][] cells;

    public Game(String playerOne, String playerTwo) {
        cells = new Cell[3][3];
        player1 = new Player(playerOne, "X");
        player2 = new Player(playerTwo, "O");
        currentPlayer = player1;
    }
    public void switchPlayer () {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasGameEnded () {
        if (hasThreeVerticalCells() || hasThreeHorizontalCells() || hasThreeDiagonalCells()) {
            winner.setValue(currentPlayer);
            return true;
        }
        return false;
    }

    private boolean hasThreeHorizontalCells() {
        for (int i =0 ;i < 3; i++) {
            if (areEqual(cells[i][0],cells[i][1],cells[i][2]))
                return true;
        }
        return false;
    }

    private boolean hasThreeDiagonalCells() {
        return areEqual(cells[0][0], cells[1][1], cells[2][2]) || areEqual(cells[0][2], cells[1][1], cells[2][0]);
    }

    private boolean hasThreeVerticalCells() {
        for (int i = 0; i <3; i++){
            if (areEqual(cells[0][i],cells[1][i],cells[2][i]))
                return true;
        }
        return false;
    }

    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || cell.getPlayer().getValue() == null || cell.getPlayer().getValue().length() == 0)
                return false;

        Cell comparisonBase = cells[0];
        for (int i = 1; i < cells.length; i++)
            if (!comparisonBase.getPlayer().getValue().equals(cells[i].getPlayer().getValue()))
                return false;

        return true;
    }

    public void reset() {
        player1 = null;
        player2 = null;
        cells = null;
        currentPlayer = null;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public MutableLiveData<Player> getWinner() {
        return winner;
    }

    public void setWinner(MutableLiveData<Player> winner) {
        this.winner = winner;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
