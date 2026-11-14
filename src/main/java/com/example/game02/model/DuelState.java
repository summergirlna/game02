package com.example.game02.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/// デュエルの状態定義
@Getter
@Setter
public class DuelState {

  private final DuelPlayer player;
  private final DuelPlayer cpu;
  private PlayerSide turnPlayer;
  private Phase phase;
  private PlayerSide winner;
  private final List<String> logs;

  public DuelState(DuelPlayer player, DuelPlayer cpu) {
    this.player = player;
    this.cpu = cpu;
    this.turnPlayer = PlayerSide.PLAYER;
    this.phase = Phase.DRAW;
    this.winner = null;
    this.logs = new ArrayList<>();
  }

  /// ゲーム終了かどうか
  ///
  /// @return 終了していればtrue
  public boolean isFinished() {
    return winner != null;
  }

  /// 今のプレイヤーターンは誰か
  public DuelPlayer getCurrentPlayer() {
    return turnPlayer == PlayerSide.PLAYER ? player : cpu;
  }

  /// 今のプレイヤーターンの相手は誰か
  public DuelPlayer getOpponentPlayer() {
    return turnPlayer == PlayerSide.PLAYER ? cpu : player;
  }

  /// ログを追加する
  public void addLog(String message) {
    logs.add(message);
  }
}
