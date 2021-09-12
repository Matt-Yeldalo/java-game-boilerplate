package tester;

import gameboilerplate.DisplayableEntity;
import gameboilerplate.Game;

import java.awt.*;

public class Test {
  public static void main(String[] args) {
    Game game = new Game(500, 500, Color.WHITE);
    game.addEntity(new Player());
    game.loop();
  }
  static class Player implements DisplayableEntity{

    @Override
    public void display(Graphics g) {
      g.setColor(Color.pink);
      g.fillRect(100, 100, 200, 200);
    }
  }
}
