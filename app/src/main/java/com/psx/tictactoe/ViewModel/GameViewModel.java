package com.psx.tictactoe.ViewModel;

import java.util.Observable;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayMap;

import com.psx.tictactoe.Model.Cell;
import com.psx.tictactoe.Model.Game;
import com.psx.tictactoe.Model.Player;

public class GameViewModel extends ViewModel {
    public ObservableArrayMap<String, String> cells = new ObservableArrayMap<>();
    public Game game;

    public void init(String player1, String player2) {
        game = new Game(player1, player2);
    }

   /* public GameViewModel(String player1, String player2) {
        game = new Game();
        beginGame(new Player(player1,"X"), new Player(player2,"O"));
    }*/

    public void beginGame (Player player1, Player player2) {
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setCurrentPlayer(player1);
    }

    public void onClickedCellAt(int row, int column) {
        if (game.getCells()[row][column] == null) {
            game.getCells()[row][column] = new Cell(game.getCurrentPlayer());
            cells.put(stringFromNumbers(row, column), game.getCurrentPlayer().getValue());
            if (game.hasGameEnded())
                game.reset();
            else
                game.switchPlayer();
        }
    }

   /* private void onGameEnded() {
        setChanged();
        notifyObservers(game.getWinner() == null ? "No Winner" : game.getWinner().getName());
        game.reset();
    }*/

    public LiveData<Player> getWinner_() {
        return game.getWinner();
    }

    private String stringFromNumbers(int row, int column) {
        return row+""+column;
    }
}
